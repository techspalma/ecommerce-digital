package com.ecommerce.digital.application.useCase;

import com.ecommerce.digital.domain.User;

public interface UpdateByUserIdUseCase {
    void updateUserById(int id, User user);
}
