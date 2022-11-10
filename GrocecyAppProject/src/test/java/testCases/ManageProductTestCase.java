package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AddProduct;
import elementRepository.DashBoard;
import elementRepository.LoginPage;
import elementRepository.ManageProduct;
import utilities.ExcelRead;
import utilities.ExplicitWait;

public class ManageProductTestCase extends BaseClass

{
	LoginPage lp;

	ManageProduct mp;
	DashBoard db;

	ExcelRead ed;

	@Test(enabled = false)
	public void verifyStockButton() {
		lp = new LoginPage(driver);

		db = new DashBoard(driver);
		mp = new ManageProduct(driver);
		ed = new ExcelRead();

		lp.inputUserName(ed.readData(1, 2));
		lp.inputPassword(ed.readData(2, 2));
		lp.clickSignInButton();

		db.clickmanageProduct();

		mp.clickOnStockButton();
		String expected = Constant.expectedStatusOfStockButton;

		String actual = mp.getTextofStockbutton();
		
		boolean flag=mp.checkingTheStockStatusText(expected, actual);
		System.out.println(flag);
		Assert.assertFalse(flag, Constant.expectedStatusOfStockButton);

	}

	@Test
	public void verifyOutputOfSeachResult() throws Exception {
		lp = new LoginPage(driver);
		ed = new ExcelRead();
		db = new DashBoard(driver);
		mp = new ManageProduct(driver);
		

		lp.inputUserName(ed.readData(1, 2));
		lp.inputPassword(ed.readData(2, 2));
		lp.clickSignInButton();

		db.clickmanageProduct();
		mp.clickonSearchButtonToClick();
		mp.inputToTitleField(Constant.valueOnTitleField);

		mp.clickonSearchButtontoSearch();

		List<String> listOfItems = mp.webElementfromListToString();
		boolean flag = mp.checkingSearchItem(listOfItems, "banana");

	
		
		Assert.assertTrue(flag,":not expected");
		

	}

	

}
