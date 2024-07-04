/*Вариант А
24. Вывести массив NxN, заполненный по спирали в порядке возрастания.*/
import java.util.Scanner;
import java.util.function.BiConsumer;

@FunctionalInterface
interface MatrixGenerator {
    void generate(int[][] matrix, int n);
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("N = ");
        int n = input.nextInt();
        int[][] matrix = new int[n][n];

        MatrixGenerator spiralMatrixGenerator = (mat, size) -> {
            int value = 1;
            int top = 0, bottom = size - 1, left = 0, right = size - 1;

            while (value <= size * size) {
                for (int i = left; i <= right; i++) {
                    mat[top][i] = value++;
                }
                top++;

                for (int i = top; i <= bottom; i++) {
                    mat[i][right] = value++;
                }
                right--;

                for (int i = right; i >= left; i--) {
                    mat[bottom][i] = value++;
                }
                bottom--;

                for (int i = bottom; i >= top; i--) {
                    mat[i][left] = value++;
                }
                left++;
            }
        };

        spiralMatrixGenerator.generate(matrix, n);

        BiConsumer<int[][], Integer> printMatrix = (mat, size) -> {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(mat[i][j] + "\t");
                }
                System.out.println();
            }
        };

        printMatrix.accept(matrix, n);
    }
}