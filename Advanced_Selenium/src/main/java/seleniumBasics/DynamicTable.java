package seleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    WebDriver driver = new ChromeDriver();
    driver.get("https://selenium.qabible.in/table-pagination.php");
    driver.manage().window().maximize();
    
    //Dynamic Table
    List<WebElement> table= driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr//td[1]"));
    WebElement element;
    for(int i=0;i<table.size();i++)//if i=1;i<=table.size
    {
    	if(table.get(i).getText().equals("Colleen Hurst"))
    	{
    		String locators="//table[@id='dtBasicExample']//tbody//tr["+(i+1)+"]//td[4]";//no need i+1 if i above is taken as 1
    	    element=driver.findElement(By.xpath(locators));
    	    System.out.println("AGE: "+element.getText());
    	    break;
    	}
    }    
	}

}
