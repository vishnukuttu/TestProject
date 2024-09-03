package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtilities;
import utilities.GeneralUtilities;

public class LoginPage

{
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;// 9th line
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement userNameField;
	@FindBy(name = "password")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement errorMessage;

	public void sendUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void sendPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void signIn() {
		signInButton.click();
	}

	public String getErrorMessage() {
		return gu.getTextElement(errorMessage);
	}

}
