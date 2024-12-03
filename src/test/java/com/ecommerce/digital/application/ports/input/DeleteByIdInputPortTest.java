package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

class DeleteByIdInputPortTest {

    @Mock
    private UserManagementOutputPort userManagement;

    @InjectMocks
    private DeleteUserByIdInputPort deleteUserByIdInputPort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenUserId_whenDeleteUserById_thenCallDeleteUserById() {
        int userId = 123;

        deleteUserByIdInputPort.deleteUserById(userId);

        verify(userManagement, times(1)).deleteUserById(userId);
    }
}
