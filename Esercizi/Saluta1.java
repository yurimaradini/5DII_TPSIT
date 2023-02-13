import java.util.Scanner;
import java.util.Arrays;

public class Saluta1 
{
    public static void main(String args[])
    { 
        String x;

        Scanner input = new Scanner(System.in);
        
        System.out.println("Come ti chiami? ");
        x = input.nextLine();

        System.out.println("Ciao " + x + "!");
    }
}