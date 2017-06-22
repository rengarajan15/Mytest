package opentaps.lead;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class NewExcel extends OpentapsWrappers {
  @Test
  public void excel() throws InvalidFormatException, IOException {
	  File input=new File("./Login.xlsx");
		XSSFWorkbook wbook=new XSSFWorkbook(input);
		XSSFSheet sheet=wbook.getSheet("Sheet1");
		int rowcount=sheet.getLastRowNum();
		short coulumcount=sheet.getRow(0).getLastCellNum();
		for (int i = 1; i <=rowcount; i++) {
			XSSFRow row = sheet.getRow(i);
			
			for (int j = 0; j <coulumcount; j++) {
				XSSFCell cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
			}
		}

  }
}
