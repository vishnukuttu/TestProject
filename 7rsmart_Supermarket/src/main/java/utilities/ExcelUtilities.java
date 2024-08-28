package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	static FileInputStream f;
	static XSSFWorkbook w; //in dependencies created in pom.xml file
	static XSSFSheet sh;
	
public static String getStringData(int a,int b,String sheetName) throws IOException
{
	f=new FileInputStream("D:\\Learnings\\SELENIUM\\ExcelReadData.xlsx"); // f is globally declared
	w=new XSSFWorkbook(f);//xssfworkbook class
	sh=w.getSheet(sheetName);//getsheet is method
	Row r =sh.getRow(a);//inteface
	Cell c=r.getCell(b);
	return c.getStringCellValue();
}

}
