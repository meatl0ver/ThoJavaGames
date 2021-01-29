package raul.imashev;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in); //сканер public, потом
    public static void main(String[] args) {
        chooseGame();
    }
    // Метод для выбора игры
    public static void chooseGame() {
        System.out.println("Выберите игру. 1 – \"Угадай число\" / 2 – \"Угадай слово\" / 0 - Выход.");
        int chooseGame = Main.scanner.nextInt();
        if (chooseGame == 1) {
            FirstTask.play(FirstTask.COUNT_ATTEMPTS);
        } else if (chooseGame == 2) {
            SecondTask.play(SecondTask.COUNT_ATTEMPTS);
        } else {
            System.out.println("До встречи!");
            scanner.close();
        }
    }

    //Метод для повторной игры
    public static void playAgain(int game) {
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет (1 – повторить, 0 – нет).");
        int playAgainNum = Main.scanner.nextInt();
        if (playAgainNum == 1) {
            if (game == 1) {
                FirstTask.play(FirstTask.COUNT_ATTEMPTS);
            } else {
                SecondTask.play(SecondTask.COUNT_ATTEMPTS);
            }

        } else {
            System.out.println("До встречи!");
            Main.chooseGame();
        }
    }

}
