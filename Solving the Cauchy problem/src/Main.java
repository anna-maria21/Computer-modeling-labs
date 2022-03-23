public class Main {

    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        double h = 0.5;

        System.out.println("\t\t\tМетод Ейлера");
        EulerMethod.euler(a,b,h);

        System.out.println("\n\t\tМетод Рунге-Кутта");
        RungeKuttaMethod.RungeKutta(a,b,h);

    }

    static double forX(double x, double y) {
        return x-y+3;
    }
    static double forY(double x) {
        return -x;
    }
    static void fillNewTableEuler(double[][] newTable, int rows, int a, double h) {
        newTable[0][0] = a;
        newTable[0][1] = 0;
        newTable[0][2] = 0;
        for (int i=1; i<rows; i++) {
            newTable[i][0] = newTable[i-1][0] + h;
            newTable[i][1] = newTable[i-1][1] + h*forX(newTable[i-1][1], newTable[i-1][2]);
            newTable[i][2] = newTable[i-1][2] + h*forY(newTable[i-1][1]);
        }
    }
    static void fillNewTableRungeKutta(double[][] newTable, int rows, int a, double h) {
        newTable[0][0] = a;
        newTable[0][1] = 0;
        newTable[0][2] = 0;
        for (int i=1; i<rows; i++) {
            double k0x = h*forX(newTable[i-1][1], newTable[i-1][2]);
            double k0y = h*forY(newTable[i-1][1]);
            double k1x = h*forX(newTable[i-1][1]+k0x/2, newTable[i-1][2]+k0y/2);
            double k1y = h*forY(newTable[i-1][1]+k0x/2);
            double k2x = h*forX(newTable[i-1][1]+k1x/2, newTable[i-1][2]+k1y/2);
            double k2y = h*forY(newTable[i-1][1]+k1x/2);
            double k3x = h*forX(newTable[i-1][1]+k2x, newTable[i-1][2]+k2y);
            double k3y = h*forY(newTable[i-1][1]+k2x);
            newTable[i][0] = newTable[i-1][0] + h;
            newTable[i][1] = newTable[i-1][1] + (k0x+2*k1x+2*k2x+k3x)/6;
            newTable[i][2] = newTable[i-1][2] + (k0y+2*k1y+2*k2y+k3y)/6;
        }
    }
    static void printTable(double[][] curTable, int rows, int cols) {
        for(int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                System.out.printf("%10.6f ",curTable[i][j]);
            }
            System.out.println();
        }
    }
    static double exactX(double t) {
        return 0.6*Math.sqrt(5)*Math.exp(t*(0.5+Math.sqrt(5)/2))-0.6*Math.sqrt(5)*Math.exp(t*(0.5-Math.sqrt(5)/2));
    }
    static double exactY(double t) {
        return -0.6*Math.sqrt(5)*(Math.sqrt(5)/2-0.5)*Math.exp(t*(0.5+Math.sqrt(5)/2))-0.6*Math.sqrt(5)*(Math.sqrt(5)/2+0.5)*Math.exp(t*(0.5-Math.sqrt(5)/2))+3;
    }
}
