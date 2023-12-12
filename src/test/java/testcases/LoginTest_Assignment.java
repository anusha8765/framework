package testcases;

import org.testng.annotations.Test;

//import pageobjects.LoginPage;
import pageobjects.LoginPage_Assignment;

public class LoginTest_Assignment extends Baseclass_Assignment {

	@Test
	public void logintest() throws InterruptedException {

		LoginPage_Assignment lp=new LoginPage_Assignment(driver);
		lp.setUsername();
		System.out.println("username is enetered");
		Thread.sleep(2000);
		lp.setPassword();
		System.out.println("password is enetered");
		Thread.sleep(2000);
		lp.ClickLoginbtn();
		System.out.println("user is succefully logging into the account");
	}

}
