package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvier 1
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = "./testData/Opencart_login_Data.xlsx";
		ExcelUtils xlutil = new ExcelUtils(path); // creating an object for ExcelUtils and path here is for constructor

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcolumns = xlutil.getCellCount("Sheet1",1);
		
		String logindata[][] = new String[totalrows-1][totalcolumns]; // created for two dimensional array
		for(int i=1;i<totalrows;i++) {
			for(int j=0;j<totalcolumns;j++) {
				logindata[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		 return logindata;
		
		
		
	}

	
	//Data provider 2
	// Data provider 3
}
