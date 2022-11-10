package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AddProduct;
import elementRepository.DashBoard;
import elementRepository.LoginPage;
import elementRepository.ManageProduct;
import utilities.ExcelRead;

public class AddProductTestCase extends BaseClass {
	LoginPage lp;
	DashBoard dp;
	ManageProduct mp;
	AddProduct ap;

	ExcelRead ed;

	@Test(enabled = false)
	public void verifyCategoryDropDownValueSelected() 
	{
		lp = new LoginPage(driver);
		dp = new DashBoard(driver);
		mp = new ManageProduct(driver);
		ap = new AddProduct(driver);
		ed = new ExcelRead();

		lp.inputUserName(ed.readData(1, 1));
		lp.inputPassword(ed.readData(1, 2));
		lp.clickSignInButton();
		dp.clickmanageProduct();
		mp.clickOnNewbutton();

		ap.selectTextInCategoryDropDown(Constant.expectedCategoryDropDownButtonValue);

		String actual = ap.textInCategoryDropDwon();
		
		String expected = Constant.expectedCategoryDropDownButtonValue;
		Assert.assertEquals(actual, expected, Constant.errorMessageOfCategoryDropDownValue);

	}

	@Test(enabled = false)
	public void verifyImageupload() throws Exception {
		lp = new LoginPage(driver);
		dp = new DashBoard(driver);
		mp = new ManageProduct(driver);
		ap = new AddProduct(driver);
		ed = new ExcelRead();

		lp.inputUserName(ed.readData(1, 1));
		lp.inputPassword(ed.readData(1, 2));
		lp.clickSignInButton();
		dp.clickmanageProduct();
		mp.clickOnNewbutton();
		ap.srollDownThePage("window.scrollBy(0,4000)");
		

		String filepath = System.getProperty("user.dir") + ps.getProperty("imagePath");
		
	
		ap.uploadTheimage(filepath);
		boolean flag=ap.isImageisdisplayed();
		Assert.assertTrue(flag, ":image is not displayed");
		
		
	}
	
	@Test(enabled = false)
	public void verifyAlertMessageAfterSavingnewProduct() throws Exception
	{
		lp = new LoginPage(driver);
		dp = new DashBoard(driver);
		mp = new ManageProduct(driver);
		ap = new AddProduct(driver);
		ed = new ExcelRead();

		lp.inputUserName(ed.readData(1, 1));
		lp.inputPassword(ed.readData(1, 2));
		lp.clickSignInButton();
		dp.clickmanageProduct();
		mp.clickOnNewbutton();
		String actualAlertMessage=ap.clickOkButtonforSaveButtonAlert("window.scrollBy(0,4000)");
		Assert.assertEquals(actualAlertMessage, Constant.expectedAlertMessageforsaveButtonInaddNewProduct,Constant.errorMessageOfAlertMessageforsaveButtonInaddNewProduct);
		
		
	}
	@Test(enabled = true)
	public void verifyAddProductSuccessful() throws Exception
	{
		lp = new LoginPage(driver);
		dp = new DashBoard(driver);
		mp = new ManageProduct(driver);
		ap = new AddProduct(driver);
		ed = new ExcelRead();

		lp.inputUserName(ed.readData(1, 1));
		lp.inputPassword(ed.readData(1, 2));
		lp.clickSignInButton();
		dp.clickmanageProduct();
		mp.clickOnNewbutton();
		ap.addtitleForNewProduct("Roses");
		ap.clickProductTypeRadioButton();
		ap.selectTextInCategoryDropDown(Constant.expectedCategoryDropDownButtonValue);
		ap.selectTextInSubCategory("Select");
		ap.clickPriceTypeRadioButton();
		ap.getTextToMinimumPiecesOfTheProduct("9 Piece");
		ap.textToMaximumPiecesOfTheProduct("20");
		ap.textToPriceField("20");
		
		ap.srollDownThePage("window.scrollBy(0,3000)");
		ap.textToStockAvailabilityField("50");
		ap.clickStockRadioButton();
		
		ap.srollDownThePage("window.scrollBy(0,3000)");
		ap.clickFeaturedRadioButton();
		ap.clickComboPackRadioButton();
		ap.srollDownThePage("window.scrollBy(0,3000)");
		
		String actualMessage=ap.clickOkButtonforSaveButtonAlert("window.scrollBy(0,3000)");
		
		Assert.assertEquals(actualMessage, Constant.expectedAlertmessageforsaveinAddNewProduct,"No message");
		
		
	}
	

}
