package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
	    driver.navigate().to("https://selenium.qabible.in/check-box-demo.php"	);
	    driver.manage().window().maximize();
	    WebElement checkBoxElement= driver.findElement(By.id("gridCheck"));
	    checkBoxElement.click();
	    
	    boolean checkBoxVisibilty= checkBoxElement.isEnabled();
	    System.out.println("Element Visibilty:- "+ checkBoxVisibilty);
	    
	    checkBoxElement.click();
	    boolean checkBoxDisabled= checkBoxElement.isSelected();// 
	    System.out.println("Repated Check:- "+ checkBoxDisabled);
	    //System.out.println("Repeated Check"+ checkBoxElement.isSelected();
	    
	    WebElement checkBoxOneElement1= driver.findElement(By.id("check-box-one"));
	    checkBoxOneElement1.click();
	    boolean checkBoxOneEnabled= checkBoxOneElement1.isEnabled();
	    System.out.println("Element Visibilty:- "+ checkBoxOneEnabled);
	    
	    WebElement selectAll = driver.findElement(By.xpath("//input[@id='button-two']"));
	    boolean checkBoxOneEnabled1=selectAll.isEnabled();
	    System.out.println("Element Visibilty:- "+checkBoxOneEnabled1 );
	    WebElement selectAll1 = driver.findElement(By.xpath("//input[@id='button-two']"));
	    boolean checkBoxOneEnabled4=selectAll1.isSelected(); //is selected used in radio button checks
	    System.out.println("Element Visibilty:- "+checkBoxOneEnabled4 );
	}

}
