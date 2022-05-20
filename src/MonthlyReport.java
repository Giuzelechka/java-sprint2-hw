import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    boolean methodChosenMonthly = false;

    ArrayList<Report> month1 = new ArrayList<>();
    ArrayList<Report> month2 = new ArrayList<>();
    ArrayList<Report> month3 = new ArrayList<>();
    static ArrayList<Integer> sumOfIncome = new ArrayList<>();
    static ArrayList<Integer> sumOfExpense = new ArrayList<>();
    HashMap<Integer, ArrayList<Report>> valueMonth = new HashMap<>();
    WorkWithFile workWithFile = new WorkWithFile();

    void readAllMonthReport(int amountFiles) {
        for (int j = 1; j <= amountFiles; j++) {
            String pathMonth = "C:/Users/Гюзель/dev/java-sprint2-hw/resources/m.20210" + j + ".csv";
            String[] lines = workWithFile.readOneFile(pathMonth);
            for (int i = 1; i < lines.length; i++) {
                String[] lineContents = lines[i].split(",");
                Report report = new Report();
                report.setItem_name(lineContents[0]);
                report.setIs_expense(Boolean.parseBoolean(lineContents[1]));
                report.setQuantity(Integer.parseInt(lineContents[2]));
                report.setSum_of_one(Integer.parseInt(lineContents[3]));
                if (j == 1) month1.add(report);
                if (j == 2) month2.add(report);
                if (j == 3) month3.add(report);
            }
            valueMonth.put(1, month1);
            valueMonth.put(2, month2);
            valueMonth.put(3, month3);
        }
        methodChosenMonthly = true;
    }

    public static ArrayList<Integer> getSumOfIncome() {
        return sumOfIncome;
    }

    public static ArrayList<Integer> getSumOfExpense() {
        return sumOfExpense;
    }

    void informationAllMonthlyReport(int amountFiles) {
        int generalIncome;
        int generalExpenses;
        String mostProfitable;
        String biggestWaste;
        int sumOfMostProfitable;
        int sumOfbiggestWaste;

        if (!methodChosenMonthly) {
            System.out.println("Месячные отчеты не считаны");
            return;
        }
        for (var month : valueMonth.values()) {
            sumOfMostProfitable = 0;
            mostProfitable = "";
            sumOfbiggestWaste = 0;
            biggestWaste = "";
            generalIncome = 0;
            generalExpenses = 0;
            for (Report r : month) {
                int spending = r.getQuantity() * r.getSum_of_one();
                if (!r.isIs_expense()) {
                    if (spending > sumOfMostProfitable) {
                        sumOfMostProfitable = spending;
                        mostProfitable = r.getItem_name();
                    }
                    generalIncome += spending;
                } else {
                    if (spending > sumOfbiggestWaste) {
                        sumOfbiggestWaste = spending;
                        biggestWaste = r.getItem_name();
                    }
                    generalExpenses += spending;
                }
            }
            sumOfIncome.add(generalIncome);
            sumOfExpense.add(generalExpenses);
            System.out.println(workWithFile.fileName(1));
            System.out.println("Самый прибыльный товар: " + mostProfitable + " . Сумма дохода: " + sumOfMostProfitable + " .");
            System.out.println("Самая большая трата: " + biggestWaste + " . Сумма траты: " + sumOfbiggestWaste + " .");
        }
    }

}



class Report {
    private String item_name;
    private boolean is_expense;
    private int quantity;
    private int sum_of_one;

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public boolean isIs_expense() {
        return is_expense;
    }

    public void setIs_expense(boolean is_expense) {
        this.is_expense = is_expense;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSum_of_one() {
        return sum_of_one;
    }

    public void setSum_of_one(int sum_of_one) {
        this.sum_of_one = sum_of_one;
    }
}