package com.ecommerce.digital.adapter.input.rest;

import com.ecommerce.digital.adapter.input.rest.dto.UserDto;
import com.ecommerce.digital.application.useCase.EnrollUseCase;
import com.ecommerce.digital.application.useCase.FindAllUsersUseCase;
import com.ecommerce.digital.application.useCase.FindUserByIdUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Validated // utilizada para validar campos com o @Valid
public class UserController {

    @Autowired
    EnrollUseCase enrollUseCase;
    @Autowired
    FindAllUsersUseCase findAllUsersUseCase;
    @Autowired
    FindUserByIdUseCase findUserByIdUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // coloco quando não retorno responseBody, e aí toda req que tiver sucesso devolve o HTTP indicado
    public void enrollUser(@Valid @RequestBody UserDto dataUser) { // o @Valid valida se o @NotNull e @NotBlank estão sendo satisfeitos para o body que estpu recebendo
        enrollUseCase.execute(dataUser.toDomain());
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllUsers() {
        return ResponseEntity.ok(findAllUsersUseCase.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable int id) {
        return ResponseEntity.ok(findUserByIdUseCase.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> findUserById2(@RequestParam int id) {
        return ResponseEntity.ok(findUserByIdUseCase.findById(id));
    }
}
