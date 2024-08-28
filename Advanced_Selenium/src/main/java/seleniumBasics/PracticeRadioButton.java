package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeRadioButton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://selenium.qabible.in/radio-button-demo.php");
		driver.manage().window().maximize();
		
		WebElement radioBoxElement =driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		boolean checkRadio= radioBoxElement.isEnabled(); 
		boolean checkRadio1= radioBoxElement.isSelected();
		boolean checkRadio2= radioBoxElement.isDisplayed();
		System.out.println(checkRadio);
		System.out.println(checkRadio1);
		System.out.println(checkRadio2);
		
		System.out.println();
		
		//checking with class, if id is not there how take the path
		WebElement radioBoxElement2 = driver.findElement(By.xpath("\r\n"
				+ "//div[@class='col-lg-9 col-md-9 col-sm-12 col-xs-12']//div[1]//div//div[2]//form//div[@class='form-group']//div[2]//input[@class='form-check-input']\r\n"
				+ ""));
		boolean checkRadio4= radioBoxElement2.isEnabled(); 
		boolean checkRadio5= radioBoxElement2.isSelected();
		boolean checkRadio6= radioBoxElement2.isDisplayed();
		System.out.println("isEnabled:- "+checkRadio4);
		System.out.println("isSelected:- "+checkRadio5);
		System.out.println("isDisplayed:- "+checkRadio6);
		
		System.out.println();
		
		radioBoxElement2.click();
		
		boolean checkRadio7= radioBoxElement2.isEnabled(); //When false, user can’t interact with the control in any way and the control is greyed out. 
		boolean checkRadio8= radioBoxElement2.isSelected();
		boolean checkRadio9= radioBoxElement2.isDisplayed();//once the button functioning its true
		System.out.println("isEnabled:- "+checkRadio7);
		System.out.println("isSelected:- "+checkRadio8);
		System.out.println("isDisplayed:- "+checkRadio9);
		
	}

}
