import java.util.Scanner;

public class Incrementa 
{
    public static void main(String args[])
    { 
        int[] arr = new int[10];

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Inserisci un numero: ");
            arr[i] = input.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i] + i + 1);
        }
    }
}