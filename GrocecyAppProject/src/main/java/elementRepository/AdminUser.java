package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class AdminUser {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait ew = new ExplicitWait();

	public AdminUser(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']//i [@class='fas fa-edit']")
	WebElement newButtonInAdminUser;

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//select[@id='user_type']")
	WebElement userType;
	
	@FindBy(xpath="//button[@name='Create']")
	WebElement saveButton;
	
	//@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//i[@class='icon fas fa-check']")
	//WebElement alertMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//button[@type='button']")
	WebElement alertCloseButtonAfterAddingUser;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteUserButton;
	
	@FindBy(xpath="//button[@data-dismiss='alert']")
	WebElement alertCloseafterDeletinguser;

	public void clickonnewButtonInAdminUserButton() throws Exception {
	//ew.explicitWaitMethod(newButtonInAdminUser, driver);
		gu.clickOnElement(newButtonInAdminUser);
	}
	
	public void inputUserDetails(String userName,String passWord,String UserType)
	{
		gu.inPutDataToTextField(username, userName);
		gu.inPutDataToTextField(password, passWord);
		gu.selectDropDownTextField(userType, UserType);
		gu.clickOnElement(saveButton);
	}
	public List<String> webElementfromListToString() throws Exception {
		List<WebElement> listofWebElement = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
			gu.mediumDelay();
			return gu.listWebElementtoString(listofWebElement);
		}
	public boolean checkingUserFromTheList(List<String> list,String chekingusername) throws Exception
	{
		return gu.checksubstring(list, chekingusername);
		
	}
	public String checkingMessageOfsuccessfulAdding()
	{
		return gu.getElementText(alertMessage);
	}
	public void closingAlertMessage()
	{
		gu.clickOnElement(alertCloseButtonAfterAddingUser);
	}
	
	public void checkingUserForDeleting(List<String> litsofUser,String userForDeletion) throws Exception
	{
		
		boolean flag=gu.checksubstring(litsofUser, userForDeletion);
		
		if(flag==true)
		{
			gu.clickOnElement(deleteUserButton);
			gu.alertAccepting(driver);
		}
		
	}
	public boolean checkingUserAfterDeleting(List<String> litsofUser,String userNameToCheck) throws Exception
	{
		return gu.checksubstring(litsofUser, userNameToCheck);
	}
	public void closeAlertAfterddeletingUser()
	{
		gu.clickOnElement(alertCloseafterDeletinguser);
	}
}


