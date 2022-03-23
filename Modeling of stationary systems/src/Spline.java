public class Spline {
    static void spline(double x, double[] x_spline, double[] y_spline) {
        double a[] = new double[x_spline.length-1];
        double b[] = new double[x_spline.length-1];
        for (int i=0; i< a.length; i++) {
            a[i] = (y_spline[i] - y_spline[i+1]) / (x_spline[i] - x_spline[i+1]);
            b[i] = y_spline[i] - a[i]*x_spline[i];
        }
        if (x < x_spline[0] || x > x_spline[x_spline.length-1]){
            System.out.printf("\nUsing Math library: f(%.1f) = %f\n", x, (Math.sin(x) + x));
            System.out.println("x=" + x + " does not belong to the gap " + "[" + x_spline[0] + ";" + x_spline[x_spline.length-1] + "]");
            return;
        }
        for (int i=0; i<a.length; i++) {
            if (x > x_spline[i] && x < x_spline[i+1]) {
                Check.check(x, (a[i] * x + b[i]), "spline");
            }
        }
    }
}
