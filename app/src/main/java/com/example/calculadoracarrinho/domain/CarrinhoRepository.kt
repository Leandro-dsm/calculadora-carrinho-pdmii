package com.example.calculadoracarrinho.domain

object CarrinhoRepository {

    val catalogo: List<Produto> = listOf(
        Produto(
            nome = "Notebook Dell Inspiron",
            preco = 3499.00,
            descricao = "Notebook com processador Intel Core i7, 16GB RAM e SSD 512GB",
            descontoPercentual = 5.0
        ),
        Produto(
            nome = "Mouse sem fio",
            preco = 89.90,
            descricao = "Mouse óptico sem fio com receptor USB nano",
            descontoPercentual = 0.0
        ),
        Produto(
            nome = "Teclado mecânico RGB",
            preco = 349.90,
            descricao = null,
            descontoPercentual = 0.0
        ),
        Produto(
            nome = "Monitor Gamer UltraWide 34 Polegadas",
            preco = 2799.00,
            descricao = "Monitor curvo ultra-wide com taxa de 144Hz e resolução QHD",
            descontoPercentual = 10.0
        ),
        Produto(
            nome = "Headset Bluetooth",
            preco = 199.90,
            descricao = null,
            descontoPercentual = 0.0
        ),
        Produto(
            nome = "Webcam Full HD",
            preco = 249.90,
            descricao = "Webcam 1080p com microfone integrado",
            descontoPercentual = 0.0
        )
    )

    val carrinho: List<ItemCarrinho> = listOf(
        ItemCarrinho(catalogo[0], 2),
        ItemCarrinho(catalogo[1], 1),
        ItemCarrinho(catalogo[2], 1),
        ItemCarrinho(catalogo[3], 1),
        ItemCarrinho(catalogo[5], 1)
    )
}