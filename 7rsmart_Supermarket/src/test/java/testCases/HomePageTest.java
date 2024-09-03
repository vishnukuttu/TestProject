package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomePageTest extends BaseClass {
	LoginPage lp;//call the constructor, import the java class here
	HomePage hp;
  @Test
  public void verifyAllButton() {
	  
	  hp=new HomePage(driver);
	  lp=new LoginPage(driver);
	  lp.sendUserName("admin"); 
	  lp.sendPassword("admin");
	  lp.signIn();
	  //boolean actualProduct=hp.enabledProduct();
	  //Assert.assertEquals(actualProduct, true, "Verified");
	  Assert.assertEquals(hp.enabledProduct(), true, "Verified");
	  //isselected,isenabled
	  String expected = hp.getgiftVoucherstext();
	  String actual="Manage Gift cards &vouchers";
	  Assert.assertEquals(actual,expected,"Manage Gift cards &vouchers not matching with dashboard");
  }
}
