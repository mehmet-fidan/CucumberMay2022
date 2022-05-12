package excelUtil;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class writeExcel {

    public static void main(String[] args) throws IOException {

        String path = "src/main/java/excelUtil/excel1.xlsx";
        String sheetName = "Sayfa1";

        // HSSFWorkbook --> xls icin
        // XSSFWorkbook --> xlsx icin

        File f = new File(path);

        if (!f.exists()) {

            XSSFWorkbook workbook = new XSSFWorkbook(); //RAM"de yeni bir calisma kitabi(dosya) olusturuldu.
            XSSFSheet sheet = workbook.createSheet(sheetName);  //excel calisma kitabi(dosya) icinde sayfa olusturma.

            for (int i = 0; i < 10; i++) { // satirlar olusturuluyor
                Row row = sheet.createRow(i);
                for (int j = 0; j < 10; j++) {
                    Cell cell = row.createCell(j); // her bir satira hucre degeri olusturuyoruz.
                    cell.setCellValue(i * j);
                }
            }

            FileOutputStream out = null;

            try {
                out = new FileOutputStream(path);
                workbook.write(out);
                workbook.close();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("dosya mevcut");

            FileInputStream input = null;
            Workbook workbook = null;
            Sheet sheet = null;

            try {
                input = new FileInputStream(path);
                workbook = WorkbookFactory.create(input);
                sheet = workbook.getSheet(sheetName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int numOfRows = sheet.getPhysicalNumberOfRows();
            Row row = sheet.createRow(numOfRows);

            for (int i = 0; i < 10; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(numOfRows * i);
            }

            FileOutputStream output = null;

            try {
                input.close();
                output = new FileOutputStream(path);
                workbook.write(output);
                workbook.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}