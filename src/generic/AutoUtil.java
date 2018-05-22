package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class AutoUtil {

	public static String getProperty(String path,String Key)

	{
		String value="";
		Properties p=new Properties();
		try {
			p.load(new FileInputStream(path));
			value=p.getProperty(Key);


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;

	}


	public static void getScreenshot(WebDriver driver, String folder, String testName)
	{
		Date d=new Date();
		String sdate=d.toString();
		String datetime=sdate.replaceAll(":", "_");
		String path=folder+testName+datetime+".png";
		TakesScreenshot t=(TakesScreenshot)driver;
		File srcfile = t.getScreenshotAs(OutputType.FILE);
		File destfile=new File(path);
		FileUtils.copyFile(srcfile, destfile);
		


	}



}


}


