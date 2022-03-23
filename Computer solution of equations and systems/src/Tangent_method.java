public class Tangent_method {
    static int g=3;
    static int k=0;
    public static double tangent(double a, double b, double epsilon) {
        double f_a = this_func(a);
        double f_b = this_func(b);
        double fII_a = this_funcII(a);
        double fII_b = this_funcII(b);
        double x0=0;

        if (f_a*fII_a > 0) {
            x0 = a;
        } else if (f_b*fII_b > 0) {
            x0 = b;
        }
        double f_x0 = this_func(x0);
        double fI_x0 = this_funcI(x0);
        double x1 = x0 - f_x0/fI_x0;

        while (Math.abs(x1-x0)>epsilon) {
            x0 = x1;
            f_x0 = this_func(x0);
            fI_x0 = this_funcI(x0);
            x1 = x0 - f_x0/fI_x0;
        }
        return x1;
    }

    static double this_func(double x) {
        return ((x-g*k)*(x-g*k) + Math.sin((x-g*k)));
    }
    static double this_funcI(double x) {
        return (2*(x-g*k) + Math.cos(x-g*k));
    }
    static double this_funcII(double x) {
        return (2 - Math.sin(x-g*k));
    }
}
