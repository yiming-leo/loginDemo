package com.example.logindemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
                // ACCESS ANY RESOURCE IS DENIED EXCEPT "/", "/login"
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/login")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                //// LOGIN PAGE & LOGIN JUMP PAGE DEFINE
                //.formLogin(form -> form
                //        .loginPage("/login")
                //        .defaultSuccessUrl("/dashboard", true)
                //        .permitAll())
                // LOGOUT JUMP PAGE DEFINE
                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                );
        return httpSecurity.build();
    }
}
