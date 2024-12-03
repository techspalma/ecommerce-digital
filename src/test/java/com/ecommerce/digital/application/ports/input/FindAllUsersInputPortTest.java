package com.ecommerce.digital.application.ports.input;

import com.ecommerce.digital.application.ports.output.UserManagementOutputPort;
import com.ecommerce.digital.application.ports.input.FindAllUsersInputPort;
import com.ecommerce.digital.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FindAllUsersInputPortTest {
    @Mock
    private UserManagementOutputPort userManagement;

    @InjectMocks
    private FindAllUsersInputPort findAllUsersInputPort;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllUsers() {
        int userId = 2;
        User user1 = new User(2L, "Maran", "maranmorimoto@gmail.com", 36, "Rua Céu", "456" , "Vila Ancora", "Sao Paulo", "SP", "02565-855");

        int anotherUserId = 3;
        User user2 = new User(3L, "Vivian", "vivian@gmail.com", 30, "Rua Céu", "456" , "Vila Ancora", "Sao Paulo", "SP", "02565-855");
        List<User> expectedUsers = Arrays.asList(user1, user2);

        when(userManagement.findAllUsers(0, 10)).thenReturn(expectedUsers);

        List<User> actualUsers = findAllUsersInputPort.findAllUsers(0, 10);

        assertEquals(expectedUsers, actualUsers);
    }
}
