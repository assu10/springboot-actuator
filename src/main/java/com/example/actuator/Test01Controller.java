package com.example.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test01")
public class Test01Controller {

    @GetMapping
    public String method01() {
        return "hello01";
    }
}
