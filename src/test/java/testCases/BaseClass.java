package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;
import utilities.Screenshot;

public class BaseClass {

	public static WebDriver driver;
	public static ReadConfig read = new ReadConfig();
	public static Screenshot screenshot = new Screenshot();
	public static String screenshotSubFolderName;
	public static Logger log;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static File file;
	public static SoftAssert softassert;
	public static ChromeOptions options;
	
	@BeforeSuite
	public void initialiseExtentreports() throws IOException {
		file = new File("report.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		spark.loadJSONConfig(new File("./src/test/resources/extent-reports-config.json"));
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		log = LogManager.getLogger(BaseClass.class.getName());
		softassert = new SoftAssert();
	}
	
	@Parameters("browser")
	@BeforeTest
	public void setup(ITestContext context, String br) throws Exception {
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", read.getChromePath());
			WebDriverManager.chromedriver().setup();
			options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}
		
		if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", read.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
		
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		String device = capabilities.getBrowserName() + " " + capabilities.getBrowserVersion().substring(0, capabilities.getBrowserVersion().indexOf("."));
		String author = context.getCurrentXmlTest().getParameter("author");
		
		test = extent.createTest(context.getName());
		test.assignAuthor(author);
		test.assignDevice(device);
		
	}
	
	@AfterMethod
	public void check(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			log.info(result.getMethod().getMethodName() + " test failed");
			test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshot.captureScreenshot(driver, "screenshot.png")).build());
			
		} else if (result.getStatus() == ITestResult.SUCCESS){
			log.info(result.getMethod().getMethodName() + " test passed");
			test.pass(result.getMethod().getMethodName() + " test passed");
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		softassert.assertAll();
	}
	
	@AfterSuite
	public void generateExtentReports() {
		extent.flush();
	}
}
