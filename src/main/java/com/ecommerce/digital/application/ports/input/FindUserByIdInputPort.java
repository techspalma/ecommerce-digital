package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.application.useCase.FindUserByIdUseCase;
import com.ecommerce.digital.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindUserByIdInputPort implements FindUserByIdUseCase {
    @Autowired
    UserManagementOutputPort userManagement;

    Logger logger = LoggerFactory.getLogger(FindUserByIdInputPort.class);

    @Override
    public Optional<User> findById(int id) {
        logger.info("Início de busca de usuário na camada de aplicação");
        var user = userManagement.findById(id);
        logger.info("Fim de busca de usuário na camada de aplicação");
        return user;
    }
}
