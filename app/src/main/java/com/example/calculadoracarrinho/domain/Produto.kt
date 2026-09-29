package com.example.calculadoracarrinho.domain

data class Produto(
    val nome: String,
    val preco: Double,
    val descricao: String? = null,
    val descontoPercentual: Double = 0.0
) : Pagavel {

    override fun valorTotal(): Double {
        val desconto = preco * (descontoPercentual / 100.0)
        return preco - desconto
    }

    fun valorDesconto(): Double = preco * (descontoPercentual / 100.0)

    fun precoFinal(): Double = valorTotal()
}
