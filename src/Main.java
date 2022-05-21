import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int amountFiles = 3; // количество месячных отчетов

        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        DataReconciliation dataReconciliation = new DataReconciliation();
        ArrayList<Integer> sumOfIncome = new ArrayList<>();
        ArrayList<Integer> sumOfExpense = new ArrayList<>();
        HashMap<Integer, Integer> profit = new HashMap<>();
        HashMap<Integer, Integer> expense = new HashMap<>();

        printMenu();
        int userCommand = scanner.nextInt();

        while (userCommand != 0) {
            switch (userCommand){
                case 1:
                    monthlyReport.readAllMonthReport(amountFiles);
                    break;
                case 2:
                    yearlyReport.readYearReport(profit, expense);
                    break;
                case 3:
                    dataReconciliation.reconciliation(amountFiles, sumOfIncome, sumOfExpense, profit,  expense);
                    break;
                case 4:
                    monthlyReport.informationAllMonthlyReport(sumOfIncome, sumOfExpense);
                    break;
                case 5:
                    yearlyReport.informationYearReports(amountFiles, profit, expense);
                    break;
            }

            printMenu();
            userCommand = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu(){
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }


}