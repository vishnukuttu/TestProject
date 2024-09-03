package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	public static final long EXPLICIT_WAIT = 50;

	public void explicitWaitForWeElement(WebDriver driver, String text, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
	}

	public void explicitWaitForWebElementAlert(WebDriver driver, int duration)

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void fluentwaitForPresenceOfAllElementsattributeLocated(WebDriver driver, WebElement Webelement,
			String attribute, String value) {

		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.attributeToBe(Webelement, attribute, value));
	}

	public void fluentwaitForPresenceOfElementtext(WebDriver driver, WebElement element, String value) {

		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.textToBePresentInElement(element, value));
	}

	public void fluentwaitForPresenceOfElementsLocatedBy(WebDriver driver, WebElement Webelement) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) fluentWait).withTimeout(Duration.ofSeconds(EXPLICIT_WAIT));
		((FluentWait<WebDriver>) fluentWait).pollingEvery(Duration.ofSeconds(EXPLICIT_WAIT));
		((FluentWait<WebDriver>) fluentWait).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeSelected(Webelement));
	}
}
