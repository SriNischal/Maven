package atmecs;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class Update {
 
 
    public static void main(String[] args) throws InvalidFormatException {
        String excelFilePath = "StoreDetails.xls";
         
        try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
 
            Sheet sheet = workbook.getSheetAt(0);
 
            Object[][] bookData = {
                    {2,"k","l",20},
                    {4,"l","p",30},
            };
 
            int rowCount = sheet.getLastRowNum();
 
            for (Object[] details : bookData) {
                Row row = sheet.createRow(++rowCount);
 
                int columnCount = 0;
                 
                Cell cell = row.createCell(columnCount);
                cell.setCellValue(rowCount);
                 
                for (Object field : details) {
                    cell = row.createCell(++columnCount);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                }
 
            }
 
            inputStream.close();
 
            FileOutputStream outputStream = new FileOutputStream("StoreDetails.xls");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
             
        } catch (IOException | EncryptedDocumentException ex) {
            ex.printStackTrace();
        }
    }
 
}