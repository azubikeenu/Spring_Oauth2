package com.azubike.ellipsis.Spring_boot_oath2_example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

public class SpringSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().oauth2Login();
	}

	private ClientRegistration clientRegisteration() {
		return CommonOAuth2Provider.GITHUB.getBuilder("github").clientId("a3f1dc98fca69a8fde94")
				.clientSecret("a45b6f00df692ee85a929a58a128d84bfa511f9f").build();
	}

	@Bean
	private ClientRegistrationRepository clientRegistrationRepository() {
		ClientRegistration clientRegistration = clientRegisteration();
		return new InMemoryClientRegistrationRepository(clientRegistration);

	}

}
