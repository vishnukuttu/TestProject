package seleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HtmlTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     WebDriver driver= new ChromeDriver();
     driver.get("https://selenium.qabible.in/table-pagination.php");
     driver.manage().window().maximize();
     //To print row /column
     
     List<WebElement> tableHeader= driver.findElements(By.xpath("//table[@id='dtBasicExample']//thead//tr//th"));
     
     for(int i=0;i<tableHeader.size();i++)
     {
    	 System.out.print(tableHeader.get(i).getText()+"   ");
     }
     System.out.println();
     //FindElement
     WebElement tableHeader1=driver.findElement(By.xpath("//table[@id='dtBasicExample']//thead//tr//th[1]"));
     System.out.println(tableHeader1.getText());
     
     //All Row Element Print
     List<WebElement> rowElements= driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr[1]//td"));
     for(int j=0;j<rowElements.size();j++)
     {
    	 System.out.print(rowElements.get(j).getText()+" ");
    	 
     }
     System.out.println();
     //All ColomnElement Print
     List<WebElement> colomnElements= driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr//td[1]"));
     for(int y=0;y<colomnElements.size();y++)
     {
    	 System.out.println(colomnElements.get(y).getText()+"");
     }
     System.out.println();
     //SingleElement trip
     WebElement singleElement=driver.findElement(By.xpath("//table[@id='dtBasicExample']//tbody//tr[1]//td[1]"));
     System.out.println(singleElement.getText());
     
     System.out.println();
     //Table Print
     System.out.println("---------------------------------------------------------");
     List<WebElement> tableHeader5= driver.findElements(By.xpath("//table[@id='dtBasicExample']//thead//tr//th"));
     for(int s=0;s<tableHeader5.size();s++)
     {
    	 System.out.print(tableHeader5.get(s).getText()+"          ");
     }
     System.out.println("---------------------------------------------------------");
     System.out.println();
     List<WebElement> allElements= driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr//td"));
     System.out.println( allElements.size());//60 element
     List<WebElement> allElements2= driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr"));
     System.out.println( allElements2.size());	//10 element
     for(int k=0;k<allElements.size();k++)
     { 
      for(int v=0;v<allElements2.size();v++) 
	    	{
	    		System.out.println( allElements2.get(v).getText());
	    		System.out.println("   ");
	    	}
    	System.out.println("---------------------------------------------------------");
    	//
    	break;
     }
	}

}
