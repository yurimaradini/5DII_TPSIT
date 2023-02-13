import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class SommaInt 
{
    public static void main(String args[])
    { 
        int somma = 0;
        String s = "null";
        int x;
        Float f;

        Scanner input = new Scanner(System.in);
        
        while (!s.isEmpty()) {
            System.out.println("Inserisci un numero: ");
            s = input.nextLine();   
            
            try {
                x = Integer.parseInt(s);
                somma += x;
                continue;
            } catch (NumberFormatException e) {

            }

            try {
                f = Float.parseFloat(s);
                System.out.println("ATTENZIONE: " + f + " e' un numero decimale.");
                continue;
            } catch (NumberFormatException e) {

            }

            if(!s.isEmpty())
                System.out.println("ATTENZIONE: '" + s + "'' e' una stringa.");
        }
            System.out.println("Somma: " + somma);
    }

    
}