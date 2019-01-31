package filterFile;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;

public class FilterExcel {
	public static void main(String[] args) throws Exception {  
	    //test file is located in your project path         
	    FileInputStream fileIn = new FileInputStream("C:\\Users\\SUBROY\\Downloads\\Abhishek20180905032650.csv");
	    //read file 
	    POIFSFileSystem fs = new POIFSFileSystem(fileIn); 
	    HSSFWorkbook filename = new HSSFWorkbook(fs);
	    //open sheet 0 which is first sheet of your worksheet
	    HSSFSheet sheet = filename.getSheetAt(0);
	    //HSSFSheet sheet = filename.getSheet("sheet1");
	    //we will search for column index containing string "Your Column Name" in the row 0 (which is first row of a worksheet
	    //String columnWanted = "Mainly used for";
	    String columnWanted = "Number Series";
	    Integer columnNo = null;
	    //output all not null values to the list
	    List<Cell> cells = new ArrayList<Cell>();
	 
	    Row firstRow = sheet.getRow(0);
	 
	    for(Cell cell:firstRow){
	        if (cell.getStringCellValue().equals(columnWanted)){
	            columnNo = cell.getColumnIndex();
	        }
	    }
	 
	 
	    if (columnNo != null){
	    for (Row row : sheet) {
	       Cell c = row.getCell(columnNo);
	       if (c == null || c.getCellType() == Cell.CELL_TYPE_BLANK) {
	          // Nothing in the cell in this row, skip it
	       } else {
	          cells.add(c);
	       }
	    }
	    }else{
	        System.out.println("could not find column " + columnWanted + " in first row of " + fileIn.toString());
	    }
	 
	    }

}
