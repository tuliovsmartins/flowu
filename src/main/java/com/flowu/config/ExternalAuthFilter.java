package com.flowu.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Collections;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ExternalAuthFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(ExternalAuthFilter.class);
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    protected void doFilterInternal( @NonNull HttpServletRequest request,
                                     @NonNull HttpServletResponse response,
                                     @NonNull FilterChain filterChain) throws ServletException, IOException {


        if (request.getRequestURI().contains("/api/v1/health")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        String token = authHeader.substring(7); // remove "Bearer "

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<Map> authResponse = restTemplate.exchange(
                    "https://api.trilliam.com.br/api/v1/auth/validate/",
                    HttpMethod.POST,
                    entity,
                    Map.class
            );
            Object success = authResponse.getBody().get("success");
            if (Boolean.TRUE.equals(success) ||
                    (success instanceof String && "true".equalsIgnoreCase((String) success)) ||
                    (success instanceof Boolean && ((Boolean) success))) {
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        "email",  null,
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")) // authorities
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        } catch (Exception ex) {
            logger.info("exception:", ex);
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
