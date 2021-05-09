package com.yash.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		// SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver(); //
		// once we use AcceptHeaderLocaleResolver there is no need to put locale in
		// method parameter
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	/*
	 * @Bean public LocaleResolver localeResolver() { AcceptHeaderLocaleResolver
	 * localeResolver = new AcceptHeaderLocaleResolver();
	 * localeResolver.setDefaultLocale(Locale.US); return localeResolver; }
	 */

	/*
	 * can be specified in application.properties
	 * 
	 * @Bean public ResourceBundleMessageSource getBundleMessageSource() {
	 * ResourceBundleMessageSource bundleMessageSource = new
	 * ResourceBundleMessageSource(); bundleMessageSource.setBasename("messages");
	 * return bundleMessageSource;
	 * 
	 * }
	 */
//after configuring the LocalResolver and ResourceBundleMessageSource we need to update our service.
}
