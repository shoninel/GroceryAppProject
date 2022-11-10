package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.AdminUser;
import elementRepository.DashBoard;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class AdminUserTestCases extends BaseClass {

	LoginPage lp;
	DashBoard db;
	ExcelRead er;
	AdminUser au;

	@Test(enabled=false)
	public void verifyAddUserinAdminUserPage() throws Exception {
		lp = new LoginPage(driver);
		er = new ExcelRead();
		db = new DashBoard(driver);
		au = new AdminUser(driver);

		lp.inputUserName(er.readData(1, 2));
		lp.inputPassword(er.readData(2, 1));
		lp.clickSignInButton();
		db.clickonAdminUser();
		au.clickonnewButtonInAdminUserButton();
		au.inputUserDetails("shoni", "shonima", "Staff");

		List<String> listOfUsers = au.webElementfromListToString();
		boolean flag = au.checkingUserFromTheList(listOfUsers, "shoni");
		au.closingAlertMessage();
		Assert.assertTrue(flag, ":user is not added");

	}
	@Test(enabled=true)
	public void verifyDeletefunctioninAdminUserPage() throws Exception
	{
		lp = new LoginPage(driver);
		er = new ExcelRead();
		db = new DashBoard(driver);
		au = new AdminUser(driver);

		lp.inputUserName(er.readData(1, 2));
		lp.inputPassword(er.readData(2, 1));
		lp.clickSignInButton();
		db.clickonAdminUser();
		List<String> listOfUsers = au.webElementfromListToString();
		System.out.println(listOfUsers);
		au.checkingUserForDeleting(listOfUsers, "shoni");
		List<String> listOfUsersafterDeletion = au.webElementfromListToString();
		System.out.println(listOfUsersafterDeletion);
		boolean flag=au.checkingUserAfterDeleting(listOfUsersafterDeletion, "shoni");
		au.closeAlertAfterddeletingUser();
		Assert.assertFalse(flag, "UserName is not deleted");
		
		
		
	}
}
