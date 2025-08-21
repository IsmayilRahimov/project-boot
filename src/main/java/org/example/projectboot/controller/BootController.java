package org.example.projectboot.controller;

import lombok.RequiredArgsConstructor;
import org.example.projectboot.service.BootService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boot")


public class BootController {

    private final BootService bootService;

    @GetMapping("/hello")

    public String boot() {
        return bootService.printhello();
    }


}
