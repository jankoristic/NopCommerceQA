package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;
import utilities.Screenshot;

public class BaseClass {

	public WebDriver driver;
	public ReadConfig read = new ReadConfig();
	public Screenshot screenshot = new Screenshot();
	public static Logger log;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	public File file;
	SoftAssert softassert;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws IOException {
		log = LogManager.getLogger(BaseClass.class.getName());
		softassert = new SoftAssert();
		
		extent = new ExtentReports();
		file = new File("report.html");
		spark = new ExtentSparkReporter(file);
		spark.loadJSONConfig(new File("./src/test/resources/extent-reports-config.json"));
		extent.attachReporter(spark);

		
		if(br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", read.getChromePath());
			this.driver = new ChromeDriver();
		}
		
		if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", read.getFirefoxPath());
			this.driver = new FirefoxDriver();
		}
		
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
	}
	
	@AfterClass
	public void tearDown() {
		extent.flush();
		driver.quit();
		softassert.assertAll();
	}
}
