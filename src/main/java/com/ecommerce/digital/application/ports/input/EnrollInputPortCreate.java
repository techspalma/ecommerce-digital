package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.application.useCase.EnrollUseCase;
import com.ecommerce.digital.domain.User;
import com.ecommerce.digital.domain.exceptions.ConflictException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrollInputPortCreate implements EnrollUseCase {

    @Autowired
    UserManagementOutputPort userPort;

    @Override
    public void execute(User user) {
        if (getUserByEmail(user.getEmail()) == null) {
            userPort.enroll(user);
        } else{
            throw new ConflictException("Usuário já foi cadastrado");
        }
    }

    public User getUserByEmail(String email) {
        return userPort.findByMail(email);
    }
}




