public class Task3 {
    public static double leftRectangles(double a, double b, double epsilon) {
        double oldResult = 0;
        double newResult = 0;
        double h = 0.5;
        double n =0;
        do {
            oldResult = newResult;
            newResult = 0;
            n = (b-a)/h;
            for (int i=0; i<n; i++) {
                newResult = newResult + Func.thisFunction(a+h*i);
            }
            newResult = newResult*h;
            h = h/2;
        } while(Math.abs(oldResult-newResult) > epsilon);
        return newResult;
    }
    public static double trapezes(double a, double b, double epsilon) {
        double oldResult = 0;
        double newResult = 0;
        double h = 0.5;
        double n =0;
        do {
            oldResult = newResult;
            newResult = 0;
            n = (b-a)/h;
            for (int i=1; i<=n-1; i++) {
                newResult = newResult + Func.thisFunction(a+h*i);
            }
            newResult = (newResult + (Func.thisFunction(a)+Func.thisFunction(b))/2) * h;
            h = h/2;
        } while(Math.abs(oldResult - newResult) > epsilon);
        return newResult;
    }
    public static double simpson(double a, double b, double epsilon) {
        double oldResult = 0;
        double newResult = 0;
        double h = 0.5;
        double n =0;
        do {
            oldResult = newResult;
            newResult = 0;
            n = (b-a)/h;
            for (int i=1; i<=n-1; i++) {
                if (i%2 == 0) {
                    newResult = newResult + 2*Func.thisFunction(a+h*i);
                } else {
                    newResult = newResult + 4*Func.thisFunction(a+h*i);
                }
            }
            newResult = newResult + Func.thisFunction(a) + Func.thisFunction(b);
            newResult = newResult  * h/3;
            h = h/2;
        } while(Math.abs(oldResult - newResult) > epsilon);
        return newResult;
    }
}
