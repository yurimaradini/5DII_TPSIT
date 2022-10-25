import java.util.Scanner;

public class TreVolte 
{
    public static void main(String args[])
    { 
        int[] arr = new int[10];
        int cont;

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Inserisci un numero: ");
            arr[i] = input.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            cont = 1;
            for (int j = i + 1; j < 10; j++) {
                if(arr[i] == arr[j]) {
                    cont++;
                    if (cont == 3) {
                        System.out.println(arr[j]);
                        return;
                    }
                }
            }
        }

        System.out.println("NO");
    }
}