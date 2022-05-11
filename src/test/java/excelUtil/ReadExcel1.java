package excelUtil;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class ReadExcel1 {

    public static void main(String[] args) throws IOException {

        String filename = "src/test/java/excelUtil/report.xls";
        String sayfa = "Sayfa2";
       // ilkMain();
     //   System.out.println("------------");
      //  System.out.println(getData(filename, sayfa));

        for (List<String> row : getData(filename,sayfa)) {
             String username = row.get(0);
             String password = row.get(1);

            System.out.println(username+", "+password);

        }

    }

    public static List<List<String>> getData(String file, String sayfa) throws IOException {

        List<List<String>> listOfValues = new LinkedList<>();

        InputStream input = new FileInputStream(file);

        Workbook workbook = WorkbookFactory.create(input);
        Sheet sheet = workbook.getSheet(sayfa);

        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            int cellNum = row.getPhysicalNumberOfCells();
            List<String> listOfCells = new LinkedList<>();
            for (int j = 0; j < cellNum; j++) {
                Cell cell = row.getCell(j);
                String cellValue = cell == null ? "" : cell.toString();
                listOfCells.add(cellValue);
            }
            listOfValues.add(listOfCells);
        }
        return listOfValues;
    }

    public static void ilkMain() throws IOException {

        List<List<String>> listOfValues = new LinkedList<>();

        String file = "src/test/java/excelUtil/report (1).xls";
        InputStream input = new FileInputStream(file);

        Workbook workbook = WorkbookFactory.create(input);
        Sheet sheet = workbook.getSheet("Sayfa1");

        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 0; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            int cellNum = row.getPhysicalNumberOfCells();
            List<String> listOfCells = new LinkedList<>();
            System.out.print(cellNum + "\t");
            for (int j = 0; j < cellNum; j++) {
                Cell cell = row.getCell(j);
                String cellValue = cell == null ? "" : cell.toString();
                System.out.print(cellValue + "\t");
                listOfCells.add(cellValue);
            }
            listOfValues.add(listOfCells);
            System.out.println();
        }
        System.out.println("---------------");
        System.out.println(listOfValues);
    }
}
