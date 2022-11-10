package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class LoginTestCase extends BaseClass

{
	LoginPage lp;
	ExcelRead ed;
	
 @Test(enabled=false)
  public void testCase01VerifySignInText() 
	{
	  lp=new LoginPage(driver);
	  String actual=lp.VerifySignInText();
	  String expected=Constant.expectedSignInbutton;
	  Assert.assertEquals(actual,expected,Constant.errorMessageOfSignInButton);
  }
  @Test(enabled=false)
  public void testCase02IsBrandIconDisplayed() 
  {
	  lp=new LoginPage(driver);
	  boolean actual=lp.isBrandIconDisplayed();
	 
	  Assert.assertTrue(actual,Constant.errorMessageOfBrandIconDisplayed );
  }
  @Test(enabled=true)
  public void logintUsingUsername()
  {
	  lp=new LoginPage(driver);
	 
	  ed=new ExcelRead();
	  
	  lp.inputUserName(ed.readData(1,1));
	  lp.inputPassword(ed.readData(1,2 ));
	  lp.clickSignInButton();
  }
  @Test(enabled=false)
  
  public void verifyRememeberMeButton()
  {
	  lp=new LoginPage(driver);
	  lp.clickRemembermeButton();
	  boolean flag=lp.verifyRememberMeCheckBox();
	  System.out.println(flag);
	  Assert.assertTrue(flag, ":not expected");
  }
  
}

