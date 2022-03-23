public class Task {
    public static void intervalDivision(int k, int g) {
        double a = -k*g-2;
        double b = k*g+1;
        double L = 0;
        double x_m = 0;
        double x_mFunc = 0;
        double x1=0, x2=0, x1Func=0, x2Func=0;
        do {
            x_m = (a+b)/2;
            L = b - a;
            x_mFunc = func(x_m, k,g);
            x1 = a + L/4;
            x1Func = func(x1,k,g);
            x2 = b - L/4;
            x2Func = func(x2,k,g);
            if (x1Func<x_mFunc) {
                b = x_m;
                x_m = x1;
            } else if (x2Func<x_mFunc) {
                a = x_m;
                x_m = x2;
            } else if (x2Func>=x_mFunc) {
                a = x1;
                b = x2;
            }
            L = b-a;
        } while (L > 0.01);
        System.out.println("Кінцевий інтервал: [" + a + "; " + b + "]");
        System.out.println("x = " + x_m);
        System.out.println("y = " + func(x_m, k, g));
        System.out.println("Error: " + Math.abs(0-x_m) + "\n");
    }

    public static void randomSearch(int k, int g) {
        double a = -k*g-2;
        double b = k*g+1;
        double x = 0, y = 0;
        double res = 0;

        double min = func(Math.max(Math.abs(a), Math.abs(b)),k,g);
        for(int i = 0; i < 100; i++) {
            x = Math.random() * (b-a) + a;
            y = func(x, k, g);
            if (y<min) {
                min = y;
                res = x;
            }
        }
        System.out.println("x = " + res);
        System.out.println("y = " + func(res, k, g));
        System.out.println("Error: " + Math.abs(0-res));
    }

    public static double func(double x, int k, int g) {
        return x*x+2*k*g*x+k;
    }
}
