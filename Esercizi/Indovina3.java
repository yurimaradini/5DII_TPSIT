import java.util.Scanner;

public class Indovina3 
{
    public static void main(String args[])
    { 
        int[] arr = new int[10];
        int x;

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Inserisci un numero: ");
            arr[i] = input.nextInt();
        }

        int i = 0, attempts = 0;
        while (i < 10 && attempts < 10) {
            System.out.println("Indovina...");
            x = input.nextInt();
            if(arr[i] == x) {
                i++;
            }
            else {
                System.out.println("SBAGLIATO");
                attempts++;
                i = 0;
            }    
        }
        
        if (attempts < 10) {
            System.out.println("INDOVINATO!");
            return;    
        }
        System.out.println("PROVA FALLITA");
    }
}