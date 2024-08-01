package com.ecommerce.digital.application.ports.output;

import com.ecommerce.digital.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserManagementOutputPort {
    User enroll(User user);
    User findByMail(String email);
    List<User> findAllUsers();
    Optional<User> findById(int id);
}
