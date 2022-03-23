import javax.sound.midi.Soundbank;

public class Task2 {
    public static double quadraticInterpolation(double x, double[] xArray) {
        double h = 1.5;
        double[][] yArray = new double[xArray.length][xArray.length];
        for (int i=0; i < yArray.length; i++) {
            yArray[i][0] = Func.thisFunction(xArray[i]);
        }
        for (int j=1; j< yArray.length; j++) {
            for (int i = 0; i < yArray.length-1; i++) {
                if(i == yArray.length-j) break;
                yArray[i][j] = yArray[i+1][j-1] - yArray[i][j-1];
            }
        }
        /*for (int i=0; i< yArray.length; i++) {
            for (int j=0; j< yArray.length; j++) {
                System.out.print(yArray[i][j] + " ");
            }
            System.out.println();
        }*/
        double q = (x - xArray[0])/h;
        double result = (yArray[0][1] + yArray[0][2]*(2*q-1)/2)/h;
        return result;
    }
}
