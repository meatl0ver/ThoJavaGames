package raul.imashev;

import java.util.Random;

public class SecondTask {
    public static final int COUNT_ATTEMPTS = 5;
    public static final String[] WORDS = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
            "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
            "pepper", "pineapple", "pumpkin", "potato"};
    public static final int COUNT_OF_HIDDEN_CHARS = 15;

    //получение случайного слова
    public static String getRandomWord(String[] words) {
        Random random = new Random();
        int genetatedIndex = random.nextInt(words.length-1);
        return words[genetatedIndex];
    }

    //вторая игра
    public static void play(int countAttempts) {
        String guessedWord = getRandomWord(SecondTask.WORDS);
        StringBuilder res= new StringBuilder();
        System.out.println("==========Начало игры!==========");
        System.out.printf("Угадай слово! У тебя %d попыток!\n", countAttempts);
        System.out.println("Загаданные слова:");
        for (String i : SecondTask.WORDS) {
            if (i.equals(SecondTask.WORDS[SecondTask.WORDS.length - 1])) {
                System.out.print(i+".\n");
            } else {
                System.out.print(i + ", ");
            }
        }

        while (countAttempts > 0) {
            System.out.print("Вводи слово: ");
            String answer = Main.scanner.next();
            if (answer.equals(guessedWord)) {
                System.out.printf("Верно! Загаданое слово: %s\n",answer);
                break;
            } else {
                int i = 0;
                while (i < answer.length() && i < guessedWord.length()) {
                    if (answer.charAt(i) == guessedWord.charAt(i)) {
                        res.append(answer.charAt(i));
                    } else {
                        break;
                    }
                    i++;
                }
                int j =res.toString().length()-1;
                while (j < COUNT_OF_HIDDEN_CHARS) {
                    res.append("#");
                    j++;
                }
            }
            countAttempts--;
            System.out.println(res.toString() +" Осталось попыток: "+ countAttempts);
            res.setLength(0);
        }
        if (countAttempts == 0) {
            System.out.printf("Поражение! Загаданое слово: %s\n",guessedWord);
        }
        System.out.println("==========Конец игры!==========");
        Main.playAgain(2);
    }
}
