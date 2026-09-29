package com.example.calculadoracarrinho.domain

object CalculosCarrinho {

    fun subtotalBruto(itens: List<ItemCarrinho>): Double =
        itens.sumOf { it.subtotalBruto() }

    fun totalDescontos(itens: List<ItemCarrinho>): Double =
        itens.sumOf { it.totalDesconto() }

    fun valorTotalFinal(itens: List<ItemCarrinho>): Double =
        itens.sumOf { it.valorTotal() }
}