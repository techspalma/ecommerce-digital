package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.adapter.input.rest.UserController;
import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.application.useCase.DeleteByUserIdUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserByIdInputPort implements DeleteByUserIdUseCase {
    @Autowired
    UserManagementOutputPort userManagement;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public void deleteUserById(int id) {
        logger.info("Início deleção de usuário na camada aplicação");
        userManagement.deleteUserById(id);
        logger.info("Fim deleção de usuário na camada aplicação");
    }
}
