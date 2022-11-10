package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageProduct {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/add']")
	WebElement newbutton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[6]//a[@role='button'][1]")
	WebElement stockbutton;

	@FindBy(xpath = "//a[@href='javascript:void(0)']")
	WebElement searchbuttontoClick;

	@FindBy(xpath = " //input[@placeholder='Title']")
	WebElement titleField;

	@FindBy(xpath = " //button[@value='sr']")
	WebElement searchButtonToSearch;
	
	

	

	public void clickOnNewbutton() {
		gu.clickOnElement(newbutton);
	}

	public void clickOnStockButton() {
		gu.clickOnElement(stockbutton);
	}

	public String getTextofStockbutton() {
		return gu.getElementText(stockbutton);
	}

	public void clickonSearchButtonToClick() {
		gu.clickOnElement(searchbuttontoClick);
	}

	public void inputToTitleField(String text) {
		gu.inPutDataToTextField(titleField, text);
	}

	public void clickonSearchButtontoSearch() {
		gu.clickOnElement(searchButtonToSearch);
	}

	public List<String> webElementfromListToString() throws InterruptedException {
	List<WebElement> listofWebElement = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
		gu.mediumDelay();
		return gu.listWebElementtoString(listofWebElement);
	}

	public boolean checkingSearchItem(List<String> items, String text) throws Exception {
		return gu.checksubstring(items, text);
	}
	
	public boolean checkingTheStockStatusText(String statusValue1,String statusValue2)
	{
		return gu.checkingTwoStrings(statusValue1, statusValue2);
	}

}
