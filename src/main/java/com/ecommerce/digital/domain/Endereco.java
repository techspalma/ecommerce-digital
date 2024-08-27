package com.ecommerce.digital.domain;

// domínio é tudo aquilo que se refere à lógica de negócios
// aqui não utilizou-se o Lombok para gerar construtor e metodos de get/set, pois a customização das regras ficam mais difíceis de serem efetuadas.
// assim como não forma adicionados os setters já que a informaçao deve vir na chamada pelo controller.

public class Endereco {
    private final Long id;
    private final String rua;
    private final String numero;
    private final String bairro;
    private final String cidade;
    private final String uf;
    private final String cep;

    // no construtor abaixo, já se fazem as validações de negócio e lança o erro caso o campo seja nulo.
    public Endereco(Long id, String rua, String numero, String bairro, String cidade, String uf, String cep) {
        if (rua == null) throw new RuntimeException("not be null");
        if (numero == null) throw new RuntimeException("not be null");
        if (bairro == null) throw new RuntimeException("not be null");
        if (cidade == null) throw new RuntimeException("not be null");
        if (uf == null) throw new RuntimeException("not be null");
        if (cep == null) throw new RuntimeException("not be null");
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }
}
