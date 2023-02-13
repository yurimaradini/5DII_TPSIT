import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

public class DaUnoADieci 
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

        List list = Arrays.asList(arr);
        Set set = new HashSet(list);

        Arrays.sort(arr);

        if (arr[0] == 1 && arr[9] == 10 && set.size() == arr.length) {
            System.out.println("Da uno a dieci!");
            return;
        }

        System.out.println(set.size());
        System.out.println(arr.length);
        System.out.println("NO.");
    }
}