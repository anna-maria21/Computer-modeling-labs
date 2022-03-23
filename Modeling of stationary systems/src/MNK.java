import org.apache.commons.math.linear.MatrixUtils;
import org.apache.commons.math.linear.RealMatrix;

public class MNK {
    static double mnk(double x, double[] x_j, double[] y) {
        double U[][] = new double[x_j.length][2];
        for (int i=0; i<x_j.length; i++) {
            U[i][0] = 1;
            U[i][1] = x_j[i];
        }
        RealMatrix matrix_U = MatrixUtils.createRealMatrix(U);
        RealMatrix matrix_Y = MatrixUtils.createColumnRealMatrix(y);
        RealMatrix transp_U = matrix_U.transpose();
        RealMatrix resMatrix = (transp_U.multiply(matrix_U)).inverse().multiply(transp_U).multiply(matrix_Y);
        //System.out.printf("%.3f + %.3f *x\n", resMatrix.getEntry(0,0), resMatrix.getEntry(1,0));
        return resMatrix.getEntry(0,0) + resMatrix.getEntry(1,0)*x;
    }


    static void mnk(double[][] mas, int rows, int cols) {
        double U[][] = new double[rows][cols];
        double y[] = new double[rows];

        for (int i=0; i<rows; i++) {
            y[i] = mas[i][cols-1];
        }
        for (int i=0; i<rows; i++) {
            U[i][0] = 1;
            for (int j=1; j<cols; j++) {
                U[i][j] = mas[i][j-1];
            }
        }

        RealMatrix matrix_U = MatrixUtils.createRealMatrix(U);
        RealMatrix matrix_Y = MatrixUtils.createColumnRealMatrix(y);
        RealMatrix transp_U = matrix_U.transpose();
        RealMatrix resMatrix = (transp_U.multiply(matrix_U)).inverse().multiply(transp_U).multiply(matrix_Y);

        double res[] = new double[cols];
        double result =0;
        for (int i=0; i<cols; i++) {
            res[i] = resMatrix.getEntry(i,0);
            result = result + res[i]*U[0][i];
        }

        System.out.print("Equation: ");
        System.out.printf("y = %.2f+%.2f*x1+%.2f*x2%.2f*x3\n", res[0], res[1], res[2], res[3]);
        System.out.printf("Result: %.3f\n", result);
        System.out.printf("The error is %.3f\n", Math.abs(y[0] - result));
    }
}
