package br.com.emanoel.habilidades.security.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.*;
import com.auth0.jwt.interfaces.DecodedJWT;

import br.com.emanoel.habilidades.data.vo.v1.security.TokenVO;
import br.com.emanoel.habilidades.exceptions.InvalidJWTException;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class JwtTokenProvider {
	@Value("${security.jwt.token.secret-key:secret}")
	private String secretKey = "secret";

	@Value("${security.jwt.token.expire-lenght:360000}")
	private long validityMilliSeconds = 360000;

	@Autowired
	private UserDetailsService userDetailsService;

	Algorithm Algorithm = null;

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		Algorithm = Algorithm.HMAC256(secretKey.getBytes());
	}

	public TokenVO createAccessToken(String username, List<String> roles) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + validityMilliSeconds);
		var accessToken = getAccessToken(username, roles, now, validity);
		var refreshToken = getRefreshAccessToken(username, roles, now);
		return new TokenVO(username, true, now, validity, accessToken, refreshToken);
	}

	private String getRefreshAccessToken(String username, List<String> roles, Date now) {
		Date validityRefresh = new Date(now.getTime() + validityMilliSeconds * 3);
		return JWT.create().//
				withClaim("roles", roles).//
				withIssuedAt(now).//
				withExpiresAt(validityRefresh).//
				withSubject(username).//
				sign(Algorithm).//
				strip();
	}

	private String getAccessToken(String username, List<String> roles, Date now, Date validity) {
		String issuerUrl = ServletUriComponentsBuilder.//
				fromCurrentContextPath().build().toUriString();

		return JWT.create().//
				withClaim("roles", roles).//
				withIssuedAt(now).//
				withExpiresAt(validity).//
				withSubject(username).//
				withIssuer(issuerUrl).//
				sign(Algorithm).//
				strip();

	}

	public Authentication getAuthentication(String token) {
		DecodedJWT decodedJWT = decodedToken(token);
		UserDetails userDetails = this.userDetailsService.//
				loadUserByUsername(decodedJWT.getSubject());

		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	private DecodedJWT decodedToken(String token) {
		Algorithm alg = Algorithm.HMAC256(secretKey.getBytes());
		JWTVerifier verifier = JWT.require(alg).build();
		return verifier.verify(token);
	}

	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		if (bearerToken != "" && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring("Bearer ".length());
		}
		return null;
	}

	public boolean validateToken(String token) {
		DecodedJWT decodedJWT = decodedToken(token);
		try {
			if (decodedJWT.getExpiresAt().before(new Date())) {
				return false;
			}
			return true;
		} catch (Exception e) {
			throw new InvalidJWTException("Expired or invalid JWT token !");
		}

	}
}
