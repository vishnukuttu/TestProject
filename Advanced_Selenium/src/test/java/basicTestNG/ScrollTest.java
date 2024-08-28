package basicTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScrollTest {
  @Test
  public void scrollTestcase() 
  {
	  WebDriver driver = new ChromeDriver();
	  driver.navigate().to("https://www.amazon.in"); 
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// 5 sec wait for taking exception
	  
	  JavascriptExecutor js=(JavascriptExecutor) driver;//some of the clicks maynot work in normal case at that we use this
	    js.executeScript("window.scrollBy(0,2500)");  //use scroll,click,sendkeys  0-right 45000 for down..window(x,y)x= horizontal movement, Y==Vertical Movement
    
	    WebElement element =driver.findElement(By.xpath("//ul//li[2]//span[1]//a[@class='a-link-normal']//img[@data-a-hires='https://m.media-amazon.com/images/I/81h-X8sUsQL._AC_SY400_.jpg']"));
	    
	    
	    //js.executeScript(("arguments[0].click()", element));//for click
	    js.executeScript("arguments[0].click()", element);
  } 
  
	    public void sendValueUsingJavaScriptAndBlur(WebDriver driver, WebElement element, String value)
	    {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + value + "'", element);//" + value + "==vishnu
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].blur()", element);// blur used to hold for a nanosec
		}
  }

