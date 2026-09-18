package generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelutility {
	FileInputStream fis;
	FileOutputStream fos;
	
	public String readDataFromExcel(String sheetname, int rownum,int cellnum)throws Exception
	{
		fis=new FileInputStream("./src/test/resources/crm1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		return wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
	}
	
	public void writedatainExistingcell(String sheetname,int rownum,int cellnum,String value)throws Exception
	{
		fis=new FileInputStream("./src/test/resoueces/crm1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).setCellValue(value);
		fos=new FileOutputStream("./src/test/resoueces/project 1.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	public void writedatainnewcell(String sheetname,int rownum,int cellnum,String value)throws Exception
	{
		fis=new FileInputStream("./src/test/resoueces/project 1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).setCellValue(value);
		fos=new FileOutputStream("./src/test/resoueces/project 1.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	public int getrowcount(String sheetname)throws Exception{
		FileInputStream fis=new FileInputStream("./src/test/resources/crm1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheetname).getLastRowNum();
		return rowcount;
		
	}
	

}
