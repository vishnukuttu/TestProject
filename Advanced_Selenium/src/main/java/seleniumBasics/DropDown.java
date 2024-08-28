package seleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();//CNTRL+SHIFT+O
		driver.get("https://selenium.qabible.in/select-input.php");
		driver.manage().window().maximize();
		
		WebElement dropDownElement = driver.findElement(By.id("single-input-field"));
		Select obj =new Select(dropDownElement); 
		obj.selectByIndex(0);//index 0-select, 1-red, 2-yellow, 3 -green
		obj.selectByVisibleText("Red");
		obj.selectByValue("Green");
		
		WebElement selectedElement1= obj.getFirstSelectedOption();// currently what option selected, b4 we can see green
		String selectedElementBy = selectedElement1.getText();
		System.out.println("print=:-"+selectedElementBy);
		
		WebElement multiDropDown=driver.findElement(By.id("multi-select-field"));
		Select multiObj= new Select(multiDropDown);
		for(int i=0;i<3;i++)
		{
			multiObj.selectByIndex(i);
		}
		
		//print the text values
		List <WebElement> list1= multiObj.getAllSelectedOptions();
		for(int j=0;j<list1.size();j++)
		{
			//String options=list1.get(j).getText());
			System.out.println("PRINT ALL:-"+list1.get(j).getText());
		}	
	}
}
