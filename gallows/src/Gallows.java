import java.beans.Introspector;
import java.util.*;

public class Gallows {
    private final String[] WORDS = {"АНАНАС", "АБРИКОС", "ПЕРСИК", "ЯБЛОКО", "БАНАН", "СЛИВА", "ГРУША", "КОКОС"
            , "ВИНОГРАД", "НЕКТАРИН"};
    private String word;
    private String userWord = "";
    private int userHealth;
    private int letterCounter;
    private boolean isGameStarted;

    public void startGame(){
        printMenu();
    }

    private void printMenu() {
        while (true) {
            System.out.println("ГЛАВНОЕ МЕНЮ");
            System.out.println("1 - ИГРАТЬ");
            System.out.println("2 - СПИСОК СЛОВ");
            System.out.println("3 - ВЫХОД");

            Scanner scanner = new Scanner(System.in);
            int key = -1;

            if (scanner.hasNextInt()) {
                key = scanner.nextInt();
            }

            switch (key) {
                case 1:
                    runGame();
                    break;
                case 2:
                    printWords();
                    break;
                case 3:
                    exit();
                    break;
                default:
                    System.out.println("Неизвестная команда");
            }
        }
    }

    private void runGame() {
        iniWord();
        iniUserWord();
        userHealth = 6;
        letterCounter = userWord.length();
        isGameStarted = true;
        while (isGameStarted) {
            stepGame();

            if(userHealth < 0 || letterCounter <= 0) {
                isGameStarted = false;
            }
        }
        endGame();
    }

    private void printWords() {
        System.out.println(Arrays.toString(WORDS));
    }

    private void exit() {
        System.exit(0);
    }

    private void iniWord() {
        Random random = new Random();
        int i = random.nextInt(WORDS.length) + 1;
        word = WORDS[i];
    }

    private void iniUserWord() {
       for(int i = 0; i < word.length(); i++) {
           userWord += "_";
       }
    }

    private void stepGame() {
        printGallow(userHealth);
        printHealth(userHealth);
        System.out.println(userWord);
        System.out.println("Введите символ (для выхода введите 0): ");

        Scanner scanner = new Scanner(System.in);
        char symbol = scanner.next().toUpperCase().charAt(0);

        if (symbol == '0') {
            exit();
        }
        parse(symbol);
    }
    private void printGallow(int userHealth) {
        switch (userHealth) {
            case 6:
                System.out.println(
                                "_______\n" +
                                "|     |\n" +
                                "|\n" +
                                "|\n" +
                                "|\n" +
                                "|\n");
                break;
            case 5:
                System.out.println(
                                "_______\n" +
                                "|     |\n" +
                                "|     O\n" +
                                "|\n" +
                                "|\n" +
                                "|\n");
                break;
            case 4:
                System.out.println(
                                "_______\n" +
                                "|     |\n" +
                                "|     O\n" +
                                "|     |\n" +
                                "|\n" +
                                "|\n");
                break;
            case 3:
                System.out.println(
                                "_______\n" +
                                "|     |\n" +
                                "|     O\n" +
                                "|    /|\n" +
                                "|\n" +
                                "|\n");
                break;
            case 2:
                System.out.println(
                                "_______\n" +
                                "|     |\n" +
                                "|     O\n" +
                                "|    /|\\\n" +
                                "|\n" +
                                "|\n");
                break;
            case 1:
                System.out.println(
                                "_______\n" +
                                "|     |\n" +
                                "|     O\n" +
                                "|    /|\\\n" +
                                "|    /\n" +
                                "|\n");
                break;
            case 0:
                System.out.println(
                                "_______\n" +
                                "|     |\n" +
                                "|     O\n" +
                                "|    /|\\\n" +
                                "|     /\\\n" +
                                "|\n");
                break;
            default:
                System.out.println("Зесь могла быть виселица");
        }
    }

    private void printHealth(int userHealth) {
        String str = "";
        for(int i = 0; i < userHealth; i++) {
            str += "❤";
        }
        System.out.println(str);
    }

    private void parse(char symbol) {
        List<Integer> index = new ArrayList<>();
        for(int i = 0; i < userWord.length(); i++) {
            if (userWord.charAt(i) == '_' && word.charAt(i) == symbol) {
                index.add(i);
                if (index.size() > 0) {
                    coincidence(symbol, index);
                }
            } else if (userWord.charAt(i) == symbol) {
                index.add(i);
                repeat();
            }
        }
        if (index.size() == 0) {
            miss();
        }
    }

    private void coincidence(char symbol, List<Integer> index) {
        StringBuilder stringBuilder = new StringBuilder(userWord);
        for(Integer i : index){
            stringBuilder.setCharAt(i, symbol);
            letterCounter--;
        }
        userWord = stringBuilder.toString();

    }

    private void repeat() {
        System.out.println("СИМВОЛ УЖЕ ОТКРЫТ");
    }

    private void miss() {
        userHealth--;
    }

    private void endGame() {
        if (userHealth >= 0) {
            System.out.println(word);
            System.out.println("ПОБЕДА");
        }
        else System.out.println("ПРОЙГРЫШ");
        exit();
    }

}
