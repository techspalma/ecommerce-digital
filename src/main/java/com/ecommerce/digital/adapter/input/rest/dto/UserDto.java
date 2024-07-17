package com.ecommerce.digital.adapter.input.rest.dto;

import com.ecommerce.digital.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UserDto(
        @NotNull(message="Campo nome não pode ser null")
        @NotBlank(message="Campo nome não pode ser vazio")
        String nome,
        @Positive(message="Campo idade deve ser maior que zero")
        Integer idade,
        @NotNull(message="Campo email não pode ser null")
        @NotBlank(message="Campo email não pode ser vazio")
        @Email(message="Campo email deve ser válido")
        String email,
        @NotNull(message="Campo rua não pode ser null")
        @NotBlank(message="Campo rua não pode ser vazio")
        String rua,
        @NotNull(message="Campo nome não pode ser null")
        @NotBlank(message="Campo nome não pode ser vazio")
        String numero,
        @NotNull(message="Campo nome não pode ser null")
        @NotBlank(message="Campo nome não pode ser vazio")
        String bairro,
        @NotNull(message="Campo cidade não pode ser null")
        @NotBlank(message="Campo cidade não pode ser vazio")
        String cidade,
        @NotNull(message="Campo UF não pode ser null")
        @NotBlank(message="Campo UF não pode ser vazio")
        String uf,
        @NotNull(message="Campo cep não pode ser null")
        @NotBlank(message="Campo cep não pode ser vazio")
        String cep) {

        public User toDomain() {
                return new User(nome, email, idade, rua, numero, bairro, cidade, uf, cep);
        }
}
