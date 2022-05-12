package excelUtil;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExcelUtility {

    public static void writeToExcel(String path, String sheetName, List<String> data) throws IOException {


        File f = new File(path);

        if (!f.exists()) {

            XSSFWorkbook workbook = new XSSFWorkbook(); //RAM"de yeni bir calisma kitabi(dosya) olusturuldu.
            XSSFSheet sheet = workbook.createSheet(sheetName);  //excel calisma kitabi(dosya) icinde sayfa olusturma.


                Row row = sheet.createRow(0); // satirlar olusturuluyor
                for (int i = 0; i <data.size(); i++) {
                    Cell cell = row.createCell(i); // her bir satira hucre degeri olusturuyoruz.
                    cell.setCellValue(data.get(i));
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

            for (int i = 0; i < data.size(); i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(data.get(i));
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
