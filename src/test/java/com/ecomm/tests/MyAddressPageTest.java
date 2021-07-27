package com.ecomm.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecomm.pages.HomePage;
import com.ecomm.pages.LoginPage;
import com.ecomm.pages.MyAddressPage;

public class MyAddressPageTest extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	MyAddressPage map;
	public XSSFWorkbook workbook;
    public XSSFSheet worksheet;
    public DataFormatter formatter= new DataFormatter();
    public String file_location = System.getProperty("user.dir")+"/src/test/java/com/ecomm/testData/Ecomm_TestData.xlsx";
    String SheetName= "Sheet1";
	
    @BeforeMethod
	public void setup() throws InterruptedException {
		initialise();
		lp = new LoginPage();
		hp= lp.ClickLogin(username, password);
		map=hp.ClickOnMyAddress();
		
	}
    
    /*@Test
    public void adp() {
    	map.AddNewAddress( );
    }*/
	
	@Test(priority=1, dataProvider="ReadVariant")
	public void VerifyAddNewAddress(String fn, String ln, String address, String city, String postCode, String phoneNumber, String mobileNumber, String rfa) {
		
		map.AddNewAddress(fn, ln, address, city, postCode, phoneNumber, mobileNumber, rfa);
		
	}
	
	@DataProvider
    public String[][] ReadVariant() throws IOException
    {
    FileInputStream fileInputStream= new FileInputStream(file_location); //Excel sheet file location get mentioned here
        workbook = new XSSFWorkbook (fileInputStream); //get my workbook 
        worksheet=workbook.getSheet(SheetName);// get my sheet from workbook
        XSSFRow Row=worksheet.getRow(0);     //get my Row which start from 0   
     
        int RowNum = worksheet.getPhysicalNumberOfRows();// count my number of Rows
        int ColNum= Row.getLastCellNum(); // get last ColNum 
         
        String Data[][]= new String[RowNum-1][ColNum]; // pass my  count data in array
         
            for(int i=0; i<RowNum-1; i++) //Loop work for Rows
            {  
                XSSFRow row= worksheet.getRow(i+1);
                 
                for (int j=0; j<ColNum; j++) //Loop work for colNum
                {
                    if(row==null)
                        Data[i][j]= "";
                    else
                    {
                        XSSFCell cell= row.getCell(j);
                        if(cell==null)
                            Data[i][j]= ""; //if it get Null value it pass no data 
                        else
                        {
                            String value=formatter.formatCellValue(cell);
                            Data[i][j]=value; //This formatter get my all values as string i.e integer, float all type data value
                        }
                    }
                }
            }
 
        return Data;
    }
}
