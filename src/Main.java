import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int amountFiles = 3; // количество месячных отчетов

        Scanner scanner = new Scanner(System.in);
        ConsoleApp consoleApp = new ConsoleApp();
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        DataReconciliation dataReconciliation = new DataReconciliation();

        consoleApp.printMenu();
        int userCommand = scanner.nextInt();

        while (userCommand != 0) {
            switch (userCommand){
                case 1:
                    monthlyReport.readAllMonthReport(amountFiles);
                    break;
                case 2:
                    yearlyReport.readYearReport();
                    break;
                case 3:
                    dataReconciliation.reconciliation(amountFiles);
                    break;
                case 4:
                    monthlyReport.informationAllMonthlyReport(amountFiles);
                    break;
                case 5:
                    yearlyReport.informationYearReports(amountFiles);
                    break;
            }

            consoleApp.printMenu();
            userCommand = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }


}