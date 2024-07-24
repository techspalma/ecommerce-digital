package com.ecommerce.digital.domain;

public class User {

    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private Endereco endereco;

    public User(Long id, String nome, String email, Integer idade, String rua, String numero, String bairro, String cidade, String uf, String cep) {

        if (nome == null) throw new IllegalArgumentException("Campo requerido");
        if (idade == null & idade <=  0) throw new IllegalArgumentException("Campo requerido");
        if (email == null) throw new IllegalArgumentException("Campo requerido");
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.endereco = new Endereco(rua, numero, bairro, cidade, uf, cep);
    }

    public User(Long id, String nome, String email, Integer idade, Endereco endereco) {

        if (nome  == null) throw new IllegalArgumentException("Campo requerido");
        if (email  == null) throw new IllegalArgumentException("Campo requerido");
        if (idade == null & idade <=  0) throw new IllegalArgumentException("Campo requerido");
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
