package excelUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainExcel {

    public static void main(String[] args) throws IOException {

        String path = "src/main/java/excelUtil/excel2.xlsx";
        String sheetName = "Sayfa5";

        List<String> list1 = new ArrayList<>(Arrays.asList("Baslik1", "Baslik2", "Baslik3", "Baslik4", "Baslik5"));
        ExcelUtility.writeToExcel(path, sheetName, list1);

        list1 = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));
        ExcelUtility.writeToExcel(path, sheetName, list1);

       list1= new ArrayList<>(Arrays.asList("11", "22", "33", "44", "55"));
        ExcelUtility.writeToExcel(path, sheetName, list1);

    }
}
