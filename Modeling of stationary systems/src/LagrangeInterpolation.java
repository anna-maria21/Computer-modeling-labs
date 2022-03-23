public class LagrangeInterpolation {
    static double lagrange_interpolation(double x, double[] x_j, double[] y){
        double[] L_j_1 = new double[x_j.length];
        double[] L_j_2 = new double[x_j.length];

        for (int i=0; i<x_j.length; i++){
            L_j_1[i] = L_j_1[i]+1;
            for (int j=0; j<x_j.length; j++) {
                if(i!=j) {
                    L_j_1[i] = L_j_1[i] * (x - x_j[j]);
                }
            }
        }

        for (int i=0; i<x_j.length; i++){
            L_j_2[i] = L_j_2[i]+1;
            for (int j=0; j<x_j.length; j++) {
                if(i!=j) {
                    L_j_2[i] = L_j_2[i] * (x_j[i] - x_j[j]);
                }
            }
        }

        double result = 0;
            for (int j=0; j< x_j.length; j++) {
                result = result + y[j] * L_j_1[j] / L_j_2[j];
            }

        return result;
    }
}
