package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HtmlTableDirectPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver= new ChromeDriver();
	     driver.get("https://selenium.qabible.in/table-pagination.php");
	     driver.manage().window().maximize();
	     
	     WebElement table =driver.findElement(By.xpath("//table[@id='dtBasicExample']"));
	     System.out.println(""+table.getText());
	     
	     WebElement div2 =driver.findElement(By.xpath("//ul[@class='pagination']//li[3]"));
	     div2.click();
	     WebElement table1 =driver.findElement(By.xpath("//table[@id='dtBasicExample']"));
	     System.out.println(""+table1.getText());
	     
	     WebElement div3 =driver.findElement(By.xpath("//ul[@class='pagination']//li[3]"));
	     div3.click();
	     WebElement table2 =driver.findElement(By.xpath("//table[@id='dtBasicExample']"));
	     System.out.println(""+table2.getText());
	     
	}

}
