public class Check {
    static void check(double x, double result, String type) {
            System.out.printf("\nUsing Math library: f(%.1f) = %f\n", x, (Math.sin(x) + x));
            System.out.printf("Using %s: f(%.1f) = %f\n", type, x, result);
            System.out.printf("The error is %f\n", Math.abs((Math.sin(x) + x) - result));
    }
}
