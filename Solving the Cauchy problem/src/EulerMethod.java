public class EulerMethod {
    static void euler(int a, int b, double h) {
        int newRows = (int) ((b-a)/h+1);
        int cols = 3;
        int oldRows = 0;
        double sumX =0, sumY =0;
        double[][] newTable = new double[newRows][cols];
        double[][] oldTable;
        Main.fillNewTableEuler(newTable, newRows, a, h);
        do {
            h=h/2;
            sumX=0;
            sumY=0;
            oldRows = newRows;
            newRows = (int) ((b-a)/h+1);
            oldTable = newTable;
            newTable = new double[newRows][cols];
            Main.fillNewTableEuler(newTable, newRows, a, h);
            for (int i=0; i<oldRows; i++) {
                for (int j = i; j < newRows; j++) {
                    if (oldTable[i][0] == newTable[j][0]) {
                        sumX = sumX + (oldTable[i][1] - newTable[j][1]) * (oldTable[i][1] - newTable[j][1]);
                        sumY = sumY + (oldTable[i][2] - newTable[j][2]) * (oldTable[i][2] - newTable[j][2]);
                    }
                    }
            }
            //System.out.println(sumX+ " " + sumY);
        } while (Math.sqrt(Math.max(sumX, sumY)/(oldRows-1))>0.1);
        Main.printTable(newTable, newRows, cols);
        System.out.println("Кінцевий крок: " + h);
        System.out.println("Точне значення в кінцевій точці: x(1)=" + Main.exactX(1) + " y(1)=" + Main.exactY(1));
        System.out.println("Відхилення Х від точного значення: " + Math.abs(Main.exactX(1)-newTable[newRows-1][1]));
        System.out.println("Відхилення Y від точного значення: " + Math.abs(Main.exactY(1)-newTable[newRows-1][2]));

    }
}
