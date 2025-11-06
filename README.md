# Calculadora de Retângulo Máximo (Maximal Rectangle)

Este é um projeto Java que implementa um algoritmo eficiente para resolver o problema clássdico de encontrar o maior retângulo composto apenas por '1's dentro de uma matriz binária.

## 🎯 Visão Geral do Problema
Dada uma matriz 2D `M x N` preenchida com caracteres '0' e '1', o objetivo é encontrar o retângulo contíguo contendo apenas '1's que tenha a maior área e retornar essa área.

### Exemplo de Entrada

['1','0','1','0','0'],
['1','0','1','1','1'],
['1','1','1','1','1'],
['1','0','0','1','0']

### Saída Esperada

6

**Explicação:** O maior retângulo é formado nas linhas 2 e 3 (índices 1 e 2), nas colunas 3, 4 e 5 (índices 2, 3, 4). Este retângulo tem dimensões 2x3, resultando em uma área de 6.

## 🧠 Abordagem do Algoritmo

A solução mais eficiente para este problema 2D é transformá-lo em uma série de problemas 1D. A complexidade final do algoritmo é **O(M * N)**.

1.  **Iteração por Linha:** O algoritmo processa a matriz linha por linha, de cima para baixo.
2.  **Construção de Histograma:** Para cada linha, ele constrói um "histograma" virtual. A altura de cada barra neste histograma representa o número de '1's consecutivos na vertical, terminando naquela célula.
    * Se `matriz[linha][coluna]` é '0', a altura da barra é `0`.
    * Se `matriz[linha][coluna]` é '1', a altura da barra é `1 + altura[linha-1][coluna]`.
3.  **Maior Retângulo no Histograma:** Após construir o histograma para uma linha, o programa resolve um subproblema: **"Encontrar o Maior Retângulo em um Histograma"**.
4.  **Solução com Pilha (Stack):** Este subproblema 1D é resolvido eficientemente em tempo **O(N)** (onde N é o número de colunas) usando uma `Deque` (Pilha) monotônica crescente para rastrear os índices das barras.

O loop externo (passo 1) executa M vezes e o loop interno (passo 3) executa N vezes, resultando na complexidade total O(M * N).

## 🏗️ Estrutura do Projeto (POO)

O projeto é dividido em três classes, seguindo o **Princípio da Responsabilidade Única (SRP)** para um código limpo, testável e de fácil manutenção.

* `src/Main.java`: **Ponto de Entrada (Orquestrador)**
    * Responsabilidade: Iniciar a aplicação, lidar com a entrada do usuário (argumentos de linha de comando) e orquestrar as outras classes.
    * Ela chama o `MatrixReader` para ler os dados e, em seguida, passa esses dados para o `MaximalRectangle` para processamento.

* `src/MaximalRectangle.java`: **Lógica de Negócios (O Algoritmo)**
    * Responsabilidade: Contém a lógica principal e o algoritmo. Ela sabe *como* calcular a área máxima, mas não se importa de *onde* os dados vieram.
    * Isso a torna altamente reutilizável e fácil de testar isoladamente.

* `src/MatrixReader.java`: **Utilitário (I/O)**
    * Responsabilidade: Lidar com a leitura e parsing de arquivos. Sua única função é ler um arquivo `.txt` e convertê-lo na estrutura de dados `char[][]` que a aplicação espera.

## 🚀 Como Compilar e Executar

Siga estes passos para rodar o projeto.

### 1. Estrutura de Arquivos

Certifique-se de que o projeto está organizado da seguinte forma:

/SeuProjeto/ ├── src/ │ ├── Main.java │ ├── MaximalRectangle.java │ └── MatrixReader.java │ └── matriz.txt

### 2. Compile

Abra seu terminal ou prompt de comando e navegue até a **pasta raiz** do seu projeto (a pasta que contém `src/`).
Execute o seguinte comando para compilar todos os arquivos `.java`:

```bash
javac src/*.java
```

### 3. Execute

No mesmo terminal, execute o programa usando o comando java. Você deve passar o nome do seu arquivo de matriz (matriz.txt) como um argumento.

```bash
java -cp src Main matriz.txt
```

Nota: O comando -cp src (Classpath) informa ao Java para procurar os arquivos .class compilados dentro da pasta src.

### Saída esperada

Se tudo estiver correto, você verá a seguinte saída no seu terminal:

```bash
Reading file: matriz.txt...
Calculation complete.
The largest rectangular area found is: 6
```