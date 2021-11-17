package com.nik.test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.nik.pages.LoginPage;

public class Web_Automation {
		WebDriver driver;
		ExtentReports extent;
		String driverPath=System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
		String reportPath=System.getProperty("user.dir")+"\\ExtentReport\\index.html";
		
		@BeforeTest
		public void setUp() {
		ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Data Paramaterisation using Excel Spreadsheet");
		reporter.config().setDocumentTitle("Automation Test Results");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Nikunj Thakur");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		@Test
		public void login() throws Exception {
		ExtentTest test=extent.createTest("login");
		LoginPage lp=new LoginPage(driver);
		driver.get("https://www.stealmylogin.com/demo.html");
		Utils utility=new Utils();
		lp.getUsername().sendKeys(utility.getValeFromExcel(1, 1));
		lp.getPassword().sendKeys(utility.getValeFromExcel(1, 2));
		String screenshotPath = utility.getScreenshot(driver, "login");
		test.addScreenCaptureFromPath(screenshotPath);
		lp.loginButton().click();
		Thread.sleep(2000);	
		String screenshotPath2 = utility.getScreenshot(driver, "login");
		test.addScreenCaptureFromPath(screenshotPath2);
	}
		
		@AfterTest
		public void tearDown() {
			driver.manage().deleteAllCookies();
			driver.quit();	
			extent.flush();
		}

}

