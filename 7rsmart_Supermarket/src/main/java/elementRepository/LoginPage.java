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
//webelement & functions used
{
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public LoginPage(WebDriver driver) // Constructor
	{
		this.driver = driver;// 9th line
		PageFactory.initElements(driver, this); // PageFactory with POM@findbynotation we can declare element
	}
	
	@FindBy(name = "username") // with page factory
	WebElement userNameField;// Pagefactory- design pattern
	@FindBy(name = "password") // @Findby== webelement locate cheyan
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement errorMessage;
	
	public void sendUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	// By passwordField=By.name("password");//without pagefactory
	public void sendPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void signIn() {
		signInButton.click();
	}

//public String getErrorMessage()
//{
//	return (errorMessage.getText());
//}
	public String getErrorMessage() {
		return gu.getTextElement(errorMessage);
	}

}
