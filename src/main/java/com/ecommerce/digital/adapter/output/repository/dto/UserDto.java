package com.ecommerce.digital.adapter.output.repository.dto;

import jakarta.persistence.*;

@Entity
@Table(name="User")
public record UserDto(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Integer id,
        String nome,
        int idade,
        @OneToOne
        @JoinColumn(name="endereco_id", referencedColumnName = "id")
        EnderecoDto endereco) {
}
