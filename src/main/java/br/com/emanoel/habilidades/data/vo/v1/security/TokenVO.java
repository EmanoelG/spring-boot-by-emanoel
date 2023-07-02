package br.com.emanoel.habilidades.data.vo.v1.security;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TokenVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String userName;
	private Boolean authenticated;
	private Date created;
	private Date expiration;
	private Date accessToken;
	private Date refreshToken;

	public TokenVO() {
	};

	public TokenVO(String userName, Boolean authenticated, Date created, Date expiration, Date accessToken,
			Date refreshToken) {
		super();
		this.userName = userName;
		this.authenticated = authenticated;
		this.created = created;
		this.expiration = expiration;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Date getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(Date accessToken) {
		this.accessToken = accessToken;
	}

	public Date getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(Date refreshToken) {
		this.refreshToken = refreshToken;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessToken, authenticated, created, expiration, refreshToken, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenVO other = (TokenVO) obj;
		return Objects.equals(accessToken, other.accessToken) && Objects.equals(authenticated, other.authenticated)
				&& Objects.equals(created, other.created) && Objects.equals(expiration, other.expiration)
				&& Objects.equals(refreshToken, other.refreshToken) && Objects.equals(userName, other.userName);
	}

}
