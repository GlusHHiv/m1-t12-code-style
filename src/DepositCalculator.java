import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double procent, int period) {
        double pay = amount * Math.pow((1 + procent / 12), 12 * period);
        return round(pay, 2);
  }

  double calculateSimplePercent(double amount, double rate, int period) {
         return round(amount+amount * rate * period, 2);
    }

    double round(double value, int places) {
       double scaLe = Math.pow(10, places);
       return Math.round(value * scaLe) / scaLe;
    }

    void manageDeposit() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double out = 0;

        if (action ==1) {
            out = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().manageDeposit();
    }
}
