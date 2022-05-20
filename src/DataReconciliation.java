public class DataReconciliation {

    void reconciliation(int amountFiles) {
        if ((MonthlyReport.getSumOfIncome().size() == 0) || (YearlyReport.getProfit().size() == 0)) {
            System.out.println("Отчеты не подсчитаны");
            return;
        } else {

            for (int i = 0; i < amountFiles; i++) {
                if ((MonthlyReport.getSumOfIncome().get(i).equals(YearlyReport.getProfit().get(i + 1))) &&
                        (MonthlyReport.getSumOfExpense().get(i).equals(YearlyReport.getExpense().get(i + 1)))) {
                    System.out.println("Месяц - " + (i + 1) + ". Операция завершена успешно.");
                } else {
                    System.out.println("Операция завершена с ошибкой. Ошибка в месяце " + (i + 1));
                }
            }

        }
    }
}
