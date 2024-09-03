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

	@Test(priority = 1, enabled= false)
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
	@Test(priority = 2, enabled= true)
	public void verifyTheSearchSubCategory() throws IOException, InterruptedException 
	{
		String userName = ExcelUtilities.getStringData(1, 0, "Sheet1");
		String passWord = ExcelUtilities.getStringData(1, 1, "Sheet1");
		lp = new LoginPage(driver);// Constructor calling in Loginpage
		mcp = new ManageCategoryPage(driver);// Constructor calling in MCP
		lp.sendUserName(userName);
		lp.sendPassword(passWord);
		lp.signIn();	
		mcp.clickSubCategory();
		String beginUrl= mcp.getURl(); 
		System.out.println("actual"+mcp.getURl());
		mcp.searchCategoryclick("cat1");
		mcp.subCategoryValue("fri");
		String actual="fri";
		System.out.println("actual"+actual);
		mcp.searchTheInputValues();
		mcp.subCategoryValue1();
		System.out.println("EXPECT"+mcp.subCategorywriteElementCheck());
	    Assert.assertEquals(actual,mcp.subCategorywriteElementCheck(),Constant.mcp_SearchCategorycreationtableFailure);    
	    System.out.println("expect"+mcp.resetUrl());	   
	    Assert.assertEquals(beginUrl,mcp.resetUrl(),Constant.mcp_ResetUrlFailure);
	}
	@Test(priority = 3,enabled =false)
	public void verifyTheDeleteSubCategory() throws IOException, InterruptedException 
	{
		String userName = ExcelUtilities.getStringData(1, 0, "Sheet1");
		String passWord = ExcelUtilities.getStringData(1, 1, "Sheet1");
		lp = new LoginPage(driver);// Constructor calling in Loginpage
		mcp = new ManageCategoryPage(driver);// Constructor calling in MCP
		lp.sendUserName(userName);
		lp.sendPassword(passWord);
		lp.signIn();	
		mcp.clickSubCategory();
		//String actual=mcp.fetchingTheFirstEntryinSubCategoryTable();
		System.out.println(mcp.fetchingTheFirstEntryinSubCategoryTable());
		mcp.VerifyDeletionInSubCategoryTable(mcp.fetchingTheFirstEntryinSubCategoryTable());
		
	}
	@Test(priority = 4,enabled =false)
	public void verifyTheEditSubCategory() throws IOException, InterruptedException 
	{
		String userName = ExcelUtilities.getStringData(1, 0, "Sheet1");
		String passWord = ExcelUtilities.getStringData(1, 1, "Sheet1");
		lp = new LoginPage(driver);// Constructor calling in Loginpage
		mcp = new ManageCategoryPage(driver);// Constructor calling in MCP
		lp.sendUserName(userName);
		lp.sendPassword(passWord);
		lp.signIn();	
		mcp.clickSubCategory();
		System.out.println(mcp.fetchingTheFirstEntryinSubCategoryTable()); 
		String actual=mcp.fetchingTheFirstEntryinSubCategoryTable()+"EditedApple";
		String expected= mcp.verifyEditInSubCategoryTable("EditedApple");
		Assert.assertEquals(actual,expected,Constant.mcp_EditCategorycreationtableFailure);
	}
}
