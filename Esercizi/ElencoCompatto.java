public class ElencoCompatto 
{
    public static void main(String args[])
    { 
        String[] lista = {"Peperoni", "Maionese", "Salsiccia"};
        String out = "";

        for (String s : lista) {
            out += s + ", ";
        }
        System.out.println(out);
    }
}