package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public static WebDriver rdriver;
	
	   public LoginPage(WebDriver ldriver) {
	       
	       rdriver=ldriver;
	       PageFactory.initElements(ldriver, this);
	   }
	   
	   //locate the all webElements
	   
	   @FindBy(id="username")
	   WebElement txtusername;
	   
	   @FindBy(id="password")
	   WebElement txtpassword;
	   
	   @FindBy(id="login")
	   WebElement btnLogin;
	   
	   public void setUsername() {
	       txtusername.sendKeys("mahesh23456");
	   }
	   public void setPassword() {
	       txtpassword.sendKeys("India@123");
	   }
	   public void ClickLoginbtn() {
	       btnLogin.click();
	   }

}
