package com.ecommerce.digital.adapter.input.rest;

import com.ecommerce.digital.adapter.input.rest.dto.UserDto;
import com.ecommerce.digital.application.useCase.*;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Autowired
    DeleteByUserIdUseCase deleteByUserIdUseCase;
    @Autowired
    UpdateByUserIdUseCase updateByUserIdUseCase;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // coloco quando não retorno responseBody, e aí toda req que tiver sucesso devolve o HTTP indicado
    public void enrollUser(@Valid @RequestBody UserDto dataUser) { // o @Valid valida se o @NotNull e @NotBlank estão sendo satisfeitos para o body que estpu recebendo
        logger.info("Início processamento de criação de usuário");
        enrollUseCase.execute(dataUser.toDomain());
        logger.info("Fim processamento de criação de usuário");
    }

    @GetMapping
    public ResponseEntity<?> findAllUsers(@RequestParam(name="pageNumber") int pageNumber, @RequestParam(name="size") int size) {
        logger.info("Início processamento de busca de usuários");
        var usersList = findAllUsersUseCase.findAllUsers(pageNumber, size);
        logger.info("Fim processamento de busca de usuários");
        return ResponseEntity.ok(usersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable int id) {
        logger.info("Início processamento de busca de usuário por id");
        var user = findUserByIdUseCase.findById(id);
        logger.info("Fim processamento de busca de usuário por id");
        return ResponseEntity.ok(user);
    }

//    @GetMapping
//    public ResponseEntity<?> findUserById2(@RequestParam int id) {
//        logger.info("Início processamento de busca de usuário por id");
//        var user = findUserByIdUseCase.findById(id);
//        logger.info("Fim processamento de busca de usuário por id");
//        return ResponseEntity.ok(user);
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable int id) {
        logger.info("Início processamento de deleção de usuário por id");
        deleteByUserIdUseCase.deleteUserById(id);
        logger.info("Fim processamento de deleção de usuário por id");
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserById(@PathVariable int id, @Valid @RequestBody UserDto dataUser) {
        logger.info("Início processamento de atualizaçao de usuário por id");
        updateByUserIdUseCase.updateUserById(id, dataUser.toDomain());
        logger.info("Fim processamento de atualizaçao de usuário por id");
    }
}
