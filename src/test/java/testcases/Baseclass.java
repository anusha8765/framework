package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseclass {
	public static WebDriver driver;
	   
	   @BeforeClass
	   public void openApplication() {
	       
	       driver=new ChromeDriver();
	       driver.get("https://adactinhotelapp.com/");
	       
	   }
	   
	   @AfterClass
	   public void closeApplication() {
	       driver.close();
	   }
	   


}
