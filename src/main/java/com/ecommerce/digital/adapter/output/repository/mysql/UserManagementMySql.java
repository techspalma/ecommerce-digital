package com.ecommerce.digital.adapter.output.repository.mysql;

import com.ecommerce.digital.adapter.output.repository.dto.UserDto;
import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserManagementMySql implements UserManagementOutputPort {
    @Autowired
    UserRepository userRepository;

    @Override
    public User enroll(User user) {
        UserDto userDto = new UserDto(user);
        UserDto savedUser = userRepository.save(userDto);
        return savedUser.toDomain();
    }

    @Override
    public User findByMail(String email) {
        try {
            return userRepository.findByEmail(email).toDomain();
        } catch (Exception e){
            return null;
        } // @PALMA eu sei que isso está errado, mas minha intenção é fazer com que caso nao exista o mail cadastrado no banco ele retorne null. Qual a melhor forma de fazer isso?
    }

    @Override
    public List<User> findAll() {
        List<UserDto> usersList = userRepository.findAll();
        return usersList.stream().map(UserDto::toDomain).toList();
    }
}
