public class Main {
    public static void main(String[] args) {
        int g=3;
        int k=0;
        double epsilon = 0.001;
        double a = g-2*k-3;
        double b = g-2*k;
        double[] xArray = {g-2*k-3, g-2*k-1.5, g-2*k};
        double x = g-2*k-2;

        System.out.println("\n1 завдання:");
        System.out.println("Точне значення першої похідної складає: " + Func.firstDerivative(x));
        System.out.println("1) Обчислення значення першої похідної за допомогою послідовності приростів:");
        double resultSequenceOfIncrements = Task1.sequenceOfIncrements(x, epsilon);
        System.out.println("Результат виконання програми: " + resultSequenceOfIncrements);
        System.out.println("Похибка складає " + Math.abs(Func.firstDerivative(x)-resultSequenceOfIncrements));

        System.out.println("2) Обчислення значення першої похідної за допомогою центрованої різниці:");
        double resultCenteredDifference = Task1.centeredDifference(x, epsilon);
        System.out.println("Результат роботи програми: " + resultCenteredDifference);
        System.out.println("Похибка складає " + Math.abs(Func.firstDerivative(x)-resultCenteredDifference));

        System.out.println("\n2 завдання:");
        System.out.println("Точне значення першої похідної складає: " + Func.firstDerivative(x));
        double resultQuadraticInterpolation = Task2.quadraticInterpolation(x, xArray);
        System.out.println("Результат обчислень значення першої похідної методом квадратичної інтерполяції: " + resultQuadraticInterpolation);
        System.out.println("Похибка складає " + Math.abs(Func.firstDerivative(x)-resultQuadraticInterpolation));

        System.out.println("\n3 завдання:");
        System.out.println("Точне значення інтеграла складає: " + (Func.integralFunction(b)-Func.integralFunction(a)));
        double resultLeftRect = Task3.leftRectangles(a, b, epsilon);
        System.out.println("1) Результат обчислень, отриманий методом лівих прямокутників: " + resultLeftRect + ". \nПохибка складає " + Math.abs(resultLeftRect-Func.integralFunction(b)+Func.integralFunction(a)));
        //System.out.println(a +" " + b + " " + epsilon);
        double resultTrapezes = Task3.trapezes(a, b, epsilon);
        System.out.println("2) Результат обчислень, отриманий методом трапецій: " + resultTrapezes + ". \nПохибка складає " + Math.abs(resultTrapezes-Func.integralFunction(b)+Func.integralFunction(a)));
        double resultSimpson = Task3.simpson(a, b, epsilon);
        System.out.println("3) Результат обчислень, отриманий методом Сімпсона: " + resultSimpson + ".\nПохибка складає " + Math.abs(resultSimpson-Func.integralFunction(b)+Func.integralFunction(a)));
    }
}
