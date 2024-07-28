package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.adapter.output.repository.dto.UserDto;
import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.application.useCase.EnrollUseCase;
import com.ecommerce.digital.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrollInputPortCreate implements EnrollUseCase {

    @Autowired
    UserManagementOutputPort userPort;

    @Override
    public void execute(User user) {

        //primeiro verifica se existe o usuário no banco utilizando e-mail
        if (getUserByEmail(user.getEmail()) == null) {
            userPort.enroll(user);
        };
        // quero que devolva um erro ou um aviso dizendo que o email ja está cadastrado.
    }

    public User getUserByEmail(String email) {
        return userPort.findByMail(email);
    }
}




