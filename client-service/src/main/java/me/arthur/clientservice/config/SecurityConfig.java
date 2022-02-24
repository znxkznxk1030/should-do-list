package me.arthur.clientservice.config;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import net.minidev.json.JSONObject;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.exceptionHandling()
        .authenticationEntryPoint((request, response, e) -> {
          Map<String, String> json = new HashMap<>();
          json.put("message", "Access Denied");

          response.setContentType("application/json;charset=UTF-8");
          response.setStatus(HttpServletResponse.SC_FORBIDDEN);
          response.getWriter().write(new JSONObject(json).toString());
        })
        .and()
        .cors()
        .and()
        .csrf().disable()
        .authorizeRequests()
        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
        .antMatchers("/authentication").permitAll()
        .antMatchers("/oauth2/**").permitAll()
        .antMatchers("/oauth/token").permitAll()
        .antMatchers("/login**").permitAll()
        .anyRequest().authenticated()
        .and()
        .oauth2Login()
          .successHandler(successHandler())
        .and()
        .formLogin().disable()
        .logout()
        .logoutSuccessUrl("/");
  }

  @Bean
  SimpleUrlAuthenticationSuccessHandler successHandler() {
    return new SimpleUrlAuthenticationSuccessHandler("http://localhost:3000/");
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();

    configuration.addAllowedOrigin("http://localhost:3000");
    configuration.addAllowedHeader("*");
    configuration.addAllowedMethod("*");
    configuration.setAllowCredentials(true);
    configuration.setMaxAge(3600L);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}
