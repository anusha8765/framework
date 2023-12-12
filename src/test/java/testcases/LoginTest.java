package testcases;

import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class LoginTest extends Baseclass {
	@Test
	   public void logintest() throws InterruptedException {
	       
	       LoginPage lp=new LoginPage(driver);
	       lp.setUsername();
	       System.out.println("username is enetered");
	       Thread.sleep(2000);
	       lp.setPassword();
	       System.out.println("password is enetered");
	       Thread.sleep(2000);
	       lp.ClickLoginbtn();
	       System.out.println("user is succefully logging inito the account");
	   }
	}


