package com.example.logindemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author 24797
 * @version 1.0
 * @description a config file for spring security
 * @date 2025/12/13 20:26
 */

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    // / : root address, public access
    // /hello_world : Test API address, auth access
    // /login : Login Page address, public access
    // /dashboard : Dashboard address, /login -> /dashboard, auth access

    /**
     * @param httpSecurity
     * @return org.springframework.security.web.SecurityFilterChain
     * @author 24797
     * @description Define the Page & Resource's Control Policy: which page can be read or need auth
     * @date 2025/12/13 21:39
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                //DENY CSRF
                .csrf(csrf -> csrf.disable())
                // ACCESS ANY RESOURCE IS DENIED EXCEPT "/api/login"
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/login")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                //
                .securityContext(securityContext ->
                        securityContext.requireExplicitSave(false)
                )
                //.httpBasic()
                // UN-AUTHED HANDLING
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint((request, response, authException) ->
                                {
                                    response.setContentType("application/json");
                                    response.setStatus(401);
                                    response.getWriter().write("{\"error\":\"Please login first\"}");
                                }
                        )
                )
                // Session Management, when login successfully, a session could be auto storage
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                        // 顶号 or not
                        .maximumSessions(2)
                        .maxSessionsPreventsLogin(false)
                );
        return httpSecurity.build();
    }

    /**
     * @param authenticationConfiguration spring security's auth main entrance
     * @return org.springframework.security.authentication.AuthenticationManager* @
     * @description Expose the Manager, could use it in @service
     * @author 24797
     * @date 2025/12/14 14:27
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
    *
    * @return PasswordEncoder
    * @author 24797
    * @date 2025/12/14 16:05
    */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
