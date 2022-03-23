import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class File_input {
    static void input_data() throws IOException {
        FileReader reader = new FileReader("input.txt");
        Scanner scan = new Scanner(reader);
        List<String> in = new ArrayList<>();
        int rows = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            line = line.replace(',', '.');
            in.add(line);
            rows++;
        }
        Pattern p = Pattern.compile("[\t ]+");
        int cols = p.split(in.get(0)).length;
        double[][] mas = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String[] temp = p.split(in.get(i));
                if (Double.parseDouble(temp[j]) > 0) {
                    mas[i][j] = Double.parseDouble(temp[j]);
                } else {
                    in.remove(i);
                    rows = in.size();
                    i--;
                    break;
                }
            }
        }
        rows = in.size();
        //Считаем среднее каждого столбика
        double[] aver = new double[cols];
        double sum = 0;
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                sum = sum + mas[i][j];
            }
            aver[j] = sum / rows;
            sum = 0;
        }
        //считаем дисперсию каждого столбика
        double[] disp = new double[cols];
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                sum = sum + (mas[i][j] - aver[j]) * (mas[i][j] - aver[j]);
            }
            disp[j] = sum / (rows - 1);
            sum = 0;
        }

        rows = in.size();
        int k=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mas[i][j] < (aver[j] - 3 * Math.sqrt(disp[j])) || mas[i][j] > (aver[j] + 3 * Math.sqrt(disp[j]))) {
                    in.remove(i);
                    i--;
                    rows = in.size();
                    for (int i1 = 0; i1 < rows; i1++) {
                        for (int j1 = 0; j1 < cols; j1++) {
                            String[] temp = p.split(in.get(i1));
                            mas[i1][j1] = Double.parseDouble(temp[j1]);

                        }
                    }
                    break;

                }
            }
        }
        //интервал допустимых значений для каждого столбика значений
        /*for (int i = 0; i < cols; i++) {
            System.out.println(i + " " + (aver[i] - 3 * Math.sqrt(disp[i])) + " " + (aver[i] + 3 * Math.sqrt(disp[i])));
        }*/


        rows = in.size();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String[] temp = p.split(in.get(i));
                mas[i][j] = Double.parseDouble(temp[j]);
            }
        }
        MNK.mnk(mas, rows, cols);
    }
}
