package org.example.projectboot.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.projectboot.service.BootService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BootServiceImpl implements BootService {
    @Override

    public String printhello() {
        return "Hello World";
    }
}
