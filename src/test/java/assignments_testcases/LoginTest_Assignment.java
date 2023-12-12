/*package assignments_testcases;

import org.testng.annotations.Test;

import assignments_utilities.Readconfig;
import assignments_pageobjects.LoginPage_Assignment;
import assignments_Baseclass.Baseclass_Assignment;



public class LoginTest_Assignment extends Baseclass_Assignment {

	@Test
	public void logintest() throws InterruptedException {

		LoginPage_Assignment lp=new LoginPage_Assignment(driver);
		lp.setUsername(username);
		System.out.println("username is enetered");
		Thread.sleep(2000);
		lp.setPassword(password);
		System.out.println("password is enetered");
		Thread.sleep(2000);
		lp.ClickLoginbtn();
		System.out.println("user is succefully logging into the account");
	}

}*/

// log file generation

/*package assignments_testcases;

import org.testng.annotations.Test;
import assignments_pageobjects.LoginPage_Assignment;
import assignments_Baseclass.Baseclass_Assignment;



public class LoginTest_Assignment extends Baseclass_Assignment {

	@Test
	public void logintest() throws InterruptedException {

		LoginPage_Assignment lp=new LoginPage_Assignment(driver);
		lp.setUsername(username);
		log.info("username is enetered");
		Thread.sleep(2000);
		lp.setPassword(password);
		log.info("password is enetered");
		Thread.sleep(2000);
		lp.ClickLoginbtn();
		log.info("user is succefully logging into the account");
		
		String exp_result="OrangeHRM1";
	    String act_result=driver.getTitle();
	   
	    if(act_result.equals(exp_result)) {
	        log.info("testcase is pass");
	    }
	    else {
	        log.info("testcase is failed");
	    }
	   
	   
	    }
	}*/

package assignments_testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import assignments_pageobjects.LoginPage_Assignment;
import assignments_Baseclass.Baseclass_Assignment;



public class LoginTest_Assignment extends Baseclass_Assignment {

	@Test
	public void logintest() throws InterruptedException, IOException {

		LoginPage_Assignment lp=new LoginPage_Assignment(driver);
		lp.setUsername(username);
		log.info("username is enetered");
		Thread.sleep(2000);
		lp.setPassword(password);
		log.info("password is enetered");
		Thread.sleep(2000);
		lp.ClickLoginbtn();
		log.info("user is succefully logging into the account");
		
		String exp_result="OrangeHRM";
	    String act_result=driver.getTitle();
	   
	    if(act_result.equals(exp_result)) {
	    	Assert.assertTrue(true);
	        log.info("testcase is pass");
	    }
	    else {
	    	//captureScreen(driver,"logintest");
	    	
	    	Assert.assertTrue(false);
	    	
	    	
	        log.info("testcase is failed");
	    }
	   
	   
	    }
	}