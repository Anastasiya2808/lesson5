import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        // Заменить все буквы в слове на строчные, а первую букву на заглавную.
        // Например, дано hello, получаем Hello / дано HeLLO, получаем Hello

        Scanner in = new Scanner(System.in);
        System.out.println("Напишите слово: ");
        String word = in.nextLine();
        String result = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
        System.out.print(result);
    }
}
