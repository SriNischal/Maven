package atmecs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Search {
	public void xlsxReader() throws IOException {
		String xlsxFilePath = "StoreDetails.xls";

		XSSFWorkbook workbook = new XSSFWorkbook(xlsxFilePath);

		XSSFSheet sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIt = sheet.rowIterator();
		while (rowIt.hasNext()) {
			Row row = rowIt.next();

			Iterator<Cell> cellIt = row.cellIterator();
			while (cellIt.hasNext()) {
				Cell cell = cellIt.next();
				System.out.print(cell.toString() + " ");
			}
			System.out.println();
		}

	}


}