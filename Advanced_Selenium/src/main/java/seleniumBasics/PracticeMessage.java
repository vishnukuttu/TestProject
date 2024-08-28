package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();
		
		WebElement typeBoxElement= driver.findElement(By.id("single-input-field"));
		typeBoxElement.sendKeys("Hi All GOOD MORNING");
		
		WebElement click1= driver.findElement(By.xpath("//button[text()='Show Message']"));
		click1.click();
		
		WebElement printMessage= driver.findElement(By.id("message-one"));
		String message = printMessage.getText();
		System.out.println("Print The Message:- "+ message);
		
		WebElement typeBoxElement2= driver.findElement(By.xpath("//input[@id='value-a']"));
		typeBoxElement2.sendKeys("100");
		
		WebElement typeBoxElement3= driver.findElement(By.xpath("//input[@id='value-b']"));
		typeBoxElement3.sendKeys("200");
		
		WebElement click2= driver.findElement(By.xpath("//button[text()='Get Total']"));
		click2.click();
		
		WebElement printMessage2= driver.findElement(By.id("message-two"));
		String message1 = printMessage2.getText();
		System.out.println("Print Total: "+ message1);
		
	}

}
