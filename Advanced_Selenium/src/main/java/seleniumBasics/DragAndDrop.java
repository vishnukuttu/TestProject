package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       WebDriver driver= new ChromeDriver();
       driver.get("https://selenium.qabible.in/drag-drop.php");
       driver.manage().window().maximize();
       
       //SourceElement Delaration
       WebElement sourceElement=driver.findElement(By.xpath("//span[text()='Draggable n°1'] "));
       
       //Terget Element
       WebElement targetElement=driver.findElement(By.id("mydropzone"));
       
       Actions actionObj = new Actions(driver);
       //Drag & Drop 
       actionObj.dragAndDrop(sourceElement, targetElement).perform();
       
       //-----------------
       //Drag 2 element
       WebElement sourceElement2=driver.findElement(By.xpath("//span[text()='Draggable n°2'] "));
       WebElement targetElement2=driver.findElement(By.id("mydropzone"));
       
       Actions actionObj2 = new Actions(driver);
       //Drag & Drop 
       actionObj2.dragAndDrop(sourceElement2, targetElement2).perform();
	}

}
