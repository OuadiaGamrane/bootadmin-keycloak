package ma.oga.microsystemes.myservice.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

public class SecurityAdapter extends
    AbstractHttpConfigurer<SecurityAdapter, HttpSecurity> {

  @Override
  public void init(HttpSecurity http) throws Exception {
    // any method that adds another configurer
    // must be done in the init method
    http
        // disable csrf because of API mode
        .csrf().disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        .and()
        // manage routes securisation here
        .authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()

        // manage routes securisation here
        .and()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS).permitAll()
        .antMatchers("/logout", "/", "/unsecured").permitAll()
        .antMatchers("/**").authenticated()
        .anyRequest().permitAll();
  }
}
