package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage_Assignment {
	
	public static WebDriver rdriver;
	
	   public LoginPage_Assignment(WebDriver ldriver) {
	       
	       rdriver=ldriver;
	       PageFactory.initElements(ldriver, this);
	   }
	   
	   //locate the all webElements
	   
	   @FindBy(name="username")
	   WebElement txtusername;
	   
	   @FindBy(name="password")
	   WebElement txtpassword;
	   
	   @FindBy(xpath="//button[@type='submit']")
	   WebElement btnLogin;
	   
	   public void setUsername() {
	       txtusername.sendKeys("Admin");
	   }
	   public void setPassword() {
	       txtpassword.sendKeys("admin123");
	   }
	   public void ClickLoginbtn() {
	       btnLogin.click();
	   }

}
