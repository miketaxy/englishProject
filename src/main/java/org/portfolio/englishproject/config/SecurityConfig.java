package org.portfolio.englishproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/**").permitAll() //TODO: Should be authenticated
                                .anyRequest().permitAll())
                .formLogin(form ->
                        form.loginPage("/login")
                                .permitAll())
                .logout(logout -> logout.logoutUrl("/logout"))
                .csrf(AbstractHttpConfigurer::disable) //TODO: Csrf must be enabled
                .addFilterBefore(jwtAuthenticationFilter(), JwtAuthenticationFilter.class);
        return http.build();

    }
}
