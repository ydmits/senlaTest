//passGenerator

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int lenght = -1;
        System.out.println("ВВЕДИТЕ ДЛИНУ ПАРОЛЯ - ОТ 8 ДО 12 СИМВОЛОВ");

        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            lenght = scanner.nextInt();
        }

        if (lenght < 8 || lenght > 12) {
            System.out.println("НЕКОРРЕКТНЫЙ ВВОД");
            System.exit(0);

        }

        Password password = new Password(lenght);

        System.out.println("СГЕНЕРИРОВАН ПАРОЛЬ ДЛИНОЙ " + lenght + " СИМВОЛОВ: " + password.getPassword());
    }
}