package com.ecommerce.digital.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void givenValidInput_whenCreatingUser_thenUserIsConstructedCorrectly() {
        // given
        String nome = "Maran";
        int idade = 36;
        String email = "maran@gmail";
        Endereco endereco = new Endereco(null, "Ipiranga", "119", "Vila Barros", "Barueri", "SP", "06410-250");

        // when
        User user = new User(null, nome, email, idade, endereco);

        // then
        Assertions.assertEquals(nome, user.getNome());
        Assertions.assertEquals(idade, user.getIdade());
        Assertions.assertEquals(email, user.getEmail());
        Assertions.assertEquals(endereco, user.getEndereco());
    }
}
