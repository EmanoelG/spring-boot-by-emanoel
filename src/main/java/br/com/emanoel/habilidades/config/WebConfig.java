package br.com.emanoel.habilidades.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

//	@Override Param
//	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		configurer.favorParameter(true).parameterName("MediaType").ignoreAcceptHeader(true)
//				.useRegisteredExtensionsOnly(false).defaultContentType(MediaType.APPLICATION_JSON)
//				.mediaType("json", MediaType.APPLICATION_JSON).mediaType("xml", MediaType.APPLICATION_XML);
//
//		WebMvcConfigurer.super.configureContentNegotiation(configurer);
//	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(false).useRegisteredExtensionsOnly(false)
				.defaultContentType(MediaType.APPLICATION_JSON).mediaType("json", MediaType.APPLICATION_JSON)
				.mediaType("xml", MediaType.APPLICATION_XML);

		WebMvcConfigurer.super.configureContentNegotiation(configurer);
	}

}
