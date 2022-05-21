import java.util.ArrayList;
import java.util.HashMap;

public class DataReconciliation {

    void reconciliation(int amountFiles, ArrayList<Integer> sumOfIncome, ArrayList<Integer> sumOfExpense, HashMap<Integer, Integer> profit, HashMap<Integer, Integer> expense) {
        if ((sumOfIncome.size() == 0) || (profit.size() == 0)) {
            System.out.println("Отчеты не подсчитаны");
            return;
        } else {

            for (int i = 0; i < amountFiles; i++) {
                if ((sumOfIncome.get(i).equals(profit.get(i + 1))) &&
                        (sumOfExpense.get(i).equals(expense.get(i + 1)))) {
                    System.out.println("Месяц - " + (i + 1) + ". Операция завершена успешно.");
                } else {
                    System.out.println("Операция завершена с ошибкой. Ошибка в месяце " + (i + 1));
                }
            }

        }
    }
}
