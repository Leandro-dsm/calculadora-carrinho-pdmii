package com.example.calculadoracarrinho.domain

data class ItemCarrinho(
    val produto: Produto,
    val quantidade: Int
) : Pagavel {

    override fun valorTotal(): Double {
        return produto.precoFinal() * quantidade
    }

    fun subtotalBruto(): Double = produto.preco * quantidade

    fun totalDesconto(): Double = produto.valorDesconto() * quantidade
}