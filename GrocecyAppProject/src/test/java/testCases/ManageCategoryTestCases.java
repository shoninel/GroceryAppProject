package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.DashBoard;
import elementRepository.LoginPage;
import elementRepository.ManageCategory;
import utilities.ExcelRead;

public class ManageCategoryTestCases extends BaseClass {
	LoginPage lp;
	ExcelRead er;
	DashBoard db;
	ManageCategory mc;

	@Test
	public void verifySelectedCategory() throws Exception {
		lp = new LoginPage(driver);
		er = new ExcelRead();
		lp.inputUserName(er.readData(1, 2));
		lp.inputPassword(er.readData(2, 1));
		lp.clickSignInButton();
		db = new DashBoard(driver);
		mc = new ManageCategory(driver);
		db.clickonCategory();
		mc.clickonNewButton();

		List<String> expectedlistOfItems = mc.gettext();

		mc.clickonitems();

		List<String> actuallistofItemsSelected = mc.listOfElementsSlected();

		boolean flag = mc.comparingselectedlists(expectedlistOfItems, actuallistofItemsSelected);
		Assert.assertFalse(flag, "Selected Items are not matching");

	}

}
