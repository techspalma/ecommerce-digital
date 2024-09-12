package com.ecommerce.digital.adapter.output.repository.mysql;

import com.ecommerce.digital.adapter.output.repository.dto.UserDto;
import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
        UserDto userDto =  userRepository.findByEmail(email);
        if (userDto != null) {
            return userDto.toDomain();
        } else {
            return null;
        }
    }

    @Override
    public List<User> findAllUsers(int pageNumber, int size) {
        Page<UserDto> usersList = userRepository.findAll(PageRequest.of(pageNumber, size));
        return usersList.stream().map(UserDto::toDomain).toList();
    }

    @Override
    public Optional<User> findById(int id) {
        Optional<UserDto> usersById = userRepository.findById(id);
        if (usersById.isPresent()) {
            // faço a transformação de UserDto pra User e retorno
            var userId = usersById.map(UserDto::toDomain);
            return userId;
        }
        return Optional.empty();
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        UserDto userDto = new UserDto(user);
        userRepository.save(userDto);
    }
}
