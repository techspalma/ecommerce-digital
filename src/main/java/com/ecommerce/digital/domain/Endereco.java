package com.ecommerce.digital.domain;

public class Endereco {

    private final String rua;
    private final String numero;
    private final String bairro;
    private final String cidade;
    private final String uf;
    private final String cep;

    public Endereco(String rua, String numero, String bairro, String cidade, String uf, String cep) {
        if (rua == null) throw new RuntimeException("not be null");
        if (numero == null) throw new RuntimeException("not be null");
        if (bairro == null) throw new RuntimeException("not be null");
        if (cidade == null) throw new RuntimeException("not be null");
        if (uf == null) throw new RuntimeException("not be null");
        if (cep == null) throw new RuntimeException("not be null");
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
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
