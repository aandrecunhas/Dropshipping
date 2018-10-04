package com.pucminas.desconto

class Desconto {
    String nome
    TipoDesconto tipo = TipoDesconto.FIXO
    AbrangenciaDesconto abrangenciaDesconto = AbrangenciaDesconto.GERAL
    Double valor
    String categoria
    String fornecedor
    static constraints = {
        categoria nullable: true
        fornecedor nullable: true
    }
}
