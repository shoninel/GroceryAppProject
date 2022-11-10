package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//utility function /resuse/
public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void inPutDataToTextField(WebElement element, String text) {
		element.sendKeys(text);
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void selectDropDownTextField(WebElement element, String text) {
		Select s = new Select(element);
		// s.selectByValue(text);
		s.selectByVisibleText(text);
	}

	public String isDropDownTextFieldSelected(WebElement element) {
		Select s = new Select(element);

		WebElement selectedvalue = s.getFirstSelectedOption();
		String value = selectedvalue.getText();
		// System.out.println(value);
		return value;
	}

	public List<String> listWebElementtoString(List<WebElement> list) {

		List<String> listOfText = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {

			listOfText.add(list.get(i).getText());

		}
		return listOfText;

	}

	public boolean checksubstring(List<String> list, String key) throws Exception {

		boolean flag = false;
		for (String str : list) 
		{
			
			if (str.contains(key)) 
			{
				flag = true;

			}

		}
		return flag;

	}

	public void scrollDownthepage(WebDriver driver, String text) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(text);

	}

	public void mediumDelay() throws InterruptedException {
		Thread.sleep(2000);
	}

	public void uploadFile(WebDriver driver, WebElement element, String text) throws AWTException {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		StringSelection ss = new StringSelection(text);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(250);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(250);

		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public boolean checkingTwoStrings(String text1, String text2) {
		return text1.equals(text2);

	}

	public boolean verifyTheCheckBoxSelected(WebElement element) {
		return element.isSelected();
	}

	public void mouseHovering(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		action.sendKeys(element, Keys.ENTER).perform();

	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public void alertAccepting(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public String AlertMessageAfterClickingAButton(WebDriver driver) {
		// driver.switchTo().alert().accept();
		return driver.switchTo().alert().getText();
	}

	public void scrollUPthepage(WebDriver driver, String text) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(text);

	}
	public boolean comparetwolists(List<String> list1,List<String> list2)
	{
		boolean flag=false;
		if(list2.equals(list1))
		{
			flag=true;
			
		
		}
		return flag;
		
	}
	public void removeTextfromAField(WebElement element)
	{
		element.clear();
	}
	

}
