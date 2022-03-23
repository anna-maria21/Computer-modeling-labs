public class Determinant {
    static int changes;
    static double det(double[][] tempA, int size) {
        double[][] A = new double[size][size];
        double max = Math.abs(tempA[0][0]);
        int row = 0;
        int col = 0;
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                A[i][j] = tempA[i][j];
                if (Math.abs(A[i][j]) > max) {
                    max = Math.abs(A[i][j]);
                    row = i;
                    col = j;
                }
            }
        }
        change(A, size, row, col);

        for (int k = 0; k < size - 1; k++) {
            for (int i = k + 1; i < size; i++) {
                double tmp = -A[i][k] / A[k][k];
                for (int j = 0; j < size; j++) {
                    A[i][j] += A[k][j] * tmp;
                }
            }
        }
        /*for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }*/
        double result = 1;
        for (int i = 0; i < size; i++) {
            result *= A[i][i];
        }

        return result*Math.pow(-1, changes);
    }

    static double[][] change(double[][] A, int size, int row, int col) {
        changes = 0;
        if (row != 0) {
            for (int i = 0; i < size; i++) {
                double temp = A[0][i];
                A[0][i] = A[row][i];
                A[row][i] = temp;
            }
            changes++;
        }
        if (col != 0) {
            for (int i = 0; i < size; i++) {
                double temp = A[i][0];
                A[i][0] = A[i][col];
                A[i][col] = temp;
            }
            changes++;
        }
        return A;
    }
}
