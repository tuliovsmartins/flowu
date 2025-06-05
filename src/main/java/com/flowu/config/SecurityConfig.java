@EnableWebSecurity
public class SecurityConfig {

    private final ExternalAuthFilter externalAuthFilter;

    public SecurityConfig(ExternalAuthFilter externalAuthFilter) {
        this.externalAuthFilter = externalAuthFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(externalAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
