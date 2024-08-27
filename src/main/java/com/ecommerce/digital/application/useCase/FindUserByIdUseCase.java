package com.ecommerce.digital.application.useCase;

import com.ecommerce.digital.domain.User;

import java.util.Optional;

public interface FindUserByIdUseCase {
    Optional<User> findById(int id);
}
