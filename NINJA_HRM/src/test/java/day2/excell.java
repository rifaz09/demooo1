package day2;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excell {
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/project 1.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		System.out.println("getLastrownum: "+sh.getLastRowNum());
		System.out.println("getPhysicalnumberofcells: "+sh.getPhysicalNumberOfRows());
		
		Row rw = sh.getRow(0);
		
		System.out.println("getLastrownum value: "+rw.getLastCellNum());
		System.out.println("getphysicalnumberofcel: "+ rw.getPhysicalNumberOfCells());
		
		Cell cell = rw.getCell(1);
		System.out.println("value: "+cell.toString());
	}

}
