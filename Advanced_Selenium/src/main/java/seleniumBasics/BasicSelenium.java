package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
     System.setProperty("webdriver.chrome.driver","C:\\Users\\vishn\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
     //this System.property is used for 4.5 selenium versions..so chrome driver is set using this property
     WebDriver driver =new ChromeDriver(); //CNTRL+shift+O - webdriver- interface(Collection of api)(all drivers can be used like firefox,chrome, edge),driver- ref variable, to connect to webpage of chrome
     //ChromeDriver driver = new ChromeDriver();// we can use this also..this can be used in chrome only, chrome driver instance created
     //System.setProperty("webdriver.edge.driver","path\\msedgedriver.exe");
     //WebDriver driver = new EdgeDriver();  //its for Edge microsoft
     //Selenium adv,dis, componenets
     //driver.get("https://mail.google.com/mail/u/0/#inbox"); //browser launched, with driver, normaly used..delay in loading, history not keep. needs to wait till the load page
     driver.navigate().to("https://mail.google.com/mail/u/0/#inbox"); //browser launched, with driver..no delay, still not wait for page loading fully, history keep, backward, refresh is done 
     driver.navigate().to("https://www.facebook.com/login/?next=https%3A%2F%2Fwww.facebook.com%2F"); 
     String title= driver.getTitle();//getTitle is the prev title() will launch
     System.out.println(title);
     String url=driver.getCurrentUrl();//console we can see the link
     System.out.println(url);
     
     driver.manage().window().maximize();//browser maximise
     driver.manage().window().minimize();//To minimize the browser
     driver.manage().window().maximize();
     
     String src = driver.getPageSource();//sourcecode....right click inspect element....this is source code in console
     System.out.println(src);
     
     driver.navigate().back(); //if backward done we can see it will move to previous page because it will store history
     driver.navigate().refresh();//page fully reload
     //driver.navigate().forward();
     driver.quit(); //launched browser will automaticaly off if multiple tab then it will quit all tab
     driver.close();//launched browser will automaticaly off if multiple tab then only current tab get closed rest will be ther
	}

}
