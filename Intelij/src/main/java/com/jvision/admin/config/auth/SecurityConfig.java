package com.jvision.admin.config.auth;


import com.jvision.admin.domain.users.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeHttpRequests(request -> request //URL별 권한 관리 설정
                        .requestMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                        .requestMatchers("/api/v1/**").hasAnyRole(Role.USER.name())
                        .anyRequest().authenticated() // 설정값들 이외의 URL은 인증된 사용자들(로그인한 사용자)에게만 허용
                )                                       // 로그아웃 기능에 대한 설정 진입점
                .logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login().//OAuth2 로그인 기능에 대한 설정 진입점
                userInfoEndpoint(). // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때 설정 담당
                userService(customOAuth2UserService); //소셜 로그인 성공시 UserService 인터페이스의 구현체 등록

        return http.build();
    }


}