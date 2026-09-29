package com.example.calculadoracarrinho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.calculadoracarrinho.ui.CarrinhoScreen
import com.example.calculadoracarrinho.ui.theme.CarrinhoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                CarrinhoScreen()
            }
        }
    }
}
