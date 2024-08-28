package seleniumBasics;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitSamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                 
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();
		//implicit wait-- through out the prgrm, when ever the exceptions occurs then wait for 5000 sec, if not load exceptions messages seen
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));//method overloading
		
		WebElement userName= driver.findElement(By.id("loginform-username"));
		//fluent wait-- for particular wait for the element, or specific
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(30))
	            .pollingEvery(Duration.ofSeconds(5))
	            .ignoring(NoSuchElementException.class);//wait for 30 sec, check for 5 secs then if the elemnet found stop at the 5sec, 
		                                                //it will not wait for 30 secs to complete, 
		                                                //once element found it will stop
		
		//fluentWait.until(ExpectedConditions.alertIsPresent());
		
		
		fluentWait.until(ExpectedConditions.attributeToBe(userName, "class", "form-control"));//class- form-control
	    userName.sendKeys("abc");
	    
	    //Explicit wait -- for particular wait for the element, or specific
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));// but here it will run upto 20 sec even if the element found before also
	    wait.until(ExpectedConditions.elementToBeClickable(userName));
	    
	}

}
