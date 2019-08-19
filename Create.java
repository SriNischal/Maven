package atmecs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

class Create {
	static String excelFilePath = "StoreDetails.xls";
	static int rownum;
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		int n=0;
		XSSFWorkbook workbook1 = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook1.createSheet("Employee Details");
		HashMap<Integer, Object[]> data = new HashMap<Integer, Object[]>();
		try {
			Scanner input = new Scanner(System.in);

			rownum = ((XSSFSheet) sheet1).getLastRowNum();

			System.out.println("Enter Employee Details");
			while (true) {
				System.out.println("Enter Employee ID" + "," + "Enter Employee NAME" + "," + "Enter Employee POSITION"
						+ "," + "Enter Employee SALARY");

				
				data.put(rownum, new Object[] { input.nextInt(), input.next(), input.next(), input.next() });
				rownum++;
				System.out.println("do you want add another employee details");
				System.out.println("1). yes");
				System.out.println("2). no");
				if (input.nextInt() != 1)
					break;
			}
			Set<Integer> keyset = data.keySet();

			for (Integer key : keyset) {
				Row row = ((XSSFSheet) sheet1).createRow(n++);
				Object[] objArr = data.get(key);
				int cellnum = 0;
				for (Object obj : objArr) {
					Cell cell = row.createCell(++cellnum);
					if (obj instanceof String)
						cell.setCellValue((String) obj);
					else if (obj instanceof Integer)
						cell.setCellValue((Integer) obj);
				}
			}

			FileOutputStream outputStream = new FileOutputStream("StoreDetails.xls");
			workbook1.write(outputStream);
			workbook1.close();
			outputStream.close();

		} catch (IOException | EncryptedDocumentException ex) {
			ex.printStackTrace();
		}
	}

}
