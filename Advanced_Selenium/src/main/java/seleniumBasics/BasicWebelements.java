package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicWebelements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    WebDriver driver=new ChromeDriver();
    driver.navigate().to("https://www.qabible.in/payrollapp/site/login"	);
    driver.manage().window().maximize();//locators in selenium:-class name, tag, id
    WebElement userName=driver.findElement(By.xpath("//input[@id='loginform-username']"));
    //----------//*[contains(@class, 'login')]
    
    userName.sendKeys("Good Morning");
    WebElement userName1=driver.findElement(By.id("loginform-password"));
    userName1.sendKeys("1234567");
    //userName.clear();//to clear the field(Here username is clear)
    WebElement login= driver.findElement(By.xpath("//button[text()='Login']"));
    login.click();
    String fontSize = login.getCssValue("font-size"); 
    System.out.println(fontSize);
    System.out.println();//sys+cntrl+space,syso+enter
    String color = login.getCssValue("color"); 
    System.out.println(color);
    String letterSpacing = login.getCssValue("letter-spacing"); 
    System.out.println(letterSpacing);//print the css
    String attributeType = login.getAttribute("class");
    System.out.println(attributeType); //print the attribute value of class	
    String attributeType1 = login.getAttribute("name");
    System.out.println(attributeType1);
    System.out.println();
    String loginTagName =login.getTagName();//print login button
    System.out.println(loginTagName);
    String userNameTagName =userName.getTagName();//print login button
    System.out.println(userNameTagName);
    
    String textPrint=login.getText();
    System.out.println(textPrint);//print text value
    
    
    
    
    
    
    //driver.quit();
	}

}
