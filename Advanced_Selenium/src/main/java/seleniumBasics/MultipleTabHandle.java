package seleniumBasics;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleTabHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver= new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		String parentWindow = driver.getWindowHandle();// get window handle- UNique name/id
		System.out.println("parentWindow: "+parentWindow);
		

		
		WebElement multipletabElement= driver.findElement(By.id("tabButton"));
		multipletabElement.click();
		Set<String> allWindows = driver.getWindowHandles();//getwindows- to get unique ids,handles means hw many tabs openened check
		//(6C14F37B3F3AEA1D7553C352CC0FCEB9, 88B35049EC9A2C9530A813A242B922D1)
		for(String childWindow:allWindows)
		{
			if(!parentWindow.equals(childWindow))
					{
				driver.switchTo().window(childWindow);
				System.out.println("ChildWindow: "+childWindow); 
				
				WebElement childTabHeading= driver.findElement(By.id("sampleHeading"));
				System.out.println("Child Tab Headings: "+childTabHeading.getText());
					}
							
		}
		System.out.println("Back to Parent Window: "+driver.switchTo().window(parentWindow)); //back to parentwindow
		
		
	}

}
