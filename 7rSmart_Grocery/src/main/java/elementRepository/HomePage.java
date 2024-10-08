package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;// 9th line
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//a//p[text()='Manage Product']")
	WebElement manageProduct;
	@FindBy(xpath = "//a//p[text()='Manage Gift cards &vouchers']")
	WebElement giftVouchers;

	public String getDashboardText() {
		String dashboardtext = dashboard.getText();
		return dashboardtext;
	}

	public boolean enabledProduct() {
		return (manageProduct.isEnabled());
	}

	public String getgiftVoucherstext() {
		giftVouchers.isEnabled();
		return giftVouchers.getText();

	}
}
