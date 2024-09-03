package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtilities;

public class LoginPageTest extends BaseClass 
{
	LoginPage lp;
	HomePage hp;

	@Test
	public void verifyLoginWithValidData() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.sendUserName("admin");
		lp.sendPassword("admin");
		lp.signIn();
		String actual = hp.getDashboardText();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithValidData);
	}

	@Test(dataProvider = "loginDetails")//multiple test data provide
	public void verifyWithAllInvalidData(String userName, String passWord) {
		lp = new LoginPage(driver);
		lp.sendUserName(userName);
		lp.sendPassword(passWord);
		lp.signIn();
		String actual = lp.getErrorMessage();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithINValidData);
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals(actual,expected,"Title is not Matching"); 
	}

	@DataProvider
	public Object[][] loginDetails() {
		return new Object[][] { { "admin12", "admin" }, { "0admin", "admin23" }, { "admin56", "admin23" } };
	}

	@Test
	public void loginDatas() throws IOException {
		String data = ExcelUtilities.getStringData(1, 0, "Sheet1");
		String data1 = ExcelUtilities.getStringData(1, 1, "Sheet1");
		lp = new LoginPage(driver);//
		hp = new HomePage(driver);
		lp.sendUserName(data);
		lp.sendPassword(data1);
		lp.signIn();
		String actual = hp.getDashboardText();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithValidData);
	}
}
