//MARADINI YURI

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CodiceFiscale 
{
    public static void LoadComuni(String path, HashMap<String, String> comuni) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path)); //comuni.txt
            String line = "";
        

            br.readLine(); //skips first line
            while ((line = br.readLine()) != null) {
                String[] splitted = line.split(";");
                comuni.put(splitted[1].toUpperCase(), splitted[6]);
            }
        } catch (Exception e) {
            System.exit(1);
        }
    }
    public static String getSurname(String s) {
        String vowels = "aeiou";
        String res = "";
        String resVowels = "";
        int i = 0;
        int vowelIndex = 0;
        int j = 0;
        while (i < 3 && j < s.length()) {
            if (!vowels.contains(String.valueOf(s.charAt(j)))) {
                res += s.charAt(j);
                i++;
            }
            else {
                resVowels += s.charAt(j);
            }
            j++;
        }
        
        i = 0;
        while (res.length() < 3) {
            res += resVowels.charAt(i);
            i++;
        }

        return res.toUpperCase();
    }

    public static String getName(String s) {
        String vowels = "aeiou";
        String res = "";
        String resVowels = "";
        int i = 0;
        int vowelIndex = 0;
        int j = 0;
        while (i < 4 && j < s.length()) {
            if (!vowels.contains(String.valueOf(s.charAt(j)))) {
                if (i != 2) {
                    res += s.charAt(j);
                }
                i++;
            }
            else {
                resVowels += s.charAt(j);
            }
            j++;
        }
        
        i = 0;
        while (res.length() < 3) {
            res += resVowels.charAt(i);
            i++;
        }

        return res.toUpperCase();
    }

    public static String getDate (String s, boolean b) {
        String[] parts = s.split("/");
        String res = "";

        res += parts[2];

        HashMap<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("01", "A");
        dictionary.put("02", "B");
        dictionary.put("03", "C");
        dictionary.put("04", "D");
        dictionary.put("05", "E");
        dictionary.put("06", "H");
        dictionary.put("07", "L");
        dictionary.put("08", "M");
        dictionary.put("09", "P");
        dictionary.put("10", "R");
        dictionary.put("11", "S");
        dictionary.put("12", "T");

        res += dictionary.get(parts[1]);

        if (b) {
            res += Integer.parseInt(parts[0]) + 40;
        }
        else {
            res += parts[0];
        }

        return res;
    }

    public static String getTown (String s) {
        return Comune.comuni.get(s);
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        
        LoadComuni("comuni.txt", Comune.comuni);
        System.out.print("Nome: ");
        String name = input.nextLine();
        
        System.out.print("Cognome: ");
        String surname = input.nextLine();
        
        System.out.print("Data di nascita gg/mm/aa: ");
        String date = input.nextLine();
        
        System.out.print("Genere m/f: ");
        boolean genre;
        if (input.nextLine().equals("m")) {
            genre = false;
        }
        else
        {
            genre = true;
        }

        System.out.print("Comune di nascita: ");
        String town = input.nextLine();

        String codiceFiscale = "";

        codiceFiscale += getSurname(surname);
        codiceFiscale += getName(name);
        codiceFiscale += getDate(date, genre);
        codiceFiscale += getTown(town.toUpperCase());
        System.out.println(codiceFiscale);
    }
}

public class Comune {
    public static HashMap<String, String> comuni = new HashMap<String, String>();
}

