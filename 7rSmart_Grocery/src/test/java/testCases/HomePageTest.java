package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomePageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
  @Test
  public void verifyAllButton() {
	  
	  hp=new HomePage(driver);
	  lp=new LoginPage(driver);
	  lp.sendUserName("admin"); 
	  lp.sendPassword("admin");
	  lp.signIn();
	  Assert.assertEquals(hp.enabledProduct(), true, "Verified");
	  String expected = hp.getgiftVoucherstext();
	  String actual="Manage Gift cards &vouchers";
	  Assert.assertEquals(actual,expected,Constant.hp_verifyDashboard);
  }
}
