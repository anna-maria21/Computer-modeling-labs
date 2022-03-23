public class Chord_method {
    static int g=3;
    static int k=0;
    public static double chord(double a, double b, double epsilon) {
        double c = 0;
        double f_a = this_func(a);
        double f_b = this_func(b);
        double fII_a = this_funcII(a);
        double fII_b = this_funcII(b);


        if (f_a*fII_a > 0) {
            c = a;
        } else if (f_b*fII_b > 0) {
            c = b;
        }
        double x1 = a - (f_a * (b - a) / (f_b - f_a));
        double f_x1 = this_func(x1);
        double f_c = this_func(c);
        double x2 = x1 - f_x1*(c-x1)/(f_c - f_x1);

        while (Math.abs(x2-x1)>epsilon) {
            x1 = x2;
            f_x1 = this_func(x1);
            x2 = x1 - f_x1*(c-x1)/(f_c - f_x1);
        }
        return x2;
    }
    static double this_func(double x) {
        return ((x-g*k)*(x-g*k) + Math.sin((x-g*k)));
    }
    static double this_funcII(double x) {
        return (2 - Math.sin(x-g*k));
    }
}
