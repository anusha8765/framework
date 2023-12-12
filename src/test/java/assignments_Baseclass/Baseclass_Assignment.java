/*package assignments_Baseclass;

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
		
	//	public ResourceBundle rb;

		@BeforeClass
		public void openApplication() {

			driver=new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
			driver.get(url);
			
			

		}

		@AfterClass
		public void closeApplication() {
			driver.close();
		}

}*/

// log file generation


/*package assignments_Baseclass;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import assignments_utilities.Readconfig;

	public class Baseclass_Assignment {

		public static WebDriver driver;
		
		public static Logger log;
		
		Readconfig rc=new Readconfig();
		
		public String url=rc.getApplicationURL();
		public String username=rc.getUsername();
		public String password=rc.getPassword();

		@BeforeClass
		public void openApplication() {

			driver=new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			log=Logger.getLogger(this.getClass());
			PropertyConfigurator.configure("./log4j.properties");
	
			driver.get(url);
			
			

		}

		@AfterClass
		public void closeApplication() {
			driver.close();
		}

}*/
	
// Parallel testing:

package assignments_Baseclass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
//import org.kohsuke.github.GHCommit.File;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import assignments_utilities.Readconfig;

	public class Baseclass_Assignment {

		public static WebDriver driver;
		
		public static Logger log;
		
		Readconfig rc=new Readconfig();
		
		public String url=rc.getApplicationURL();
		public String username=rc.getUsername();
		public String password=rc.getPassword();

		@BeforeClass
		@Parameters("browser")
		public void openApplication(String br) {
			
			if(br.equals("chrome")) {

			driver=new ChromeDriver();
			}
			else if(br.equals("edge")) {
	            driver=new EdgeDriver();
	        }
	        else if( br.equals("firefox")) {
	            driver=new FirefoxDriver();
	        }

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			log=Logger.getLogger(this.getClass());
			PropertyConfigurator.configure("./log4j.properties");
	
			driver.get(url);
			
			

		}

		/*@AfterClass
		public void closeApplication() {
			driver.close();
		}*/
		

		public void captureScreen(WebDriver driver,String name) throws IOException, InterruptedException {
			Thread.sleep(2000);
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File target=new File("./screenshots/"+name+".png");
			FileUtils.copyFile(src,target);
			log.info("screenshot is taken");
			
		}
}

