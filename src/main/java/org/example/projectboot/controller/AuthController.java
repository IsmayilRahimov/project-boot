package org.example.projectboot.controller;

import org.example.projectboot.jwt.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private static final JwtUtil jwtUtill = new JwtUtil();

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        if (username.equals("Admin") && password.equals("1234")) {
            String token = jwtUtill.generateToken(username);

            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Invalid username or password");
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validate(@RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.replace("Bearer ", "");
            String username = jwtUtill.validateTokenUsername(token);
            return ResponseEntity.ok("Welcome" + username + " !");
        } catch (Exception e) {
            return ResponseEntity.status(403).body("Invalid token");
        }
    }

}
