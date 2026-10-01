
	package utilities; // Package declaration

	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtility {

	    public FileInputStream fi;
	    public FileOutputStream fo;
	    public XSSFWorkbook workbook;
	    public XSSFSheet sheet;
	    public XSSFRow row;
	    public XSSFCell cell;
	    public CellStyle style;
	    String path;

	    // Constructor: Jab aap object banayenge tab file ka path pass karenge
	    public ExcelUtility(String path) {
	        this.path = path;
	    }

	    // Method: Sheet mein kitne rows hain count karne ke liye
	    public int getRowCount(String sheetName) throws IOException {
	        fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);
	        sheet = workbook.getSheet(sheetName);
	        int rowcount = sheet.getLastRowNum();
	        workbook.close();
	        fi.close();
	        return rowcount;
	    }

	    // Method: Specific row mein kitne cells (columns) hain
	    public int getCellCount(String sheetName, int rownum) throws IOException {
	        fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);
	        sheet = workbook.getSheet(sheetName);
	        row = sheet.getRow(rownum);
	        int cellcount = row.getLastCellNum();
	        workbook.close();
	        fi.close();
	        return cellcount;
	    }

	    public String getCellData(String sheetName, int rownum, int colnum) throws IOException 
	    {
	        fi = new FileInputStream(path);
	        workbook = new XSSFWorkbook(fi);
	        sheet = workbook.getSheet(sheetName);
	        row = sheet.getRow(rownum);
	        cell = row.getCell(colnum);

	        String data;
	        try 
	        {
	            // Cell ki value ko String mein convert karke read karta hai
	            data = cell.toString();
	        } 
	        catch (Exception e) 
	        {
	            data = ""; // Agar cell khali ho toh empty string return karega
	        }

	        workbook.close();
	        fi.close();
	        return data;
	    }
		}
	

