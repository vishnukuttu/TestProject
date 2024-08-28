package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		WebDriver driver= new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		//switch by names or id in iframe
		//driver.switchTo().frame("frame1") ;// step 1 switch to frame
		
		WebElement iframeElement= driver.findElement(By.id("frame1"));// switch by webelement
		driver.switchTo().frame(iframeElement);
		
		
		WebElement frameText= driver.findElement(By.xpath("//h1[@id='sampleHeading']"));	
		System.out.println(frameText.getText());// step 2 action whats there inside frame
		driver.switchTo().parentFrame();//step3 switch to default parent
		//driver.switchTo().defaultContent();//switch to default parent
		
		
	}

}
