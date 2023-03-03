package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot{
	
	public String captureScreenshot(WebDriver driver, String fileName){
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/" + fileName);
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return destFile.getAbsolutePath();
	}
	
	public String captureScreenshot(WebDriver driver){
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		String base64code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		
		return base64code;
	}
}
