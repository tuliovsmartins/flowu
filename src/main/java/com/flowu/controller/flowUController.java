package com.flowu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1")
public class flowUController {

    @RequestMapping(value = "/health", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Object> healthCheck() {
        return ResponseEntity.ok().body(new HealthResponse("I'm Alive"));
    }

    private static class HealthResponse {
        private final String message;

        public HealthResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}