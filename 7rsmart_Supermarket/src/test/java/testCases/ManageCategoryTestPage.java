package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageCategoryPage;
import utilities.ExcelUtilities;

public class ManageCategoryTestPage extends BaseClass {
	
	LoginPage lp;
	ManageCategoryPage mcp;

	@Test(priority = 1)
	public void verifyToAddSubCategory() throws IOException, InterruptedException {
		String userName = ExcelUtilities.getStringData(1, 0, "Sheet1");
		String passWord = ExcelUtilities.getStringData(1, 1, "Sheet1");
		lp = new LoginPage(driver);// Constructor calling in Loginpage
		mcp = new ManageCategoryPage(driver);// Constructor calling in MCP
		lp.sendUserName(userName);
		lp.sendPassword(passWord);
		lp.signIn();
		mcp.waitforCategoryClick();
		mcp.categoryclick();
		mcp.clickSubCategory();
		// mcp.clicknew("Apple", "Apple15");

		String actual = mcp.clicknew("Apple", "Apple15");
		System.out.println(actual);
		String expected = Constant.mcp_verifyexpectedData;
		// "�\n"
		// + "Alert!\n"
		// + "Sub Category Created Successfully";
		Assert.assertEquals(actual, expected, Constant.mcp_verifySubCategoryisAlreadyExists);

		mcp.clickSubCategory();
		// System.out.println(mcp.fetchingTheFirstEntryinSubCategoryTable()+"pr2"+mcp.getSubCategoryName());
		Assert.assertEquals(mcp.fetchingTheFirstEntryinSubCategoryTable(), mcp.getSubCategoryName(),
				Constant.mcp_NewCategorycreationwasntsuccess);

		mcp.searchTable();
		System.out.println(mcp.searchTable());
		Assert.assertEquals(mcp.searchTable(), "Apple", Constant.mcp_NewCategorycreationtableFailure);

		// System.out.println(mcp.searchTable());
	}
	@Test(priority = 2)
	public void verifyTheSearchSubCategory() throws IOException 
	{
		String userName = ExcelUtilities.getStringData(1, 0, "Sheet1");
		String passWord = ExcelUtilities.getStringData(1, 1, "Sheet1");
		lp = new LoginPage(driver);// Constructor calling in Loginpage
		mcp = new ManageCategoryPage(driver);// Constructor calling in MCP
		lp.sendUserName(userName);
		lp.sendPassword(passWord);
		lp.signIn();	
		mcp.clickSubCategory();
		mcp.searchCategoryclick(2);
		//Assert.assertTrue(true, ;
	}

}
