package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.AddProduct;
import elementRepository.DashBoard;
import elementRepository.LoginPage;
import elementRepository.ManagePage;
import elementRepository.ManageProduct;
import utilities.ExcelRead;

public class ManagePageTestCases extends BaseClass {
	LoginPage lp;
	DashBoard dp;
	ManageProduct mp;
	AddProduct ap;

	ExcelRead ed;
	ManagePage mc;

	@Test
	public void verifyEditPage() throws Exception {
		lp = new LoginPage(driver);
		ed = new ExcelRead();
		dp = new DashBoard(driver);
		mc=new ManagePage(driver);
		lp.inputUserName(ed.readData(1, 2));
		lp.inputPassword(ed.readData(2, 1));
		lp.clickSignInButton();

		dp.clickOnMangePage();
		mc.clickEditButtonOnManagePage();
		
		
		mc.addtextinDescription(Constant.expectedDescriptionTextonManagePage);
		
		mc.clickonupdateButton("window.scrollBy(0,4000)");
		mc.clickEditButtonOnManagePage();
		String expected=Constant.expectedDescriptionTextonManagePage;
		String actual=mc.checkingTheTextAfterUpdate();
		Assert.assertEquals(actual, expected,":not updated");
		
		

	}
}
