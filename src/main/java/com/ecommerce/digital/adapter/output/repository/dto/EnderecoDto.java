package com.ecommerce.digital.adapter.output.repository.dto;

import jakarta.persistence.*;

@Entity
@Table(name="Endereco")
public record EnderecoDto(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        Integer id,
        @Column(length = 60)
        String rua,
        @Column(length = 4)
        String numero,
        @Column(length = 60)
        String bairro,
        @Column(length = 60)
        String cidade,
        @Column(length = 2)
        String uf,
        @Column(length = 9)
        String cep) {
}
