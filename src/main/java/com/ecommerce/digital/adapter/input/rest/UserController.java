package com.ecommerce.digital.adapter.input.rest;

import com.ecommerce.digital.adapter.input.rest.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public void enroll(@RequestBody UserDto dataUser) {

        // cadastra o usuario em um repositório
    }
}
