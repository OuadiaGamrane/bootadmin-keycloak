package ma.oga.microsystemes.dashboard.config;

import de.codecentric.boot.admin.web.client.HttpHeadersProvider;
import ma.oga.microsystemes.dashboard.filter.CatHandler;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.OAuth2Constants;
import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootProperties;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@KeycloakConfiguration
@EnableConfigurationProperties(KeycloakSpringBootProperties.class)
class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

	@Bean
	public HttpHeadersProvider httpHeadersProvider(Keycloak keycloak) {
		return (app) -> {
			String accessToken = keycloak.tokenManager().getAccessTokenString();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer " + accessToken);
			return headers;
		};
	}


	@Bean
	public Keycloak keycloak(KeycloakSpringBootProperties props) {
		return KeycloakBuilder.builder()
				.serverUrl(props.getAuthServerUrl())
				.realm(props.getRealm())
				.grantType(OAuth2Constants.CLIENT_CREDENTIALS)
				.clientId(props.getResource())
				.clientSecret((String) props.getCredentials().get("secret"))
				.build();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);

		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/**/*.css", "/admin/img/**", "/admin/third-party/**").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")
				.anyRequest().permitAll().and().exceptionHandling().accessDeniedHandler(new CatHandler());
	}

	@Bean
	public GrantedAuthoritiesMapper grantedAuthoritiesMapper() {
		SimpleAuthorityMapper mapper = new SimpleAuthorityMapper();
		mapper.setConvertToUpperCase(true);
		return mapper;
	}


	@Bean
	public KeycloakConfigResolver keycloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
		keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(grantedAuthoritiesMapper());
		auth.authenticationProvider(keycloakAuthenticationProvider);
	}

	@Bean
	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new NullAuthenticatedSessionStrategy();
	}
}
