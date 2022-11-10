package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashBoard {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Manage Product']")
	WebElement manageProduct;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	WebElement categoryButton;
	
	@FindBy(xpath = "//li[@class='nav-item has-treeview menu-open']")
	WebElement  categoryButton1;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']//i[@class='fas fa-arrow-circle-right']")
	WebElement categories;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//i[@class='fas fa-arrow-circle-right']")
	WebElement adminUsers;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']//i[@class='fas fa-arrow-circle-right']")
	WebElement managePages;
	
	public void clickmanageProduct() {
		gu.clickOnElement(manageProduct);
	}
	public void clickonCategory()
	{
		gu.clickOnElement(categories);;
	}
	public void clickonAdminUser()
	{
		gu.clickOnElement(adminUsers);
	}
	public void clickOnMangePage()
	{
		gu.clickOnElement(managePages);
	}

}
