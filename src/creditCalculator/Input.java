package creditCalculator;

import java.util.Scanner;

public interface Input {

    Scanner scanner = new Scanner(System.in);

    static double setLoan() {
        System.out.println("Введите сумму займа (rub): ");
        double input = 0;
        try {
            input = scanner.nextDouble();
            if (input < 0) {
                System.out.println("Input Error. Вы ввели отрицательно число.");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Input Error. При вводе используйте только цифры");
            System.exit(0);
        }
        return input;
    }

    static double setYearsRate() {
        System.out.println("Введите годовой процент (%): ");
        double input = 0;
        try {
            input = scanner.nextDouble();
            if (input < 0) {
                System.out.println("Input Error. Вы ввели отрицательно число.");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Input Error. При вводе используйте только цифры");
            System.exit(0);

        }
        return input;
    }


    static int setYearsTerm() {
        System.out.println("Введите длину займа (years): ");
        int input = 0;
        try {
            input = scanner.nextInt();
            if (input < 0) {
                System.out.println("Input Error. Вы ввели отрицательно число.");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Input Error. При вводе используйте только цифры.");
            System.exit(0);

        }
        return input;
    }

    static int menu() {

        System.out.println("Для выбора позиции в меню введите цифру от 1-4.");
        System.out.println("1. Платеж в месяц.");
        System.out.println("2. Переплата ваше ипотеки.");
        System.out.println("3. График аннуитетных платежей.");
        System.out.println("0. Выход из приложения.");

        return scanner.nextInt();
    }
}
