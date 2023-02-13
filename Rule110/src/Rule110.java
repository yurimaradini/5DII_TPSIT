import java.util.Scanner;
import java.util.Arrays;

public class Rule110 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Numero righe: ");
        int rows = Integer.parseInt(input.nextLine());
        System.out.print("Numero colonne: ");
        int cols = Integer.parseInt(input.nextLine());

        String firstLine = CreateTable(rows, cols);

        String res = Rule110(firstLine, rows);

        for (int i = 0; i < rows; i++) {
            System.out.println(res.substring(i*cols, i*cols + cols));
        }

    }

    public static String CreateTable(int rows, int cols) {
        String res = "";
        
        for (int i = 0; i < cols - 1; i++) { //all zeros
            res += 0;
        }

        res += 1;                           //last 1
        return res;
    }

    public static String Rule110(String firstLine, int rows) {
        int i = 0;
        String nextLine = "";
        String res = firstLine;
        while (i < rows - 1) {      //rows
            String circular = firstLine + firstLine.substring(0, 2); //add last 2 chars of the string at the end            
            
            for (int j = 0; j < firstLine.length(); j++) {
                String upperLine = circular.substring(j, j+3);
                nextLine += Calc(upperLine);
            }

            res += nextLine; //add calculated line to res
            firstLine = nextLine; //calculated line becomes upper line
            nextLine = ""; //next line to be calculated
            i++;
        }

        res = Draw(res);

        return res;
    }

    public static String Calc(String upper) {
        String next = null;
        
        switch (upper) {
            case "111":
                next = "0";
                break;
            case "110":
                next = "1";
                break;
            case "101":
                next = "1";
                break;
            case "100":
                next = "0";
                break;
            case "011":
                next = "1";
                break;
            case "010":
                next = "1";
                break;
            case "001":
                next = "1";
                break;
            case "000":
                next = "0";
                break;
        }
        return next;
    }

    public static String Draw(String str) {
        StringBuilder strB = new StringBuilder(str);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                strB.setCharAt(i, '#');
            }
            else {
                strB.setCharAt(i, ' ');
            }
        }
        return strB.toString();
    }
}
