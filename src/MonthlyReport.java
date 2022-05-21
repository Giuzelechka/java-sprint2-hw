import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {

    ArrayList<Report> month1 = new ArrayList<>();
    ArrayList<Report> month2 = new ArrayList<>();
    ArrayList<Report> month3 = new ArrayList<>();
    HashMap<Integer, ArrayList<Report>> valueMonth = new HashMap<>();
    WorkWithFile workWithFile = new WorkWithFile();
    Report report = new Report();

    void readAllMonthReport(int amountFiles) {
        for (int j = 1; j <= amountFiles; j++) {
            String pathMonth = "C:/Users/Гюзель/dev/java-sprint2-hw/resources/m.20210" + j + ".csv";
            String[] lines = workWithFile.readOneFile(pathMonth);
            for (int i = 1; i < lines.length; i++) {
                String[] lineContents = lines[i].split(",");
                Report report = new Report();
                report.setItemName(lineContents[0]);
                report.setIsExpense(Boolean.parseBoolean(lineContents[1]));
                report.setQuantity(Integer.parseInt(lineContents[2]));
                report.setSumOfOne(Integer.parseInt(lineContents[3]));
                if (j == 1){ month1.add(report);}
                if (j == 2){ month2.add(report);}
                if (j == 3){ month3.add(report);}
            }
            valueMonth.put(1, month1);
            valueMonth.put(2, month2);
            valueMonth.put(3, month3);
        }
    }

    void informationAllMonthlyReport(ArrayList<Integer> sumOfIncome, ArrayList<Integer> sumOfExpense) {
        int generalIncome;
        int generalExpenses;
        String mostProfitable;
        String biggestWaste;
        int sumOfMostProfitable;
        int sumOfbiggestWaste;

        if(valueMonth.size() == 0) {
            System.out.println("Месячные отчеты не считаны");
        }
        for (var month : valueMonth.values()) {
            sumOfMostProfitable = 0;
            mostProfitable = "";
            sumOfbiggestWaste = 0;
            biggestWaste = "";
            generalIncome = 0;
            generalExpenses = 0;
            for (Report r : month) {
                int spending = r.getQuantity() * r.getSumOfOne();
                if (!r.isIsExpense()) {
                    if (spending > sumOfMostProfitable) {
                        sumOfMostProfitable = spending;
                        mostProfitable = r.getItemName();
                    }
                    generalIncome += spending;
                } else {
                    if (spending > sumOfbiggestWaste) {
                        sumOfbiggestWaste = spending;
                        biggestWaste = r.getItemName();
                    }
                    generalExpenses += spending;
                }
            }
            sumOfIncome.add(generalIncome);
            sumOfExpense.add(generalExpenses);
            System.out.println(workWithFile.renamesMonthsForMonthlyAndYearlyReports(1));
            System.out.println("Самый прибыльный товар: " + mostProfitable + " . Сумма дохода: " + sumOfMostProfitable + " .");
            System.out.println("Самая большая трата: " + biggestWaste + " . Сумма траты: " + sumOfbiggestWaste + " .");
        }
    }

}



