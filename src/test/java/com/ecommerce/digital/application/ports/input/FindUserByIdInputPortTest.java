package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class FindUserByIdInputPortTest {

    @Mock
    private UserManagementOutputPort userManagementOutputPort;

    @InjectMocks
    private FindUserByIdInputPort findUserByIdInputPort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenAValidUserId_whenFindByUserId_thenReturnUserById() {
        int userId = 2;
        User user = new User(2L, "Maran", "maranmorimoto@gmail.com", 36, "Rua Céu", "456" , "Vila Ancora", "Sao Paulo", "SP", "02565-855");
        when(userManagementOutputPort.findById(userId)).thenReturn(Optional.of(user));

        Optional<User> result = findUserByIdInputPort.findById(userId);

        assertTrue(result.isPresent());
        assertEquals(userId, result.get().getId());
        assertEquals("Maran", result.get().getNome());
        assertEquals("maranmorimoto@gmail.com", result.get().getEmail());
        verify(userManagementOutputPort, times(1)).findById(userId);
    }

    @Test
    void givenANonValidUserId_whenFindByUserId_thenReturnIsEmpty() {
        int userId = 1;
        when(userManagementOutputPort.findById(userId)).thenReturn(Optional.empty());

        Optional<User> result = findUserByIdInputPort.findById(userId);

        assertTrue(result.isEmpty());
        verify(userManagementOutputPort, times(1)).findById(userId);
    }
}