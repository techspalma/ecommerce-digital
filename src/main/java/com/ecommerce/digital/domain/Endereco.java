package com.ecommerce.digital.domain;

import javax.management.RuntimeMBeanException;

public class Endereco {

    private String rua;
    private String bairro;

    public Endereco(String rua, String bairro) {

        if (rua == null) throw new RuntimeException("not be null");
        this.rua = rua;
        this.bairro = bairro;
    }
}
