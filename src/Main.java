void main(String[] args) {

    // 1. Validar se o usuário forneceu o caminho do arquivo
    if (args.length == 0) {
        IO.println("Erro: Nenhum arquivo de entrada fornecido.");
        IO.println("Uso: java Main <caminho_para_matriz.txt>");
        return; // Encerra o programa
    }

    String caminhoArquivo = args[0];

    try {
        // 2. Orquestração: Chamar o Leitor
        IO.println("Lendo arquivo: " + caminhoArquivo + "...");
        char[][] matriz = ReadMatriz.lerMatriz(caminhoArquivo);

        if (matriz.length == 0) {
            IO.println("Arquivo vazio ou inválido. Área: 0");
            return;
        }

        // 3. Orquestração: Instanciar e Chamar a Lógica
        MaximalRectangle calculadora = new MaximalRectangle();
        int areaFinal = calculadora.maximalRectangle(matriz);

        // 4. Orquestração: Exibir o resultado final
        IO.println("Cálculo concluído.");
        IO.println("A maior área retangular encontrada é: " + areaFinal);

    } catch (Exception e) {
        // Lida com erros (ex: "Arquivo não encontrado")
        System.err.println("Ocorreu um erro durante o processamento: " + e.getMessage());
    }
}