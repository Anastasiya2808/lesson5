
import java.util.Arrays;
import java.util.Scanner;


public class Task1 {
    public static void main(String[] args) {
        //Задать массив на N слов.
        // В цикле считывать с консоли слова (scanner.nextLine()),
        // и добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
        // В итоге в массиве будут только уникальные слова.

        Scanner scanner = new Scanner(System.in);
        System.out.println("Напишите размер массива: ");
        int arrSize = scanner.nextInt(); // Enter
        scanner.nextLine();

        String[] words = new String[arrSize];

        for (int i =0; i < words.length; i++){
            System.out.println("Введите слово: ");
            String word = scanner.nextLine();
            if ("exit".equals(word))break;
            for (String fromArr: words) { // [null, null, null]
                if (word.equalsIgnoreCase(fromArr)){
                    System.out.println("Такое слово уже есть");
                    i -=1;
                    break;
                }
                if (fromArr == null);
                words[i] = word;
            }

        }
        System.out.println(Arrays.toString(words));
    }
}
