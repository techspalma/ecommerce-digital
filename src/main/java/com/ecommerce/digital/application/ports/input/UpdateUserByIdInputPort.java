package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.application.useCase.UpdateByUserIdUseCase;
import com.ecommerce.digital.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateUserByIdInputPort implements UpdateByUserIdUseCase {

    @Autowired
    UserManagementOutputPort userManagement;

    @Override
    public void updateUserById(int id, User user) {
        Optional<User> userFromDb = userManagement.findById(id);
        if (userFromDb.isPresent()) {
            userFromDb.get().update(user);
            user.setId((long) id);
            userManagement.updateUser(user);
        }
        userManagement.enroll(user);
    }
}
