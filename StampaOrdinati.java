import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class StampaOrdinati 
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

        Arrays.sort(arr);
        
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
        
    }
}