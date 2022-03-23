public class Zeidel_method {
    static int g=3;
    static int k=0;
    static double[] zeidel(double epsilon) {
        double x=11.8;
        double y=0.1;
        do {
            x = this_func_x(x, y);
            y = this_func_y(x, y);
        } while (F_X(x,y)>epsilon || F_Y(x,y)>epsilon);

        double[] result = new double[2];
        result[0] = x;
        result[1] = y;
        return result;
    }
    static double this_func_x(double x, double y) {
        return ((4*g - Math.sin((k+1)*x + y - 4*g)/10)/(k+1));
    }
    static double this_func_y(double x, double y) {
        return (Math.sin((k+1)*x + y - 4*g)/(10*(g+1)));
    }
    static double F_X(double x, double y) {
        return Math.abs(x - this_func_x(x, y));
    }
    static double F_Y(double x, double y) {
        return Math.abs(y - this_func_y(x, y));
    }
}
