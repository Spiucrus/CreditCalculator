package creditCalculator;

public class Calculate implements Input {


    private static double loan;
    private static double yearsRate;
    private static int yearsTerm;


    public Calculate(double loan, double yearsRate, int yearsTerm) {
        Calculate.loan = loan;
        Calculate.yearsRate = yearsRate;
        Calculate.yearsTerm = yearsTerm;
    }


    public void start() {
        boolean start = true;
        while (start) {
            try {
                switch (Input.menu()) {
                    case 1:
                        System.out.printf("Ваш платеж в месяц составит - %.0f руб.\n", getMonthPayments());
                        break;
                    case 2:
                        System.out.printf("Ваш переплата составит - %.0f руб.\n", overpayment());
                        break;
                    case 3:
                        System.out.println("График аннуитетных платежей: ");
                        annPayment();
                        break;
                    case 0:
                        System.out.println("Спасибо за использование калькулятора!");
                        start = false;
                        break;
                    default:
                        System.out.println("Что бы вопользоваться услугами вводите цифры которые представлены в меню.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Что бы вопользоваться услугами вводите цифры которые представлены в меню.");
                start = false;
            }
        }
    }


    // расчет месячного платежа
    private double getMonthPayments() {
        return loan * getMonthRate() * getTotalRate() / (getTotalRate() - 1);
    }

    // расчет основной Общей ставки
    private double getTotalRate() {
        return Math.pow((1 + yearsRate / 12 / 100), (yearsTerm * 12));
    }

    // расчет месячной ставки
    private double getMonthRate() {
        return yearsRate / 12 / 100;
    }

    // расчет оплаты процентной части
    private double getPercentPart() {
        return loan * getMonthRate();
    }

    // расчет оплаты основной части
    private double getMainPart() {
        return getMonthPayments() - getPercentPart();
    }

    // сумма переплаты
    private double overpayment() {
        return (getMonthPayments() * (yearsTerm * 12)) - loan;
    }

    // выплата процентов в месяц
    private double getPayPercentMonth() {
        return getMainPart() * getMonthRate();
    }

    // График аннуитетных платежей
    private void annPayment() {
        double debt = loan;
        double mainDebt = getMainPart() - getPayPercentMonth();
        double percent = getPayPercentMonth() + (getMonthPayments()-getPayPercentMonth()- mainDebt);
        System.out.println("________________________________________________________________");
        System.out.println("Остаток основной части | Платеж в месяц |   Долг   |  Проценты  |");
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i <= 10; i++) {
            if (debt >= 1000) {
                debt -= getMonthPayments() - getPercentPart();
                mainDebt += getMainPart()*getMonthRate();
                percent -= getMainPart()*getMonthRate();
            } else {
                break;
            }
            System.out.printf("%15.0f        |%11.0f     |   %.0f   |    %.0f   |\n", debt , getMonthPayments(), mainDebt, percent);
        }
    }
}
