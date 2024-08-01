package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.application.useCase.FindUserByIdUseCase;
import com.ecommerce.digital.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FindUserByIdInputPort implements FindUserByIdUseCase {
    @Autowired
    UserManagementOutputPort userManagement;

    @Override
    public Optional<User> findById(int id) {
        return userManagement.findById(id);
    }
}
