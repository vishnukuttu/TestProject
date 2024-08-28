package seleniumBasics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver= new ChromeDriver();
		driver.get("https://selenium.qabible.in/javascript-alert.php");
		driver.manage().window().maximize();
		
		WebElement alertButton= driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		alertButton.click();
		//driver.switchTo().alert().accept();//alert 
		Alert alert =driver.switchTo().alert();//switchzTo to method is used to handle Alert
		System.out.println("Text:- "+ alert.getText());
		Thread.sleep(1000); //wait, mqking delay
		alert.accept();
		
		WebElement alertButton2= driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
		alertButton2.click();
		//driver.switchTo().alert().accept();//alert
		//Alert alert2 =driver.switchTo().alert();
		//System.out.println("Text:- "+ alert2.getText());
		//Thread.sleep(1000); //wait
		alert.dismiss();
		
		WebElement alertButton3= driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		alertButton3.click();
		alert.sendKeys("Vishnu");
		Thread.sleep(1000);
		alert.accept();
		
		
		
	}

}
