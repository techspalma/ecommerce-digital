package com.ecommerce.digital.domain;

public class User {

    private Long id;
    private String nome;
    private Integer idade;
    private Endereco endereco;

    public User(String nome, Integer idade, String rua, String numero, String bairro, String cidade, String uf, String cep) {

        if (nome == null) throw new IllegalArgumentException("Campo requerido");
        if (idade == null & idade <=  0) throw new IllegalArgumentException("Campo requerido");
        this.nome = nome;
        this.idade = idade;
        this.endereco = new Endereco(rua, numero, bairro, cidade, uf, cep);
    }

    public User(String nome, Integer idade, Endereco endereco) {

        if (nome  == null) throw new IllegalArgumentException("Campo requerido");
        if (idade == null & idade <=  0) throw new IllegalArgumentException("Campo requerido");
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
