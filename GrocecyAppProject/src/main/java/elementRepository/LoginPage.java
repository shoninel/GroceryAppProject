package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SignInButton;

	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginPageLabel;

	@FindBy(xpath = "//input[@type='text']")
	WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='remember']")
	WebElement rememeberButton;
	
	@FindBy(xpath="//label[@for='remember']")
	WebElement rememeberButton1;

	public String VerifySignInText() {
		return gu.getElementText(SignInButton);
	}

	public void inputUserName(String uname) {
		gu.inPutDataToTextField(username, uname);

	}

	public void inputPassword(String pwd) {
		gu.inPutDataToTextField(password, pwd);

	}

	public void clickSignInButton() {
		gu.clickOnElement(SignInButton);

	}

	public boolean isBrandIconDisplayed() {
		return gu.isElementDisplayed(loginPageLabel);
	}

	public void clickRemembermeButton() {
		gu.clickOnElement(rememeberButton1);
  	}
	public boolean verifyRememberMeCheckBox()
	{
		boolean flag=gu.verifyTheCheckBoxSelected(rememeberButton);
		return flag;
		
	}
}
