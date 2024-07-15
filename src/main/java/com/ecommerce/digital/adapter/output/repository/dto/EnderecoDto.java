package com.ecommerce.digital.adapter.output.repository.dto;

import jakarta.persistence.*;

// estão dentro da pasta adapter > output > repository > dto, pq são a comunicaçao com o banco de dados

@Entity  // essa anotação indica que é uma entidade do banco de dados. Com essa anotação o JPA saberá criar uma tabela
@Table(name="Endereco")  // anotação que dá o nome da tabela no banco de dados
public record EnderecoDto(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        Integer id,
        @Column(length = 60) // informo as característica de cada coluna. Se nao tiver alguma caract especial nao coloco
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
