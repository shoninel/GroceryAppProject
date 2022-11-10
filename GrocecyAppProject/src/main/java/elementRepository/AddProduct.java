package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class AddProduct {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWait ew = new ExplicitWait();

	public AddProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "//select[@ name='cat_id']")
	private WebElement category;
	
	
	

	public WebElement getCategory() {
		return category;
	}

	public void setCategory(WebElement category) {
		this.category = category;
	}



	@FindBy(xpath = "//input[@id='main_img']")
	WebElement mainImageUpload;
	
	@FindBy(xpath = "//div[@id='imagePreview']")
	WebElement imageReview;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	
	@FindBy(xpath = "//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath = "//label[@class='radio-inline']//input[@value='Others']")
	WebElement productType;
	
	@FindBy(xpath="//select[@id='sub_id']")
	WebElement subCategory;
	@FindBy(xpath = "//label[@class='radio-inline']//input[@id='purpose1']")
	WebElement productTypePiece;
	
	@FindBy(xpath="//select[@id='p_minimum']")
	WebElement minimumPiece;
	
	@FindBy(xpath="//input[@id='p_max']")
	WebElement maximumPieces;
	
	@FindBy(xpath = "//input[@id='p_price']")
	WebElement price;
	
	@FindBy(xpath="//input[@id='p_stock']")
	WebElement stockAvailability;
	@FindBy(xpath = "//label[@class='radio-inline'][1]//input[@name='stock']")
	WebElement stockYesRadioButton;
	@FindBy(xpath = "//label[@class='radio-inline'][2]//input[@name='featured']")
	WebElement featuredNoRadioButton;
	
	@FindBy(xpath = "//div[@class='col-sm-6 form-group'][3]//input[@value='no']")
	WebElement comboPackButton;
	
	@FindBy(xpath="//div[@class='errors']")
	WebElement alertbutton;
	

	public void selectTextInCategoryDropDown(String productCategory) {
		
		gu.selectDropDownTextField(category, productCategory);
	}

	public String textInCategoryDropDwon() {
		return gu.isDropDownTextFieldSelected(category);
	}

	public void explicitWaitMethod(WebDriver driver) {
		ew.explicitWaitMethod(category, driver);
	}

	public void srollDownThePage(String scrolldownparameter) throws Exception {
		
		

		gu.scrollDownthepage(driver,scrolldownparameter);
		gu.mediumDelay();
	}

	public void uploadTheimage(String text) throws Exception {
		gu.uploadFile(driver, mainImageUpload, text);
		
	}


	public boolean isImageisdisplayed()
	{
		return gu.isElementEnabled(imageReview);
	}
	
	public String clickOkButtonforSaveButtonAlert(String scrolldownparameter ) throws Exception
	
	{ 
		gu.scrollDownthepage(driver, scrolldownparameter);
		gu.mediumDelay();
		gu.clickOnElement(saveButton);
		//gu.scrollUPthepage(driver, "window.scrollBy(0,-4000)");
		String alertMessage=gu.AlertMessageAfterClickingAButton(driver);
		
		gu.alertAccepting(driver);
		return alertMessage;
	}
	public void addtitleForNewProduct(String productTitle)
	{
		gu.inPutDataToTextField(title, productTitle);
		
	}
	public void clickProductTypeRadioButton()
	{
		gu.clickOnElement(productType);
		
	}
	public void selectTextInSubCategory(String productsubcategory)
	{
		gu.selectDropDownTextField(subCategory, productsubcategory);
	}
	public void clickPriceTypeRadioButton()
	{
		gu.clickOnElement(productTypePiece);
	}
	public void getTextToMinimumPiecesOfTheProduct(String minimum)
	{
		gu.selectDropDownTextField(minimumPiece, minimum);
	}
	public void textToMaximumPiecesOfTheProduct(String maximum)
	{
		gu.inPutDataToTextField(maximumPieces, maximum);
	}
	public void textToPriceField(String priceofProduct)
	{
		gu.inPutDataToTextField(price, priceofProduct);
	}
	public void textToStockAvailabilityField(String stockAvailable)
	{
		gu.inPutDataToTextField(stockAvailability, stockAvailable);
	}
	public void clickStockRadioButton()
	{
		gu.clickOnElement(stockYesRadioButton);
	}
	public void clickFeaturedRadioButton()
	{
		gu.clickOnElement(featuredNoRadioButton);

	}
	public void clickComboPackRadioButton()
	{
		gu.clickOnElement(comboPackButton);
	}
	public String getTextFromAlert()
	{
		return gu.getElementText(alertbutton);
	}

}
