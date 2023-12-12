package assignments_testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import assignments_Baseclass.Baseclass_Assignment;
import assignments_pageobjects.LoginPage_Assignment;
import assignments_utilities.Excel_Utilities;
//import pageobjects.LoginPage;

public class DataDriven_Test extends Baseclass_Assignment{
	
	@Test(dataProvider="Exceldata")
	   public void Datadriventest(String user,String pwd) throws IOException, InterruptedException {
	       
	       LoginPage_Assignment lp=new LoginPage_Assignment(driver);
	       
	         
	       
	       lp.setUsername(user);
	       
	       Thread.sleep(4000);
	       
	       lp.setPassword(pwd);
	       
	       Thread.sleep(4000);
	       
	       lp.ClickLoginbtn();
	       
	       String exp_result="OrangeHRM";
	       String act_result=driver.getTitle();
	       
	       if(act_result.equals(exp_result)) {
	           
	           Assert.assertTrue(true);//hard asserts
	           
	           log.info("testcase is pass");
	       }
	       else {
	           
	           captureScreen(driver,"Datadriventest");
	           Assert.assertTrue(false);
	           
	           log.info("testcase is failed");
	       }
	       
	   }
	   @DataProvider(name="Exceldata")
	   String [][] getData() throws IOException{
	       
	       String path=System.getProperty("user.dir")+"\\src\\test\\java\\testdata\\Exceldata.xlsx";
	       int rownum=Excel_Utilities.getRowcount(path, "Sheet1");
	       int colcount=Excel_Utilities.getCellcount(path, "Sheet1", 1);
	       
	       String logindata[][]=new String [rownum][colcount];
	       
	       for(int i=1;i<=rownum;i++) {//it is represent the rows
	           
	           for(int j=0;j<colcount;j++) {//it is represent the columns
	               logindata[i-1][j]=Excel_Utilities.getCelldata(path, "Sheet1", i, j);///1 0
	           }
	       }
	       return logindata;
	   }

}
