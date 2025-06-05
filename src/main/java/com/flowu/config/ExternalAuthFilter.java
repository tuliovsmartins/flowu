
@Component
public class ExternalAuthFilter extends OncePerRequestFilter {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

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
                    "https://trilliam.com.br/api/v1/auth/validate/",
                    HttpMethod.GET,
                    entity,
                    Map.class
            );

            Object success = authResponse.getBody().get("success");

            if (Boolean.TRUE.equals(success)) {
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        } catch (Exception ex) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
