public class ChebyshevInterpolation {
    static double[] chebysev_polinom(double a, double b, int n) {
        double[] x = new double[n];
        for (int i=0; i<n; i++) {
            double t = Math.cos((double)(2*i+1)/(2*(n-1)+2)*Math.PI);
            x[i]=(a+b)/2 + (b-a)/2*t;
        }
        return x;
    }
}
