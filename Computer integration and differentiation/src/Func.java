public class Func {
    public static double thisFunction(double x) {
        return (x*x*x + x);
    }
    public static double firstDerivative(double x) {
        return (3*x*x + 1);
    }
    public static double integralFunction(double x) {
        return (x*x*x*x/4 + x*x/2);
    }
}
