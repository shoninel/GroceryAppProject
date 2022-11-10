package elementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExplicitWait;
import utilities.GeneralUtilities;


public class ManageCategory
{
	
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait ew = new ExplicitWait();
	public ManageCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//li[@class='ms-elem-selectable']//span[text()='Wayanadan Spices' ]")
	WebElement selectGroupItem1;
	
	@FindBy(xpath = "//li[@class='ms-elem-selectable']//span[text()='Merchants' ]")
	WebElement selectGroupItem2;
	 
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']//i[@class='fas fa-edit']")
	WebElement newButton;
	
	@FindBy(xpath="//div[@class='ms-selection']")
	WebElement selectedItems;
	
	public void clickonNewButton()
	{
		gu.clickOnElement(newButton);
	}

	public void clickonitems()
	{
		gu.clickOnElement(selectGroupItem1);
		gu.clickOnElement(selectGroupItem2);
		
		
	}
	
	public List<String> gettext() throws Exception
	{
		List<String> items=new ArrayList<String>();
		//gu.mediumDelay();
		items.add(gu.getElementText(selectGroupItem1));
		items.add(gu.getElementText(selectGroupItem2));
		
		return items;
	}

	public List<String> listOfWebElement() throws InterruptedException 
	{
		List<WebElement> listofWebElement = driver.findElements(By.xpath("//div[@class='ms-selectable']//li//span[text()='Merchants' or text()='GOLDEN VALLY']"));
			gu.mediumDelay();
			System.out.println(listofWebElement);
			for (int i=0;i<listofWebElement.size();i++)
			{
			gu.mouseHovering(driver, listofWebElement.get(i));
			
			}
			
			return gu.listWebElementtoString(listofWebElement);
			
			}

	public List<String> listOfElementsSlected() throws Exception 
	{
		List<WebElement> listofWebElements = driver.findElements(By.xpath("//div[@class='ms-selection']"));
			gu.mediumDelay();
			
			return gu.listWebElementtoString(listofWebElements);
			
			}
	public boolean comparingselectedlists(List<String> expectedList,List<String> actualList)
	{
		
		return gu.comparetwolists(expectedList, actualList);
	}
	
}

