package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ResourceBundle;

import assignments_utilities.Readconfig;

public class Baseclass_Assignment {

	public static WebDriver driver;
	
	Readconfig rc=new Readconfig();
	
	public String url=rc.getApplicationURL();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	
	public ResourceBundle rb;

	@BeforeClass
	public void openApplication() {

		driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	//	driver.manage().window().maximize();
		
		rb=ResourceBundle.getBundle("./config.properties");

	}

	@AfterClass
	public void closeApplication() {
		driver.close();
	}

}
