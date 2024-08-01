package com.ecommerce.digital.application.useCase;

import com.ecommerce.digital.domain.User;

import java.util.List;

public interface FindAllUsersUseCase {
    List<User> findAllUsers();
}
