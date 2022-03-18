public class Task3 {
    public static void main(String[] args) {
        //Найдите самое длинное слово в предложении,
        // при условии, что в предложении все слова разной длины.
        // Предложение для поска длинного слова: "в предложении все слова разной длины".

        String sentens = "В предложении все слова разной длинны";
        String longesWord  = "";
        String[] wordArr = sentens.split("");

        for (String word : wordArr){
            if (word.length() > longesWord.length()) longesWord = word;
        }
        System.out.println("самое длинное слово в предложении: " + longesWord);
    }
}
