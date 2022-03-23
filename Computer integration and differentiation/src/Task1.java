public class Task1 {
    public static double sequenceOfIncrements(double x, double epsilon) {
        double newResult = 0;
        double oldResult = 0;
        int k = 0;
        double exactValue = Func.thisFunction(x);
        do {
            k++;
            double h = Math.pow(0.5, k);
            oldResult = newResult;
            newResult = (Func.thisFunction(x+h) - exactValue)/h;
        } while (Math.abs(oldResult - newResult) > epsilon);
        System.out.println("Кількість ітерацій: " + k);
        return newResult;
    }
    public static double centeredDifference(double x, double epsilon) {
        double newResult = 0;
        double oldResult = 0;
        int k = 0;
        do {
            k++;
            double h = Math.pow(0.5, k);
            oldResult = newResult;
            newResult = (Func.thisFunction(x+h) - Func.thisFunction(x-h))/(2*h);
        } while (Math.abs(oldResult - newResult) > epsilon);
        System.out.println("Кількість ітерацій: " + k);
        return newResult;
    }
}
