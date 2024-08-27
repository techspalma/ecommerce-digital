
package com.ecommerce.digital.application.useCase;

import com.ecommerce.digital.adapter.output.repository.dto.UserDto;

import java.util.List;

public interface FindUsersUseCase {
    public List<UserDto> findAllUsers();
}