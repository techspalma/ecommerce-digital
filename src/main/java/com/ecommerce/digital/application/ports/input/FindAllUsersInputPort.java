package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.application.useCase.FindAllUsersUseCase;
import com.ecommerce.digital.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FindAllUsersInputPort implements FindAllUsersUseCase {
    @Autowired
    UserManagementOutputPort userManagement;

    @Override
    public List<User> findAllUsers() {
        return userManagement.findAllUsers();
    }
}
