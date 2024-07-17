package com.ecommerce.digital.adapter.output.repository.dto;

import jakarta.persistence.*;

// esse DTO foi adicionado em adapter > input > rest > dto pq
@Entity // essa anotação indica que é uma entidade do banco de dados. Com essa anotação o JPA saberá criar uma tabela
@Table(name="User") // anotação que dá o nome da tabela no banco de dados
public record UserDto( // o record é utilizado a partir do Java 21 e facilita a escrita.
        @Id //anotação que informa o framework JPA qual atributo da tabela será o Id
        @GeneratedValue(strategy = GenerationType.AUTO) // anotação que gera automaticamente valores de Id
        Integer id,
        String nome,
        String email,
        int idade,
        @OneToOne // indica o tipo de relação com a outra tabela. No caso daqui, um endereço dessa tabela corresposnde a um endereço da tabela de endereço
        @JoinColumn(name="endereco_id", referencedColumnName = "id") // indica onde é feita a junção entre tabelas. E nesse caso informa que os Ids citados nessa tabela correspondem à coluna de endereço_id
        EnderecoDto endereco) {
}
