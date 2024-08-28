package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardMouseAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       WebDriver driver = new ChromeDriver();
       
       driver.get("https://www.tutorialspoint.com/selenium/practice/buttons.php");
       driver.manage().window().maximize();
       
       WebElement clickMeElement= driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
       clickMeElement.click();
       
       //Action Class- Right click,doubleclick, mouse hover
       Actions obj= new Actions(driver);
       WebElement rightClickMe= driver.findElement(By.xpath("//button[@class='btn btn-secondary']"));
       //obj.doubleClick(rightClickMe).perform();
       obj.contextClick(rightClickMe).perform();
       
       WebElement doubleClickMe= driver.findElement(By.xpath("//button[text()='Double Click Me']"));
       obj.doubleClick(doubleClickMe).perform();
       obj.doubleClick(doubleClickMe).perform();
       obj.doubleClick(doubleClickMe).perform();
   
       
       //keyboard Events--it takes the 
       obj.sendKeys(Keys.ARROW_RIGHT).perform();
       obj.sendKeys(Keys.ARROW_RIGHT).perform();
       obj.sendKeys(Keys.ARROW_LEFT).perform();
       obj.sendKeys(Keys.ARROW_RIGHT).perform();
       obj.sendKeys(Keys.ARROW_RIGHT).perform();
       
       //Mouse Hover-- color change in click me
       WebElement mouseHover = driver.findElement(By.xpath("//button[text()='Click Me']"));
       obj.moveToElement(mouseHover).perform();
       
	}

}
