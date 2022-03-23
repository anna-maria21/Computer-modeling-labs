public class Simple_iteration {
    static int g=3;
    static int k=1;
    public static double s_iter(double a, double b, double epsilon) {
        double x0 = (a+b)/2;
        double x1 = this_func(x0);
        while (Math.abs(x1 - x0) > epsilon) {
            x0 = x1;
            x1 = this_func(x0);
        }
        return x1;
    }
    static double this_func(double x) {
        return (Math.sin(x - 10*g/k) + 10*g)/k;
    }
}