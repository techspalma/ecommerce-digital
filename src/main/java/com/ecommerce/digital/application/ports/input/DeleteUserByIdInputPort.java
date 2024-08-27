package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.application.useCase.DeleteByUserIdUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserByIdInputPort implements DeleteByUserIdUseCase {
    @Autowired
    UserManagementOutputPort userManagement;

    @Override
    public void deleteUserById(int id) {
        userManagement.deleteUserById(id);
    }
}
