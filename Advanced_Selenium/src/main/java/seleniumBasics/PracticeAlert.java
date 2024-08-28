package seleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
    WebDriver driver =new ChromeDriver();
    driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
    driver.manage().window().maximize();
    
    WebElement alertButton= driver.findElement(By.xpath("//button[@onclick='myPromp()']"));
    alertButton.click();
    Alert alert= driver.switchTo().alert();
    alert.sendKeys("Good Morning");
    Thread.sleep(1000);
    alert.accept();
	}

}
