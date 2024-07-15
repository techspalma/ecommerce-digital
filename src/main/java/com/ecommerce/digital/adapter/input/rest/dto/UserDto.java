package com.ecommerce.digital.adapter.input.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(
        @NotNull(message="Campo nome não pode ser null")
        @NotBlank(message="Campo nome não pode ser vazio")
        String nome,
        Integer idade,
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
}
