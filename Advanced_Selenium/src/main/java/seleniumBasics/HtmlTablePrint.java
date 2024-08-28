package seleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HtmlTablePrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver= new ChromeDriver();
	     driver.get("https://selenium.qabible.in/table-pagination.php");
	     driver.manage().window().maximize();
	     
	     System.out.println("---------------------------------------------------------");
	     List<WebElement> tableHeader5= driver.findElements(By.xpath("//table[@id='dtBasicExample']//thead//tr//th"));
	     for(int s=0;s<tableHeader5.size();s++)
	     {
	    	 System.out.print(tableHeader5.get(s).getText()+"          ");
	     }
	     System.out.println();
	     System.out.println("---------------------------------------------------------");
	     System.out.println();
	     List<WebElement> row= driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr//td[1]"));
	     System.out.println( "Row: "+row.size());//10 element
	     List<WebElement> column= driver.findElements(By.xpath("//table[@id='dtBasicExample']//tbody//tr[1]//td"));
	     System.out.println( "Colum: "+column.size());	//10 element
	     for(int k=0;k<row.size();k++)
	     { 
	      for(int v=0;v<column.size();v++) 
		    	{
	    	        String pathString ="//table[@id='dtBasicExample']//tbody//tr["+(k+1)+"]//td["+(v+1)+"]";
		    		WebElement element =driver.findElement(By.xpath(pathString));
	    	        System.out.print(element.getText()+"  ");
		    		//System.out.println("   ");
		    	}
	      System.out.println("   ");
	    
	     }
	}

}
