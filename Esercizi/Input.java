import java.util.Scanner;

public class Rettangolo2 
{
    public static void main(String args[])
    { 
        int b;
        int h;

        Scanner input = new Scanner(System.in);

        System.out.println("Base: ");
        b = input.nextInt();

        System.out.println("Altezza: ");
        h = input.nextInt();

        System.out.println("Area: ");
        System.out.println(b*h);
    }
}