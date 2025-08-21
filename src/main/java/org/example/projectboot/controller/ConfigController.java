package org.example.projectboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @GetMapping("/admin")
    public String admin() {
        return "Admin page - Only for Admin";
    }

}
