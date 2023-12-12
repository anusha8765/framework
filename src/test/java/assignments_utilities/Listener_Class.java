package assignments_utilities;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listener_Class implements ITestListener {
	   
	   public ExtentHtmlReporter reporter;//Add UI information
	   public ExtentReports extent;//common information about user
	   public ExtentTest logger;//add testcases entities
	   
	   public void onStart(ITestContext context) {
	       
	       //create time stamp
		   String timestamp=new SimpleDateFormat("yyyy.MM.dd.mm.ss").format(new Date());
	       //create report name
	       String repName="Test-Report" + timestamp + ".html";
	       //specify the location
	       reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/" + repName);
	    reporter.loadXMLConfig(System.getProperty("user.dir")+"/config.xml");
	    //provide basic information
	    extent =new ExtentReports();
	    extent.attachReporter(reporter);
	    extent.setSystemInfo("Hostname", "localhost");
	    extent.setSystemInfo("Environment", "QA");
	    extent.setSystemInfo("user", "Kiran");
	   
	    //provide the report information
	    reporter.config().setDocumentTitle("Fundraiser test project");
	    reporter.config().setReportName("Function test report");
	    reporter.config().setTestViewChartLocation(ChartLocation.TOP);
	    reporter.config().setTheme(Theme.DARK);
	   
	   
	   }
	   public void onTestSuccess(ITestResult tr) {
	       //create new entry
	       logger=extent.createTest(tr.getName());
	       logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	   }

	   public void onTestFailure(ITestResult tr) {
	       
	       logger=extent.createTest(tr.getName());
	       logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	       
	       String Screenshotpath=System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
	       File f=new File(Screenshotpath);
	       
	       if(f.exists()) {
	    	   try {
	    		   logger.fail("screenshot is below:"+logger.addScreenCaptureFromPath(Screenshotpath));
	    	   
	    	   }
	    	   catch(Exception e) {
	    		   e.printStackTrace();
	    	   }
	   }
}	       


	   public void onTestSkipped(ITestResult tr) {
	       
	       logger=extent.createTest(tr.getName());
	       logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	       
	   }

	   public void onFinish(ITestContext testcntext) {
	       
	       extent.flush();//clear you space
	   }
 

}