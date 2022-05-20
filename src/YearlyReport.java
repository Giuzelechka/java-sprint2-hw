import java.io.File;
import java.util.HashMap;

public class YearlyReport {
    boolean methodChosenYear = false;

    String pathYear = "C:/Users/Гюзель/dev/java-sprint2-hw/resources/y.2021.csv";
    static HashMap<Integer, Integer> profit = new HashMap<>();
    static HashMap<Integer, Integer> expense = new HashMap<>();

    WorkWithFile workWithFile = new WorkWithFile();

    void readYearReport() {
        String[] lines = workWithFile.readOneFile(pathYear);
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            if (!Boolean.valueOf(lineContents[2])) {
                profit.put(Integer.parseInt(lineContents[0].replace("0", "")), Integer.parseInt(lineContents[1]));
            } else {
                expense.put(Integer.parseInt(lineContents[0].replace("0", "")), Integer.parseInt(lineContents[1]));
            }
        }
        methodChosenYear = true;
    }

    public static HashMap<Integer, Integer> getProfit() {
        return profit;
    }

    public static HashMap<Integer, Integer> getExpense() {
        return expense;
    }

    void informationYearReports(int amountFiles) {
        String yearName = new File(pathYear).getName().replace("y.", "").replace(".csv", "");
        String monthName = "";
        int income = 0;
        int averageExpense = 0;
        int averageIncome = 0;

        if(!methodChosenYear){
            System.out.println("Годовой отчет не считан");
            return;
        }
        System.out.println(yearName);
        for (int i = 1; i <= amountFiles; i++) {
            monthName = workWithFile.fileName(i);
            income = profit.get(i) - expense.get(i);
            averageExpense += expense.get(i)/amountFiles;
            averageIncome += profit.get(i)/amountFiles;
            System.out.println(monthName);
            System.out.println("Прибыль: " + income);
        }
        System.out.println("Средний расход за все месяцы в году: " + averageExpense);
        System.out.println("Средний доход за все месяцы в году: " + averageIncome);
    }
}