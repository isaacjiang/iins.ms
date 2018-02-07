package com.iins.system.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.ArrayList;
import java.util.Collection;

@EnableWebFluxSecurity
public class SecurityConfiguration {
    @Bean
    public MapReactiveUserDetailsService userDetailsRepository() {

        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();
        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        Collection<UserDetails> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        return new MapReactiveUserDetailsService(users);
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http    .csrf().disable()
                .authorizeExchange()
                .pathMatchers(HttpMethod.GET, "/api/**").permitAll()
                .pathMatchers(HttpMethod.POST, "/api/**").permitAll()
                //.pathMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
                .anyExchange()
                .authenticated()
                .and()
                .httpBasic().and()
                .formLogin();
        return http.build();
    }
}