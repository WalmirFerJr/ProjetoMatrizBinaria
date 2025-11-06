import java.util.ArrayDeque;
import java.util.Deque;


     // Lógica para calcular a area do maior retangulo na matriz binaria

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int numCols = matrix[0].length;

        // A pilha armazenará os *índices* das barras do histograma

        int[] heights = new int[numCols];
        int maxArea = 0;

        for (char[] currentRow : matrix) {

            for (int col = 0; col < numCols; col++) {
                if (currentRow[col] == '1') {
                    heights[col] = heights[col] + 1;
                } else {
                    heights[col] = 0;
                }
            }

            int areaInThisRow = largestRectangleInHistogram(heights);

            maxArea = Math.max(maxArea, areaInThisRow);
        }

        return maxArea;
    }

    private int largestRectangleInHistogram(int[] heights) {
        int maxArea = 0;
        int numCols = heights.length;

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= numCols; i++) {

            int currentHeight = (i == numCols) ? 0 : heights[i];

            while (!stack.isEmpty() && heights[stack.peek()] >= currentHeight) {
                int barHeight = heights[stack.pop()];

                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);

                maxArea = Math.max(maxArea, barHeight * width);
            }

            stack.push(i);
        }

        return maxArea;
    }
}