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
	String SubCategory;

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
    @FindBy(xpath="form-control selectpicker")
    WebElement searchSelectCategory;
    @FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
    WebElement searchButtonElement;
    @FindBy(xpath="//input[@name='ut']")
    WebElement subCategorywriteElement;
    @FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")
    WebElement resultNotFoundElement;
    
    
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
   public void searchCategoryclick(int a)
   {
	   searchElementMain.click();
	   gu.selectIndexFromDropDown(searchSelectCategory,a);
	   searchButtonElement.click();
	   subCategorywriteElement.getText();
	   
   }
}
