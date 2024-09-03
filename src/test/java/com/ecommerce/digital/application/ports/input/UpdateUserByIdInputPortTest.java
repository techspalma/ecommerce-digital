package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UpdateUserByIdInputPortTest {

    @Mock
    private UserManagementOutputPort userManagement;

    @InjectMocks
    private UpdateUserByIdInputPort updateUserByIdInputPort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenAValidUserId_whenUserExists_thenShouldUpdateUser() {
        int userId = 2;
        User existingUser = new User(2L, "Maran", "maranmorimoto@uol.com", 36, "Rua Céu", "789" , "Vila Ancora", "Sao Paulo", "SP", "02565-855");
        User updatedUser = new User(2L, "Maran", "maranmorimoto@gmail.com", 36, "Rua Céu", "456" , "Vila Ancora", "Sao Paulo", "SP", "02565-855");

        when(userManagement.findById(userId)).thenReturn(Optional.of(existingUser));

        updateUserByIdInputPort.updateUserById(userId, updatedUser);

        verify(userManagement, times(1)).updateUser(any());
    }

    @Test
    void givenAValidUserId_whenUserDoesNotExist_thenShouldOnlyEnrollUser() {
        int userId = 2;
        User updatedUser = new User(2L, "Maran", "maranmorimoto@gmail.com", 36, "Rua Céu", "456", "Vila Ancora", "Sao Paulo", "SP", "02565-855");

        when(userManagement.findById(userId)).thenReturn(Optional.empty());

        updateUserByIdInputPort.updateUserById(userId, updatedUser);

        verify(userManagement, times(0)).updateUser(any());
        verify(userManagement, times(1)).enroll(updatedUser);
    }
}

