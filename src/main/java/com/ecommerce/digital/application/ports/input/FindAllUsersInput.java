package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.adapter.output.repository.dto.UserDto;
import com.ecommerce.digital.adapter.output.repository.mysql.UserRepository;
import com.ecommerce.digital.application.useCase.FindUsersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllUsersInput implements FindUsersUseCase {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> findAllUsers() {
        return userRepository.findAll();
    }
}
