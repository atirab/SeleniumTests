package base;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.Constants;
public class BaseTest {

	public ExtentSparkReporter spark;
	public ExtentReports extent; //location of report
	public ExtentTest logger;//content of report
	public static WebDriver driver;
	@BeforeTest
	public void startReport() {

		// Create an object of Extent Reports
		extent = new ExtentReports();

		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "reports"+ "TestExtentReport.html");
		extent.attachReporter(spark);
		extent.setSystemInfo("HostName", "LAPTOP-CS5SNTU8");
		extent.setSystemInfo("UserName", "AB");
		spark.config().setDocumentTitle("Automation Report");
		// Name of the report
		spark.config().setReportName("Test Results");
		// Dark Theme
		spark.config().setTheme(Theme.DARK);
	}
	@BeforeMethod

	public void beforeMethodMethod(Method testMethod) {
		logger = extent.createTest(testMethod.getName());
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Owner//Desktop//Geek Squad Data Transfer//eclipse//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Constants.url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}

	@AfterMethod

	public void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, result.getThrowable());
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, result.getName());
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, result.getName());
		}
	}
	@AfterTest
	public void afterTest(){
		extent.flush();
	}
}



