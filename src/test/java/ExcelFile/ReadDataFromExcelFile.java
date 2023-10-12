package ExcelFile;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("") ;
		Workbook wb = WorkbookFactory.create(file);
		
		String CUSTNAME = wb.getSheet("CreateCustomer").getRow(1).getCell(2).getStringCellValue();
		String CUSTDESC = wb.getSheet("CreateCustomer").getRow(1).getCell(3).getStringCellValue();


		System.out.println(CUSTNAME);
		System.out.println(CUSTDESC);

	}

}
