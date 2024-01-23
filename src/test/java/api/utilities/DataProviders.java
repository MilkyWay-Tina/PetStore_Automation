package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// returns all the user 
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//Userdata.xlsx";// gets current project location(System.getProperty("user.dir")) 
		XLUtility xl=new XLUtility(path); //class instantiated to read data from Xl file
		
		int rownum=xl.getRowCount("Sheet1");// total no of rows and columns
		int colcount=xl.getCellCount("Sheet1", 1);// (1) any row number is passed to get the col count from the total no.of cells
		
		String apidata[][]=new String[rownum][colcount];// to create an array for reading the XL data with same no.of rows and cols
		
		//loops will get the data from excel to the 2 D array
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		return apidata;
	}
	
	//return only the username from the data
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//Userdata.xlsx";
		XLUtility xl=new XLUtility(path);
	
		int rownum=xl.getRowCount("Sheet1");	// to get the username column
			
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++)
		{		
			apidata[i-1]= xl.getCellData("Sheet1",i, 1);  
			
		}
	
		return apidata;
}
}
