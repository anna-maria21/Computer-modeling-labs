public class Kramer_method {
    static double[] kramer(double[][] A, double[] B) {
        int size = B.length;
        double[] dets = new double[size];
        double[] result = new double[size];
        double det = Determinant.det(A, size);
        boolean flag = true;

        for (int i=0; i<size; i++) {
            dets[i] = Determinant.det(newMatrix(A, B, i), size);
            if (dets[i] != 0) {
                flag = false;
            }
        }
        if (det != 0) {
            for (int i=0; i<size; i++) {
                result[i] = dets[i]/det;
            }
        } else if (flag) {
            System.out.println("The system has many solutions");
            return null;
        } else {
            System.out.println("The system has no solutions");
            return null;
        }
        return result;
    }
    static double[][] newMatrix(double[][] tempA, double[] B, int step) {
        double[][] A = new double[B.length][B.length];
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length; j++) {
                A[i][j] = tempA[i][j];
            }
        }
        for (int i=0; i<B.length; i++) {
            A[i][step] = B[i];
        }
        return A;
    }
}
