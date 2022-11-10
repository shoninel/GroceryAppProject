package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManagePage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait ew = new ExplicitWait();

	public ManagePage(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr/td[5]//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/edit?edit=249&page_ad=1']//i[@class='fas fa-edit']")
	WebElement editbuttonOnManagepage;
	
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement description;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement updateButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//button[@type='button']")
	WebElement alertCloseonManagepage;
	
	public void clickmanagePage(String userName,String PassWord)
	{
	gu.clickOnElement(null);
	}
	public void clickEditButtonOnManagePage() throws Exception
	{
		gu.mediumDelay();
		gu.clickOnElement(editbuttonOnManagepage);
	}
	public void removeTheTextFromDescroption()
	{
		gu.removeTextfromAField(description);
	}
	public void  addtextinDescription(String descriptiontext) throws Exception
	{
		gu.removeTextfromAField(description);
		gu.mediumDelay();
		gu.inPutDataToTextField(description, descriptiontext);
	}
	
	public void clickonupdateButton(String scrollDownText) throws Exception
	{
		gu.scrollDownthepage(driver, scrollDownText);
		gu.mediumDelay();
		gu.clickOnElement(updateButton);
		gu.clickOnElement(alertCloseonManagepage);
	}
	public String checkingTheTextAfterUpdate()
	{
		return gu.getElementText(description);
		
	}

}
