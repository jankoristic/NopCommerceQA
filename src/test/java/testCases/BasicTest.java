package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pageObjects.HomePage;

public class BasicTest extends BaseClass{
	@Test
	public void basic() throws IOException {
		
//		test = extent.createTest("Basic test");
		
		driver.get(read.getURL());
		HomePage hp = new HomePage(driver);
		
		hp.clickDesktops();
		log.info("Clicked Desktops");
		test.log(Status.INFO, "Clicked Desktops");
		test.pass("Basic test passed", MediaEntityBuilder.createScreenCaptureFromPath(screenshot.captureScreenshot(driver, "screenshot.png")).build());

//		test.pass("Basic test passed");
//		test.addScreenCaptureFromPath(screenshot.captureScreenshot(driver, "screenshot.png"));
		
	}
}
