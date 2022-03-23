public class Bisection {
    static int g=3;
    static int k=0;
    static double bisection(double a, double b, double epsilon) {

        double result = (a + b) / 2;
        while (Math.abs(b - a) > epsilon) {
            double c = (a + b) / 2;
            double f_a = this_func(a);
            double f_b = this_func(b);
            double f_c = this_func(c);

            if (f_c == 0) {
                result = c;
                return result;
            } else if (f_a * f_c < 0) {
                b = c;
            } else if (f_b * f_c < 0) {
                a = c;
            }
            result = (a + b) / 2;
        }
        return result;
    }
    static double this_func(double x) {
        return ((x-g*k)*(x-g*k) + Math.sin((x-g*k)));
    }
}
