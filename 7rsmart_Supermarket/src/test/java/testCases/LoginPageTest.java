package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelUtilities;

public class LoginPageTest extends BaseClass // we can acccessbaseclass
{
	LoginPage lp;// call the constructor, import the java class here
	HomePage hp;

	@Test
	public void verifyLoginWithValidData() {
		lp = new LoginPage(driver);//
		hp = new HomePage(driver);
		lp.sendUserName("admin");
		lp.sendPassword("admin");
		lp.signIn();
		String actual = hp.getDashboardText();
		String expected = "Dashboard";
		Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithValidData);
	}

	@Test(dataProvider = "loginDetails")
	public void verifyWithAllInvalidData(String userName, String passWord) {
		lp = new LoginPage(driver);
		lp.sendUserName(userName);
		lp.sendPassword(passWord);
		lp.signIn();
		String actual = lp.getErrorMessage();
		String expected = "Alert!1";
		Assert.assertEquals(actual, expected,Constant.lp_verifyLoginWithINValidData );
		// hard assertion,// Assert.softassertion-Code // will not terminate, it//
		// continue
	}

	@DataProvider // this dataprovider will give value to above dataprovider=logindetails
	public Object[][] loginDetails() { // 1 test case , if test data are many multiple data case
		return new Object[][] { { "admin12", "admin" }, { "0admin", "admin23" }, { "admin56", "admin23" } };
	}

	@Test
	public static void loginDatas() throws IOException {
		String data = ExcelUtilities.getStringData(1, 0, "Sheet1");
		String data1 = ExcelUtilities.getStringData(1, 1, "Sheet1");
		System.out.println(data + data1);
	}
}
