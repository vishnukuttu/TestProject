package utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getTextElement(WebElement element) {
		return element.getText();
	}

	public String selectIndexFromDropDown(WebElement element, int indexNumber) {
		Select object = new Select(element);
		object.selectByIndex(indexNumber);
		WebElement selectElement = object.getFirstSelectedOption();
		return selectElement.getText();
	}

	public String selectValueFromDropDown(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectElement1 = object.getFirstSelectedOption();
		return selectElement1.getText();
	}
	public void selectDropdownbyText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public String selectVisibleTextFromDropDown(WebElement element, String visibleTest) {
		Select object = new Select(element);
		object.selectByVisibleText(visibleTest);
		;
		WebElement selectElement2 = object.getFirstSelectedOption();
		return selectElement2.getText();
	}

	public boolean elementISSelected(WebElement element) {
		element.click();
		boolean b = element.isSelected();
		return b;
	}

	public void mouseRightClick(WebDriver driver, WebElement element) {
		Actions actObject = new Actions(driver);
		actObject.contextClick(element).perform();
	}

	public String selectValueFromDropdown(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public boolean elementIsSelected(WebElement element) {
		element.click();
		boolean b = element.isSelected();
		return b;
	}

	public int selectValueFromDyanmicTable(int a) {
		return (a);
	}

	public void pageScroll(int h, int v, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;// some of the clicks maynot work in normal case at that we
															// use this
		js.executeScript("window.scrollBy(" + h + "," + v + ")");
	}

	public int randon(int limit) {
		Random random = new Random();
		// int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}

	public String generateCurrentDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String formattedDate = currentDate.format(formatter);
		return formattedDate;
	}

}
