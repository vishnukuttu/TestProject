package elementRepository;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageCategoryPage {
	
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();
	String SubCategory,DeletedElement;

	public ManageCategoryPage(WebDriver driver) // Constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// PageFactory with POM@findbynotation we can declare element

	}

	@FindBy(xpath = "//a//p[text()='Sub Category']")
	WebElement subCategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement New;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement newCategory;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement newSubcategory;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement newChooseFile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement newSave;
	@FindBy(xpath = "//a//p[text()='Category']")
	WebElement categoryClick;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertNotifysuccess;
	@FindBy(xpath = "//table//tbody//tr//td")
	WebElement firstElementinTable;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchElementMain;
    @FindBy(id = "un")
    WebElement searchSelectCategory;
    @FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
    WebElement searchButtonElement;
    @FindBy(xpath="//input[@name='ut']")
    WebElement subCategorywriteElement;
    @FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")
    WebElement resultNotFoundElement;
    @FindBy(xpath="//tbody//tr//td[1]")
    WebElement ListSubCategoryTableCheck;
    @FindBy(xpath="//a[@class='btn btn-default btn-fix']")
    WebElement resetclick;
    @FindBy(xpath="//tbody//tr[1]//td[1]")
    WebElement FirstElementInSubCategoryTable;
    @FindBy(xpath="//a[@class='btn btn-sm btn btn-danger btncss']")
    WebElement Deleteclick;
    @FindBy(xpath="//tbody//tr[1]//td[5]//a[@class='btn btn-sm btn btn-primary btncss']//i[@class='fas fa-edit']")
    WebElement editClick;
    @FindBy(xpath="//input[@id='subcategory']")
    WebElement subCategoryTextEdit;
    @FindBy(xpath="//button[@name='update']")
    WebElement updateClick;
	public void waitforCategoryClick() {
		wu.fluentwaitForPresenceOfElementtext(driver, categoryClick, "Category");
	}

	public void categoryclick() {
		categoryClick.click();
	}

	public void clickSubCategory() {
		subCategory.click();
	}

	public String clicknew(String categoryname, String subCategoryName) {

		New.click();
		Select Category = new Select(newCategory);
		Category.selectByVisibleText(categoryname);
		String SubCategory = subCategoryName + gu.generateCurrentDateAndTime();
		this.SubCategory = SubCategory;
		newSubcategory.sendKeys(SubCategory);// why not taking dates??
		newSave.submit();
		return (alertNotifysuccess.getText());
	}

	public String getSubCategoryName() {
		return SubCategory;
	}

	public String fetchingTheFirstEntryinSubCategoryTable() {
		return (firstElementinTable.getText());
	}

	public String searchTable() {
		WebElement element = null;
		List<WebElement> rowCountElement = driver.findElements(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
		int count = (rowCountElement.size());
		System.out.println(count);// 20
		System.out.println(SubCategory);
		for (int i = 0; i < count; i++) // in list 1st element is zero, so 1 cannot be i
		{
			if (rowCountElement.get(i).getText().equals((SubCategory))) {
				// System.out.println("element: " + rowCountElement.get(i+1).getText());
				// System.out.println("entering loop");
				String locatorString = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + i + 1
						+ "]//td[2]";
				element = driver.findElement(By.xpath(locatorString));
				// System.out.println("Value: " + element.getText())
				break;
			}
		}
		return element.getText();
	}
   public void searchCategoryclick(String value) throws InterruptedException
   {
	   searchElementMain.click();
	   gu.selectDropdownbyText(searchSelectCategory,value);
	   Thread.sleep(100);
   }
   public void subCategoryValue(String subCategoryValue) {
	   subCategorywriteElement.sendKeys(subCategoryValue);
	   
	}
   public String subCategoryValue1()
   {
	   return subCategorywriteElement.getText();
   }
   public void searchTheInputValues()
   {
	   searchButtonElement.click();
   }
   public String subCategorywriteElementCheck()
   {
	  // System.out.println(ListSubCategoryTableCheck.getText());
	   return  ListSubCategoryTableCheck.getText();//fri
   }
   public String getURl()
   {
	   return driver.getCurrentUrl();
   }
   public String resetUrl()
   {
	   ///wait add
	   resetclick.click();
	   
	  // driver.getCurrentUrl();
	   return driver.getCurrentUrl();
   }
   
   
   public void VerifyDeletionInSubCategoryTable(String DeletedElement1)
   {
	   Deleteclick.click();
	   Alert alert =driver.switchTo().alert();
		alert.accept();
	   //WebElement element = null;
		List<WebElement> rowCountElement = driver.findElements(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
		int count = (rowCountElement.size());
		System.out.println(count);// 20
		System.out.println(DeletedElement1);
		for (int i = 0; i < count; i++) // in list 1st element is zero, so 1 cannot be i
		{
			if (rowCountElement.get(i).getText().equals((DeletedElement1))) 
				{
				System.out.println("Deletion not successfull");
				break;
			}
		   else 
		   {
			   System.out.println("Deletion successfull");		 
		   }
		}
   }
	public String verifyEditInSubCategoryTable(String editSubCategorytext)
	{
		editClick.click();
		subCategoryTextEdit.sendKeys(editSubCategorytext);
		updateClick.click();
		return firstElementinTable.getText();
	}
		
   
}
