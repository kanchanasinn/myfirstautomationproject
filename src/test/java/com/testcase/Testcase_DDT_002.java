package com.testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pageobject.Loginpage;
import com.utilities.XLUtils;

public class Testcase_DDT_002 extends Baseclass {

	@Test(dataProvider="LoginData")
	
	public void loginDDT(String username,String mobile) throws InterruptedException
	{
		Loginpage lp=new Loginpage(driver);
		
		lp.SetuserName(username);
		logger.info("user name provided");
		
		lp.Setmobilenumber(mobile);		
		logger.info("Mobile number provided");
				
		lp.clicksubmitbutton();		
		Thread.sleep(3000);
	}
		//if(isAlertPresent()==true)s
		//{
		//	driver.switchTo().alert().accept();//close alert
		//	driver.switchTo().defaultContent();
		//	Assert.assertTrue(false);
		//	logger.warn("Login failed");
		//}
		//else
	//	{
		//	Assert.assertTrue(true);
		//logger.info("Login passed");
	//		lp.clickLogout();
	//	Thread.sleep(3000);
	//		driver.switchTo().alert().accept();//close logout alert
	//	driver.switchTo().defaultContent();
	//	}
		
		
	
	
	
	//public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	//{
	//	try
	//	{
	//	driver.switchTo().alert();
	//	return true;
	//	}
	//catch(NoAlertPresentException e)
	//	{
	//		return false;
	//}
		
	
	
	
	 @DataProvider(name="LoginData")
	 
	 String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/testdata/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String loginData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return loginData;
	}
		
}