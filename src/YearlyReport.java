import java.io.File;
import java.util.HashMap;

public class YearlyReport {
    String pathYear = "resources/y.2021.csv";
    WorkWithFile workWithFile = new WorkWithFile();

    void readYearReport(HashMap<Integer, Integer> profit, HashMap<Integer, Integer> expense) {
        String[] lines = workWithFile.readOneFile(pathYear);
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            if (!Boolean.valueOf(lineContents[2])) {
                profit.put(Integer.parseInt(lineContents[0].replace("0", "")), Integer.parseInt(lineContents[1]));
            } else {
                expense.put(Integer.parseInt(lineContents[0].replace("0", "")), Integer.parseInt(lineContents[1]));
            }
        }
    }

    void informationYearReports(int amountFiles, HashMap<Integer, Integer> profit, HashMap<Integer, Integer> expense) {
        String yearName = new File(pathYear).getName().replace("y.", "").replace(".csv", "");
        String monthName = "";
        int income = 0;
        int averageExpense = 0;
        int averageIncome = 0;

        if ((profit.size() == 0) || (expense.size() == 0)) {
            System.out.println("Годовой отчет не считан");
        } else {
            System.out.println(yearName);
            for (int i = 1; i <= amountFiles; i++) {
                monthName = workWithFile.renamesMonthsForMonthlyAndYearlyReports(i);
                income = profit.get(i) - expense.get(i);
                averageExpense += expense.get(i) / amountFiles;
                averageIncome += profit.get(i) / amountFiles;
                System.out.println(monthName);
                System.out.println("Прибыль: " + income);
            }
            System.out.println("Средний расход за все месяцы в году: " + averageExpense);
            System.out.println("Средний доход за все месяцы в году: " + averageIncome);
        }
    }
}