import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class SommaDec 
{
    public static void main(String args[])
    { 
        Double somma = 0.0;
        String s = "null";
        int x;
        Double d;

        Scanner input = new Scanner(System.in);
        
        while (!s.isEmpty()) {
            System.out.println("Inserisci un numero: ");
            s = input.nextLine();   
            
            try {
                x = Integer.parseInt(s);
                System.out.println("ATTENZIONE: " + x + " accettato ma non scritto correttamente.");
                somma += x;
                continue;
            } catch (NumberFormatException e) {

            }

            try {
                d = Double.parseDouble(s);
                somma += d;
                continue;
            } catch (NumberFormatException e) {

            }

            if(!s.isEmpty())
                System.out.println("ATTENZIONE: '" + s + "'' e' una stringa.");
        }
            System.out.println("Somma: " + somma);
    }

    
}