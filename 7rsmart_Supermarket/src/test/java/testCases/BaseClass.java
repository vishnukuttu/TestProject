package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenShotCapture;

public class BaseClass {

	WebDriver driver;
	ScreenShotCapture sc;
	public static Properties pro;// Properties class-lib file

	public static void testBasics() throws IOException {
		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\Config.properties");
		// user.dir(C:\\Users\\vishn\\eclipse-workspace\\7rsmart_Supermarket)
		// will copy
		// the
		// projectpath,
		// then we
		// will give
		// path of
		// the
		// config
		// files
		pro.load(fp);
	}

	@BeforeMethod(alwaysRun = true) // not to skip
	@Parameters("Browser")
	public void beforeMethod(String browserName) throws IOException {
		testBasics();
		if (browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("FireFox")) {
			driver = new FirefoxDriver();
		}
		// driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(pro.getProperty("baseURL"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
		
		
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) throws IOException //ItestrResult is a listenere class who always listen
	{
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());//getName is test name/method name, ie @testname
		}
		driver.quit();//driver.quit makes connection errors
	}
}
