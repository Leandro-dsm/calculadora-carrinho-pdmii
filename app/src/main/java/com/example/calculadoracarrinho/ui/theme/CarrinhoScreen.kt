package com.example.calculadoracarrinho.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.calculadoracarrinho.domain.CarrinhoRepository
import com.example.calculadoracarrinho.domain.RelatorioLogcat
import com.example.calculadoracarrinho.domain.CalculosCarrinho
import com.example.calculadoracarrinho.ui.components.ProdutoItem
import java.text.NumberFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarrinhoScreen() {
    val itens = CarrinhoRepository.carrinho
    val formato = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

    RelatorioLogcat.gerarRelatorio(itens)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Carrinho de Compras",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(itens) { item ->
                    ProdutoItem(item = item)
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    ResumoLinha(
                        label = "Subtotal bruto",
                        valor = formato.format(CalculosCarrinho.subtotalBruto(itens))
                    )
                    ResumoLinha(
                        label = "Descontos aplicados",
                        valor = formato.format(CalculosCarrinho.totalDescontos(itens)),
                        cor = MaterialTheme.colorScheme.error
                    )
                    HorizontalDivider()
                    ResumoLinha(
                        label = "VALOR TOTAL FINAL",
                        valor = formato.format(CalculosCarrinho.valorTotalFinal(itens)),
                        estilo = MaterialTheme.typography.titleLarge,
                        cor = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
private fun ResumoLinha(
    label: String,
    valor: String,
    cor: Color = MaterialTheme.colorScheme.onSurface,
    estilo: TextStyle = MaterialTheme.typography.bodyLarge
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = estilo, color = cor)
        Text(text = valor, style = estilo, color = cor)
    }
}
