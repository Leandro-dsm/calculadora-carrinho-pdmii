# Calculadora de Carrinho de Compras

**Aluno:** Leandro Sabino Sueoka
**Disciplina:** Programação para Dispositivos Móveis II
**Instituição:** Fatec Registro

## Descrição

Aplicativo Android desenvolvido em Kotlin com Jetpack Compose que simula um
carrinho de compras, aplica descontos e gera um relatório formatado no Logcat.

## Funcionalidades

- Catálogo fixo de produtos com nome, preço, descrição e desconto
- Cálculo de subtotal bruto, descontos e total final
- Componente de UI reutilizável e parametrizado
- Relatório no Logcat com produtos que tiveram desconto aplicado

## Arquitetura

- `domain/` — modelagem, catálogo e funções puras de cálculo
- `ui/` — telas Compose e componentes reutilizáveis

## Capturas de tela

### Emulador
![Tela do app](screenshots/emulador.png)

### Logcat
![Logcat](screenshots/logcat.png)

## Como executar

1. Clone o repositório
2. Abra no Android Studio
3. Execute em um emulador ou dispositivo físico
