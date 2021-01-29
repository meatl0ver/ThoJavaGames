package raul.imashev;

import java.util.Random;


public class FirstTask {
    public static final int RANDOM_BOUND = 10;
    public static final int COUNT_ATTEMPTS = 3;

    //метод для генерации случайного числа
    public static int generateNum(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    //первая игра
    public static void play(int countAttempts) {
        int userNum;
        int guessedNum = generateNum(RANDOM_BOUND);
        System.out.println("==========Начало игры!==========");
        System.out.println("Угадай число от 0 до " + RANDOM_BOUND);
        while (countAttempts > 0) {
            System.out.print("Введи число: ");
            userNum = Main.scanner.nextInt();
            if (userNum == guessedNum) {
                System.out.printf("Поздравляю, верный результат! Загаданое число: %d\n", guessedNum);
                break;
            } else {
                System.out.println("Неверно, попробуй снова!");
                countAttempts--;
            }
        }
        if (countAttempts == 0) {
            System.out.printf("Поражение! Загаданое число: %d\n", guessedNum);
        }
        System.out.println("==========Конец игры!==========");
        Main.playAgain(1);
    }
}
