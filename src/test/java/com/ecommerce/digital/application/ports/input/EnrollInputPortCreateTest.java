package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.domain.User;
import com.ecommerce.digital.domain.exceptions.ConflictException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class EnrollInputPortCreateTest {

    EnrollInputPortCreate enrollInputPortCreate;
    UserManagementOutputPort userPort;

    @BeforeEach
    void setUp() {
        userPort = Mockito.mock(UserManagementOutputPort.class);
        enrollInputPortCreate = new EnrollInputPortCreate();
        enrollInputPortCreate.userPort = userPort;
    }

    @Test
    void givenNewUser_whenExecute_thenUserIsEnrolled() {
        User newUser = new User();
        newUser.setEmail("newuser@example.com");

        when(userPort.findByMail("newuser@example.com")).thenReturn(null);

        enrollInputPortCreate.execute(newUser);

        verify(userPort, times(1)).enroll(newUser);
    }

    @Test
    void givenExistingUser_whenExecute_thenConflictExceptionIsThrown() {
        User existingUser = new User();
        existingUser.setEmail("existinguser@example.com");

        when(userPort.findByMail("existinguser@example.com")).thenReturn(existingUser);

        assertThrows(ConflictException.class, () -> enrollInputPortCreate.execute(existingUser));
        verify(userPort, never()).enroll(existingUser);
    }

    @Test
    void givenUserWithEmail_whenGetUserByEmail_thenReturnUser() {

        String email = "test@example.com";
        User expectedUser = new User();
        expectedUser.setEmail(email);

        when(userPort.findByMail(email)).thenReturn(expectedUser);

        User result = enrollInputPortCreate.getUserByEmail(email);

        verify(userPort, times(1)).findByMail(email);
        assert(result.equals(expectedUser));
    }
}