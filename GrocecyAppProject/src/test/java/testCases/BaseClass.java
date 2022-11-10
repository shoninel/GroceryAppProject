package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotCapture;

public class BaseClass {

	WebDriver driver;

	ScreenshotCapture scr;
	public static Properties ps;

	public static void testBasic() throws IOException {
		ps = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//Properties//Config.Properties");
		ps.load(file);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")

	public void beforeMethod(String browserName) throws IOException {
		/*
		 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		 * + "//src//main//resources//DriverFiles//chromedriver.exe"); driver = new
		 * ChromeDriver();
		 */
		testBasic();
		if (browserName.equals("Chrome")) {
			System.setProperty(ps.getProperty("ChromeDriver"),
					System.getProperty("user.dir") + ps.getProperty("ChromeDriverPath"));

			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			System.setProperty(ps.getProperty("FireFoxDriver"),
					System.getProperty("user.dir") + ps.getProperty("FireFoxDriverPath"));
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {

			System.setProperty(ps.getProperty("edgeDriver"),
					System.getProperty("user.dir") + ps.getProperty("edgeDriverPath"));
			driver = new EdgeDriver();

		}

		driver.get(ps.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itestResult) throws IOException {
		if (itestResult.getStatus() == ITestResult.FAILURE) {
			scr = new ScreenshotCapture();
			scr.captureScreenshot(driver, itestResult.getName());
		}
		driver.close();
	}

}
