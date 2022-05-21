import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkWithFile {

    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public String[] readOneFile(String path) {
        String fileContents = readFileContentsOrNull(path);
        String[] lines = fileContents.split("\n");
        return lines;
    }

    String renamesMonthsForMonthlyAndYearlyReports(int monthNumber){
        String monthName = "";
        switch (monthNumber) {
            case 1:
                monthName = "Январь";
                break;
            case 2:
                monthName = "Февраль";
                break;
            case 3:
                monthName = "Март";
                break;
        }
        return monthName;
    }
}