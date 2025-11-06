import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilitária responsável por ler uma matriz de um arquivo de texto.
 */
public class ReadMatriz {

    /**
     * Lê um arquivo de texto e o converte em uma matriz de caracteres.
     *
     * @param caminhoArquivo O caminho para o arquivo .txt.
     * @return Uma matriz char[][].
     * @throws IOException Se ocorrer um erro durante a leitura do arquivo.
     */
    public static char[][] lerMatriz(String caminhoArquivo) throws IOException {
        List<String> linhasArquivo = new ArrayList<>();

        // Usa try-with-resources para garantir que o leitor será fechado
        try (BufferedReader leitor = Files.newBufferedReader(Paths.get(caminhoArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                // Adiciona cada linha (String) a uma lista temporária
                linhasArquivo.add(linha);
            }
        }

        // Converte a Lista de Strings em uma matriz char[][]
        if (linhasArquivo.isEmpty()) {
            // Retorna matriz vazia se o arquivo estiver vazio
            return new char[0][0];
        }

        int numLinhas = linhasArquivo.size();
        int numColunas = linhasArquivo.get(0).length();
        char[][] matriz = new char[numLinhas][numColunas];

        for (int i = 0; i < numLinhas; i++) {
            // Converte a String da linha i em um array de caracteres
            matriz[i] = linhasArquivo.get(i).toCharArray();
        }

        return matriz;
    }
}