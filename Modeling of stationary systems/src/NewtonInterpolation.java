
public class NewtonInterpolation {
    static double newton_interpolation1(double x, double[] x_j, double[] y, double step) {
        double mas[][] = new double[x_j.length][x_j.length];
        for (int i=0; i < x_j.length; i++) {
            mas[i][0] = y[i];
        }
        for (int j=1; j< x_j.length; j++) {
            for (int i = 0; i < x_j.length-1; i++) {
                if(i ==x_j.length-j) break;
                mas[i][j] = mas[i+1][j-1] - mas[i][j-1];
            }
        }
        double result = y[0];
        int k=1;
        for (int i=0; i < x_j.length-1; i++) {
            double res = 1;
            for (int j=0; j < k; j++) {
                res = res * (x - x_j[j]) / ((j + 1)* step);
            }
            k++;
            result = result + mas[0][i+1] * res;
        }
            return result;
    }

    static double newton_interpolation2(double x, double[] x_j, double[] y) {
        double mas[][] = new double[x_j.length][x_j.length+1];
        for (int i=0; i < x_j.length; i++) {
            mas[i][0] = x_j[i];
            mas[i][1] = y[i];
        }
        for (int j=2; j< x_j.length; j++) {
            for (int i = 0; i < x_j.length-1; i++) {
                if(i ==x_j.length-j) break;
                mas[i][j] = (mas[i+1][j-1] - mas[i][j-1])/(mas[i+1][j-2] - mas[i][j-2]);
            }
        }
        double result = y[0];
        int k=1;
        for (int i=0; i < x_j.length-1; i++) {
            double res = 1;
            for (int j=0; j < k; j++) {
                res = res * (x - x_j[j]);
            }
            k++;
            result = result + mas[0][i+1] * res;
        }
        return result;
    }
}
