package com.example.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test02")
public class Test02Controller {

    @GetMapping
    public String method02() {
        return "hello02";
    }
}
