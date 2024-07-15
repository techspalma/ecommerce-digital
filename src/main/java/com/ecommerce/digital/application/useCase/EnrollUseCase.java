package com.ecommerce.digital.application.useCase;

import com.ecommerce.digital.adapter.output.repository.dto.UserDto;
import com.ecommerce.digital.domain.User;

public interface EnrollUseCase {
    public void execute(User user);
}
