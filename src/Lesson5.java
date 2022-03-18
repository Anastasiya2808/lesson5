import java.util.Arrays;

public class Lesson5 {
    public static void main(String[] args) {
        // char (приметивный тип данных) 16 битный символ Unicode
        // от 0 до 65536 (нет отрицательных кодов) / '\u0000' до '\uffff'

        char char1 = 'J'; // ' - одиночные ковычки, помещается 1 символ, если '' тогда это строка, сам символ
        char char2 = 74; // - номер символа J (в Юникоде)
        char char3 = '\u0044'; // номер символа, 16-ричное представление символа в escape

        // по следовательности
        // print - без переноса строки в консоли
        System.out.print(char1); // J
        System.out.print(char2); // J
        System.out.print(char3);// D

        // System.out.println("\nСтроки");

        //Строка - упорядоченная последовательности символов
        // Строка - ссылочные тип, экземпляр класса String - хронится символы в строке - строка
        // Строки задаются:
        // 1. в двойных ковычках ''
        // 2. new String(), спользуем только если способ создания строки через "" невозможен
        // 3. Строчки неизменны, можно лишь создать новую строку на основе существующей

        System.out.println("Строковый литерал");

        char [] chars = {'\u004A', '\u004A', '\u004A'};
        String jjdString = new String(chars);
        System.out.println(jjdString);
        System.out.println(jjdString.length()); // вернет длинну строки (строчка - jjdString, length - кол-во шт. // 3

        char [] chars1 = {'\uD83D', '\uDC38'}; // суррогатная пара чаров - друг без друга не получается результат
        String frogString = new String(chars1);
        System.out.println(frogString); // 🐸
        System.out.println(frogString.length()); // 2
        System.out.println(frogString.codePoints().count()); // 1, количество символов

        // Хранение строк до JAVA 9: массив char[] в кодировке UTF-16
        // каждый чар был представлен 2-мя байтами

        // Начиная с 9 версии строки (компактные строки)
        // хранятся как массив byte[] + кодировка LATIN1 или UTF-16

        // Пул строк - отдельная хранение - хранит только одну копию каждого строкового литерала
        // хронятся только оригинальные
        // Пул строк - "Строка" - ссылается на этот объект - string1
        // пул строк - string2 ссылается на string1, т.к уже не оригинальная
        // пул строк: "Строка", "Строка4", "Строка44" - интернированные строки всегда в пул
        // "Строка" (heap -куча памяти)

        String string1 = "Строка";
        String string2 = "Строка";

        String string3 = new String("Строка"); // хронится не в пуле, а в памяти, считается ,как новый объект
        // если через new тогда, каждый раз сохраняет как оригинальный

        System.out.println(string1 == string2); // true - стравнивается только примитивы, через ==
        System.out.println(string1 == string3);// false

        String internString = string3.intern(); // процесс интернирования
        // смотрит в пул строк , если в пуле строк есть такая строка, то он возвращает строку
        // internString ссылается на "Строка" из пула


        string1 = "Строка";
        string2 = "Строка";

        //Сравнение строк
        // для сравления не используем ==, тк == сравнивает ссылки

        System.out.println(string1.equals(string2)); // true - string1 сравниваем string2
        System.out.println("cтрока".equals(string2)); // false (регистр учитывается, в string2 большая буква, а в слове "строка" маленькая
        System.out.println("cтрока".equalsIgnoreCase(string2)); // true - без учета регистра , будут ровны

        string2 = null; //  string2 больше не обращается к значению

        System.out.println("cтрока".equals(string2)); // лучше способ, чем ниже
        // System.out.println(string2.equals("строка")) - программа выдаст ошибку (если не уверены)
        // NullPointerException -ошибка времени выполнения

        // если используется null , то используется обычное ==
        System.out.println(string2 == null); // true
        System.out.println(string2 != null); // false

        string1 = "Java";
        string2 = "Python";

        // конкатенация строк - склеивание строк
        String concatString = string1 + " :: " + string2;
        System.out.println(concatString); // Java :: Python

        // Java ::
        // Java :: Python
        concatString = string1.concat(" :: ").concat(string2);

        concatString = String.join(" :: ", string1,string2); // " :: " - задается между всеми перечисленными элементами

        concatString = "";
        for (int i = 0; i < 10; i++){
            concatString += i + " "; // +=  не ставится, создается слишком много объектов
        }
        System.out.println(concatString);

        // StringBuilder - работает быстрее
        // StringBuffer - потокобезопасный (может использоваться в многопоточных приложениях)

        // способ 1
        string1 = "Java";
        string2 = "Python";
        concatString = "Начало строки ";
        //буферизированные строки, не создавать новые, а через .append добавляет сущестующие (склеивает)
        StringBuilder sd = new StringBuilder(concatString); // передаем с чего начинается склейка - Начало строки
        sd.append(string1).append(" :: ").append(string2); //  Начало строки Java :: Python

        // способ 2
        StringBuilder sd2 = new StringBuilder(concatString);
        for (int i = 0; i < 10; i++) {
            sd2.append(i).append(" "); // будет накапливать
        }
        System.out.println(sd2); //  уже вызван .toString

        // как из стритбилдера вытащить строку
        String sdString = sd2.toString(); // возвращиет строчку, которую накопил билдер и присвоили ему значение
        System.out.println(sdString);


        // метод split()
        String langs = "Java, Python, JavaScript";
        String[] langArr = langs.split(", "); // вырезает кусок, который указан в ковычках
        System.out.println(Arrays.toString(langArr));

        // методы замены
        // поддерживает регулярные значение (меняет все значения) (поиск символов..)
        String newString = langs.replaceAll(", ", " - "); // сперва что хотим заменить, а потом на что хотим поменять
        System.out.println(newString);

        // меняет только 1 последовательность
        newString = langs.replaceFirst(", ", " - "); // сперва что хотим заменить, а потом на что хотим поменять
        System.out.println(newString);

        // не поддериживает регулярные значения
        newString = langs.replace(", ", " - "); //
        System.out.println(newString);

        // проверяет содержит ли строка последовательность
        System.out.println(langs.contains("th")); // true

        // начинаетя ли строка с j символов
        System.out.println(langs.startsWith("j")); // false

        // проверяет заканчивается ли строка на Script
        System.out.println(langs.endsWith("Script")); // true

        // проверяет ли индекс a символа 1,
        System.out.println(langs.startsWith("a",1)); //true



    }
}


