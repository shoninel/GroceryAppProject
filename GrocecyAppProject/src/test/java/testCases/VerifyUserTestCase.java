package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import elementRepository.VerifyUsers;
import utilities.ExcelRead;
  
public class VerifyUserTestCase extends BaseClass {
	VerifyUsers vu;
	LoginPage lp;
	ExcelRead er;
  @Test
  public void verifyUserpassword()
  {
	 lp=new LoginPage(driver);
	  vu=new VerifyUsers(driver);
	  er=new ExcelRead();
	  lp.inputUserName(er.readData(1, 2));
	  lp.inputPassword(er.readData(2, 1));
	  lp.clickSignInButton();
	  vu.clickVerifyUserButton();
	  vu.clickPasswordInVerifyUser();
	  String expected=Constant.expectedpasswordinVerifyUserPage;
	  String actual=vu.verifypasswordInVerifyUser();
	  Assert.assertEquals(actual, expected, Constant.errorMessageOfverifypasswordInVerifyUser);
  }
}
