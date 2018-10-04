package com.pucminas.desconto

enum TipoDesconto {
    FIXO("Fixo"),
    PORCENTAGEM("Porcentagem")

    String nome

    static def list() {
        [FIXO, PORCENTAGEM]
    }

    TipoDesconto(String nome) {
        this.nome = nome
    }
}