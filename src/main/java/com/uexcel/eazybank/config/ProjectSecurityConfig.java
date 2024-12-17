package com.uexcel.eazybank.config;

import com.uexcel.eazybank.exceptionhandling.CustomAccessDeniedHandler;
import com.uexcel.eazybank.exceptionhandling.CustomBasicAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Profile("prod")
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.requiresChannel(rc->rc.anyRequest().requiresSecure());
        http.sessionManagement(smc->smc
                .invalidSessionUrl("/invalidSession").maximumSessions(2).maxSessionsPreventsLogin(true));
        http.csrf(csrfConfig->csrfConfig.disable());
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/api/myAccounts","/api/myBalance").authenticated()
                .requestMatchers("/api/myLoans","/api/myCards").authenticated()
                .requestMatchers("/api/contact","/api/notices","/error").permitAll()
                .requestMatchers("/invalidSession","/api/register").permitAll()
                .anyRequest().authenticated());
        http.formLogin(withDefaults());
        http.httpBasic(hbc->hbc.authenticationEntryPoint(new CustomBasicAuthenticationEntryPoint()));
        http.exceptionHandling(ehc->ehc.accessDeniedHandler(new CustomAccessDeniedHandler()));
        return http.build();
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories
                .createDelegatingPasswordEncoder();
    }



}
