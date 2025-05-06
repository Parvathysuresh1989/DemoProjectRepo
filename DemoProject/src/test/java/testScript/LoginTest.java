package testScript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base
{
	@Test(groups= {"regression"},retryAnalyzer=retry.Retry.class,description="login verification")
	public void verifyWhetherTheUserIsAbleToLoginUsingValidCredentials() throws Exception
	{
		//String username="admin";
		//String password="admin";
		String username=ExcelUtilities.readStringData(1, 0, "loginpage");
		String password=ExcelUtilities.readStringData(1, 1,"loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean isdashboardloaded=loginpage.isHomePageLoaded();
		Assert.assertTrue(isdashboardloaded,"Home page not loaded with correct user name and password");
	}
	@Test(groups= {"regression"})
	public void verifyWhetherTheUserIsNotAbleToLoginUsingInvalidUserNameAndValidPassword() throws Exception
	{
		//String username="uname";
		//String password="admin";
		String username=ExcelUtilities.readStringData(2, 0, "loginpage");
		String password=ExcelUtilities.readStringData(2, 1,"loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean isalertdisplayed=loginpage.alertdisplay();
		Assert.assertTrue(isalertdisplayed,Constants.LOGINWITHINCORRECTUSERNAME);
	}
	@Test(groups= {"regression"})
	public void verifyWhetherTheUserIsNotAbleToLoginUsingValidUserNameAndInValidPassword() throws Exception
	{
		//String username="admin";
		//String password="password";
		String username=ExcelUtilities.readStringData(3, 0, "loginpage");
		String password=ExcelUtilities.readStringData(3, 1,"loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean isalertdisplayed=loginpage.alertdisplay();
		Assert.assertTrue(isalertdisplayed);
	}
	@Test(dataProvider="LoginProvider")
	public void verifyWhetherTheUserIsNotAbleToLoginUsingInValidUserNameAndInValidPassword(String username,String password) throws Exception
	{
		//String username="username";
		//String password="password";
		//String username=ExcelUtilities.readStringData(4, 0, "loginpage");
		//String password=ExcelUtilities.readStringData(4, 1,"loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		boolean isalertdisplayed=loginpage.alertdisplay();
		Assert.assertTrue(isalertdisplayed);
	}
	@DataProvider(name="LoginProvider") 
	public Object[][] getDataFromTestData() throws Exception
	{ 
		return new Object[][] {{ExcelUtilities.readStringData(4, 0,"loginpage"),ExcelUtilities.readStringData(4,1,"loginpage")}};
	}
	
}
