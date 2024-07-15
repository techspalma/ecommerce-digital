package com.ecommerce.digital.adapter.input.rest;

import com.ecommerce.digital.adapter.input.rest.dto.UserDto;
import com.ecommerce.digital.application.useCase.EnrollUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Validated // utlizada para validar campos com o @Valid
public class UserController {


    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED) //coloco quando não retorno responseBody, e aí toda req que tiver sucesso devolve o HTTP indicado
    public void enroll(@Valid @RequestBody UserDto dataUser) { // o @Valid valida se o @NotNull e @NotBlank estão sendo satisfeitos para o body que estpu recebendo
        System.out.println(dataUser.nome() + " " + dataUser.cidade());

    }
}
