package com.example.calculadoracarrinho.domain

import android.util.Log
import java.text.NumberFormat
import java.util.Locale

object RelatorioLogcat {

    private const val TAG = "CarrinhoRelatorio"

    private val formatoMoeda: NumberFormat = NumberFormat
        .getCurrencyInstance(Locale("pt", "BR"))

    fun gerarRelatorio(itens: List<ItemCarrinho>) {
        Log.d(TAG, "===========================================")
        Log.d(TAG, " RELATORIO - PRODUTOS COM DESCONTO APLICADO")
        Log.d(TAG, "===========================================")

        itens
            .filter { it.produto.descontoPercentual > 0.0 }
            .sortedByDescending { it.valorTotal() }
            .map { item ->
                "${item.produto.nome} | Qtd: ${item.quantidade} | " +
                        "Total final: ${formatoMoeda.format(item.valorTotal())}"
            }
            .forEach { linha -> Log.d(TAG, linha) }

        Log.d(TAG, "-------------------------------------------")
        Log.d(TAG, "Subtotal bruto: ${formatoMoeda.format(
            CalculosCarrinho.subtotalBruto(itens)
        )}")
        Log.d(TAG, "Descontos aplicados: ${formatoMoeda.format(
            CalculosCarrinho.totalDescontos(itens)
        )}")
        Log.d(TAG, "VALOR TOTAL FINAL: ${formatoMoeda.format(
            CalculosCarrinho.valorTotalFinal(itens)
        )}")
        Log.d(TAG, "===========================================")
    }
}