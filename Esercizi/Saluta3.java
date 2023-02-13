import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Saluta3 
{
    public static void main(String args[])
    { 
        ArrayList<String> names = new ArrayList<String>();
        String x = "null";

        Scanner input = new Scanner(System.in);
        
        while (!x.isEmpty()) {
            System.out.println("Come ti chiami? ");
            x = input.nextLine();
            names.add(x);
        }

        Saluta(names);
    }

    static void Saluta(ArrayList<String> names) {
        for (int i = 0; i < names.size() - 1; i++) {
            System.out.println("Ciao " + names.get(i).substring(0, 1).toUpperCase() + names.get(i).substring(1).toLowerCase() + "!");
        }
    }
}