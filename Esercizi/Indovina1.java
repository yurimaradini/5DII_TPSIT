import java.util.Scanner;

public class Indovina1 
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

        for (int i = 0; i < 10; i++) {
            System.out.println("Indovina...");
            x = input.nextInt();

            for (int j = 0; j < 10; j++) {
                if(arr[j] == x) {
                    System.out.println("INDOVINATO");
                    return;
                }
            }
        }
        System.out.println("SBAGLIATO");
    }
}