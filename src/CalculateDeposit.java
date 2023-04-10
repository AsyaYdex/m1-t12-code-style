import java.util.Scanner;

public class CalculateDeposit {
    private static final int MONTH_AMOUNT = 12;
    private static final int ROUND_PLACES = 2;
    private static final double YEAR_RATE = 0.06;
    private static final double DECIMAL = 10;

    public static void main(String[] args) {
        new CalculateDeposit().calculate();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / MONTH_AMOUNT), MONTH_AMOUNT * depositPeriod);
        return round(pay, ROUND_PLACES);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, ROUND_PLACES);
    }

    double round(double value, int places) {
        double scale = Math.pow(DECIMAL, places);
        return Math.round(value * scale) / scale;
    }

    void calculate() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        double outAmount = 0;
        if (action == 1)
            outAmount = calculateSimplePercent(amount, YEAR_RATE, period);
        else if (action == 2) {
            outAmount = calculateComplexPercent(amount, YEAR_RATE, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outAmount);
    }
}
