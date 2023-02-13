import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Inverti 
{
    public static void main(String args[])
    { 
        ArrayList<String> strings = new ArrayList<String>();
        String x = "null";

        Scanner input = new Scanner(System.in);
        
        while (!x.isEmpty()) {
            System.out.println("Dimmi: ");
            x = input.nextLine();
            strings.add(x);
        }

        Saluta(strings);
    }

    static void Saluta(ArrayList<String> strings) {
        for (int i = strings.size() - 1; i >= 0; i--) {
            System.out.println(strings.get(i));
        }
    }
}