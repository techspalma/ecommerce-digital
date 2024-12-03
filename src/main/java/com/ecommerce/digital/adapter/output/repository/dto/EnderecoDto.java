package com.ecommerce.digital.adapter.output.repository.dto;

import com.ecommerce.digital.domain.Endereco;
import jakarta.persistence.*;

// estão dentro da pasta adapter > output > repository > dto, pq são a comunicaçao com o banco de dados

@Entity  // essa anotação indica que é uma entidade do banco de dados. Com essa anotação o JPA saberá criar uma tabela
@Table(name="Endereco")  // anotação que dá o nome da tabela no banco de dados
public class EnderecoDto{
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;
        @Column(length = 60) // informo as característica de cada coluna. Se nao tiver alguma caract especial nao coloco
        String rua;
        @Column(length = 4)
        String numero;
        @Column(length = 60)
        String bairro;
        @Column(length = 60)
        String cidade;
        @Column(length = 2)
        String uf;
        @Column(length = 9)
        String cep;

        public EnderecoDto(Long id, String rua, String numero, String bairro, String cidade, String uf, String cep) {
                this.id = id;
                this.rua = rua;
                this.numero = numero;
                this.bairro = bairro;
                this.cidade = cidade;
                this.uf = uf;
                this.cep = cep;
        }

        public EnderecoDto() {
                super();
        }

        public EnderecoDto(Endereco endereco) {
                this(endereco.getId(),
                        endereco.getRua(),
                        endereco.getNumero(),
                        endereco.getBairro(),
                        endereco.getCidade(),
                        endereco.getUf(),
                        endereco.getCep()
                );
        }

        public Endereco toDomain() {
                return new Endereco(id, rua, numero, bairro, cidade, uf, cep);
        }
}