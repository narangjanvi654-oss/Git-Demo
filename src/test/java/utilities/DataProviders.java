package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][]getdata() throws IOException{
	
	String path=".\\testData\\Opencart_LoginData.xlsx";
	ExcelUtility util= new ExcelUtility(path);
	int totalrows=util.getRowCount("Sheet1");
	int totalcolumns=util.getCellCount("Sheet1", 1);
	
	String[][] LoginData=new String[totalrows][totalcolumns];
	for(int i=1;i<totalrows;i++){
		for(int j=0;j<totalcolumns;j++){
			LoginData[i-1][j]=util.getCellData("Sheet1", i, j); // Data storage
		
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	return null;

}}
