package assignments_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	   
	   public Readconfig() {
	       //configurate the properties file ./ project home directory
	       File f=new File("./config.properties");
	       
	       try {
	           FileInputStream fis=new FileInputStream(f);//convert file data into reading mode
	           pro=new Properties();
	           pro.load(fis);
	       }catch(Exception e) {
	           System.out.println(e.getMessage());
	       }
	   }
	   
	   //associated methods
	   public String getApplicationURL() {
	       String url=pro.getProperty("baseURL");
	       return url;
	   }
	   public String getUsername() {
	       String user=pro.getProperty("username");
	       return user;
	   }
	   
	   public String getPassword() {
	       String pass=pro.getProperty("password");
	       return pass;
	   }

}
