public class Main {
    public static void main(String[] args) {
        double a = -0.2;
        double b = 0.7;
        double epsilon = 0.01;
        double[][] A = {{4, 5, 6}, {8, 9, -2}, {12, 3, -3}};
        double[] B = {0, 1, 2};

        System.out.println("1 завдання:");
        double result_bisection = Bisection.bisection(a, b, epsilon);
        System.out.println("Розв'язок рівняння методом ділення навпіл: x=" + result_bisection);
        double result_chord = Chord_method.chord(a, b, epsilon);
        System.out.println("Розв'язок рівняння методом хорд: x=" + result_chord);
        double result_tangent = Tangent_method.tangent(a, b, epsilon);
        System.out.println("Розв'язок рівняння методом дотичних: x=" + result_tangent);

        System.out.println("\n2 завдання:");
        a = 29.5;
        b = 31.0;
        double result_simple_iteration = Simple_iteration.s_iter(a, b, epsilon);
        System.out.println("Розв'язок рівняння методом простої ітерації: x=" + result_simple_iteration);

        System.out.println("\n3 завдання:");
        double[] result_kramer = Kramer_method.kramer(A, B);
        System.out.println("Розв'язання СЛАР методом Крамера:");
        for (int i=0; i<result_kramer.length; i++) {
            System.out.println("x[" + i + "]=" + result_kramer[i]);
        }

        System.out.println("\n4 завдання:");
        System.out.println("Розв'язання системи нелінійних рівнянь методом Зейделя:");
        double[] result_zeidel = Zeidel_method.zeidel(epsilon);
        for (int i=0; i<result_zeidel.length; i++) {
            System.out.println("x[" + i + "]=" + result_zeidel[i]);
        }
        System.out.println("Розв'язання системи нелінійних рівнянь методом Ньютона:");
        double[] result_newton = Newton_method.newton(epsilon);
        for (int i=0; i<result_newton.length; i++) {
            System.out.println("x[" + i + "]=" + result_newton[i]);
        }
    }
}
