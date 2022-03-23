import org.apache.commons.math.linear.MatrixUtils;
import org.apache.commons.math.linear.RealMatrix;

public class Newton_method {
    static int g=3;
    static int k=0;
    static double[] newton(double epsilon) {
        double[] Xm = {11.8, 0.1};
        RealMatrix matrix_Xm = MatrixUtils.createColumnRealMatrix(Xm);
        do {
            Xm[0] = matrix_Xm.getEntry(0, 0);
            Xm[1] = matrix_Xm.getEntry(1, 0);
            double[][] W = new double[2][2];
            W[0][0] = xIx(Xm[0], Xm[1]);
            W[0][1] = xIy(Xm[0], Xm[1]);
            W[1][0] = yIx(Xm[0], Xm[1]);
            W[1][1] = yIy(Xm[0], Xm[1]);
            RealMatrix matrix_W = MatrixUtils.createRealMatrix(W);
            double[] F = new double[2];
            F[0] = this_func_x(Xm[0], Xm[1]);
            F[1] = this_func_y(Xm[0], Xm[1]);
            RealMatrix matrix_FX = MatrixUtils.createColumnRealMatrix(F);
            matrix_Xm = MatrixUtils.createColumnRealMatrix(Xm).subtract(matrix_W.inverse().multiply(matrix_FX));
        }while (Math.abs(Xm[0] - matrix_Xm.getEntry(0, 0))>epsilon || Math.abs(Xm[1] - matrix_Xm.getEntry(1, 0))>epsilon);
        return Xm;
    }
    static double this_func_x(double x, double y) {
        return ((k+1)*x-4*g+Math.sin((k+1)*x+y-4*g)/10);
    }
    static double this_func_y(double x, double y) {
        return (y-Math.sin((k+1)*x+y-4*g)/(10*(g+1)));
    }
    static double xIx(double x, double y) {
        return (((k+1)*(Math.cos(4*g-(k+1)*x-y)+10))/10);
    }
    static double xIy(double x, double y) {
        return (Math.cos(4*g-(k+1)*x-y)/10);
    }
    static double yIx(double x, double y) {
        return ((-k-1)*Math.cos(4*g-(k+1)*x-y)/(10*(g+1)));
    }
    static double yIy(double x, double y) {
        return (1 - Math.cos(4*g-(k+1)*x-y)/(10*(g+1)));
    }

}
