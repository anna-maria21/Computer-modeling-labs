import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        double[] x_j = new double[]{0, 2, 3, 5};
        double[] new_x_j = new double[]{1, 2, 3, 4};
        double[] x = new double[]{0.2, 2.5, 5.7};
        double[] new_x = new double[]{1.3, 2.5, 4.8};
        double[] x_spline = new double[]{1.4, 2.5, 3.9};
        double[] y = new double[x_j.length];
        double[] new_y = new double[x_j.length];
        double[] result_L = new double[x.length];
        double[] result_C = new double[x.length];
        double[] result_C_L = new double[x.length];
        double[] result_N = new double[x.length];

        for (int i=0; i<y.length; i++){
            y[i] = Math.sin(x_j[i]) + x_j[i];
        }
        System.out.println("f(x) = sin(x) + x\n");
        System.out.print("\n1)Lagrange and Newton(for unequal intervals) Interpolation:");

        for (int i=0; i<x.length; i++) {
            result_L[i] = LagrangeInterpolation.lagrange_interpolation(x[i], x_j, y);
        }
        for (int i=0; i<x.length; i++) {
            Check.check(x[i], result_L[i], "Lagrange Interpolation");
        }

        for (int i=0; i<x.length; i++) {
            result_N[i] = NewtonInterpolation.newton_interpolation2(x[i], x_j, y);
        }
        for (int i=0; i<x.length; i++) {
            Check.check(x[i], result_L[i], "Newton(for unequal intervals) Interpolation");
        }

        result_C = ChebyshevInterpolation.chebysev_polinom(x_j[0], x_j[x_j.length-1], x_j.length);
        for (int i=0; i<y.length; i++){
            y[i] = Math.sin(result_C[i]) + result_C[i];
        }

        System.out.println("\n\n2)Lagrange Interpolation with Chebyshev polynomial:");
        for (int i=0; i<x.length; i++) {
            result_C_L[i] = LagrangeInterpolation.lagrange_interpolation(x[i], result_C, y);
            Check.check(x[i], result_C_L[i], "Lagrange Interpolation");
        }


        System.out.println("\nThe difference between 1 and 2 metod:");
        for (int i=0; i<result_L.length; i++) {
            System.out.printf("y = f(%.1f): %f\n", x[i], Math.abs(result_C_L[i]-result_L[i]));
        }

        System.out.print("\n\n3)Newton Interpolation(for equal intervals):\n");

        for (int i=0; i<new_y.length; i++){
            new_y[i] = Math.sin(new_x_j[i]) + new_x_j[i];
        }
        for (int i=0; i<new_x.length; i++) {
            result_N[i] = NewtonInterpolation.newton_interpolation1(new_x[i], new_x_j, new_y, 1);
            Check.check(new_x[i], result_N[i], "Newton(for equal intervals) Interpolation");
        }

        System.out.print("\n\n4)Spline:\n");

        for (int i=0; i<y.length; i++){
            y[i] = Math.sin(x_j[i]) + x_j[i];
        }
        for (int i=0; i<x_spline.length; i++) {
            Spline.spline(x_spline[i], x_j, y);
        }

        System.out.print("\n\n5)MNK:\n");
        for (int i=0; i<x.length; i++) {
            if (x[i] < new_x_j[0] || x[i] > new_x_j[new_x_j.length-1]) {
                System.out.println("\nx=" + x[i] + " does not belong to the gap " + "[" + new_x_j[0] + ";" + new_x_j[new_x_j.length-1] + "]");
            continue;
            }
            double result =  MNK.mnk(x[i], new_x_j, new_y);
            Check.check(x[i], result, "MNK");
        }

        System.out.println("\n\n6)MNK:\n");
        File_input.input_data();

    }
}
