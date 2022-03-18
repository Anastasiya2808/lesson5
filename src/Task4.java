import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        // Определить, является ли срока полиндромом.

        String string1 = "а роза упала на лапу Азора";
        StringBuilder reverseString = new StringBuilder(string1).reverse();
        System.out.println("reverseString" + reverseString);
        if (string1.equalsIgnoreCase(reverseString.toString())) {
            System.out.println(string1 + " - полиндром");
        } else {
            System.out.println(string1 + " - не полиндром");
        }

    }
}
