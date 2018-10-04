package com.pucminas.desconto

enum AbrangenciaDesconto {
    GERAL("Geral"),
    CATEGORIA("Categoria"),
    FORNECEDOR("Fornecedor")

    String nome

    static def list() {
        [GERAL, CATEGORIA, FORNECEDOR]
    }

    AbrangenciaDesconto(String nome) {
        this.nome = nome
    }
}