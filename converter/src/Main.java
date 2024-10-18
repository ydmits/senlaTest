//converter

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Currency USD_VND = new Currency("USD", "VND", 0.6548);
        final Currency USD_IDR = new Currency("USD", "IDR", 1.4359);
        final Currency USD_UZS = new Currency("USD", "UZS", 10.235);
        final Currency USD_GNF = new Currency("USD", "GNF", 0.8321);
        final Currency USD_PYG = new Currency("USD", "PYG", 0.0631);

        System.out.println("ВВЕДИТЕ СУММУ USD: ");

        Scanner scanner = new Scanner(System.in);
        double sum = -1.0;

        if (scanner.hasNextDouble()) {
            sum = scanner.nextDouble();
        }
        if (sum < 0) {
            System.out.println("Некорректный ввод");
        }
        else {
            System.out.println(USD_VND.toString() + sum * USD_VND.getRate());
            System.out.println(USD_IDR.toString() + sum * USD_IDR.getRate());
            System.out.println(USD_UZS.toString() + sum * USD_UZS.getRate());
            System.out.println(USD_GNF.toString() + sum * USD_GNF.getRate());
            System.out.println(USD_PYG.toString() + sum * USD_PYG.getRate());
        }


    }
}

