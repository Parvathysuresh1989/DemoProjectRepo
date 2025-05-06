package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminUsersTest extends Base
{
	public LogoutPage logoutpage;
	AdminUsersPage adminuserspage;
	@Test
	public void adminUsers() throws Exception
	{
		FakerUtility fakerutility=new FakerUtility();
		//String username="admin";
		//String Password="admin";
		//String uname="parvathy";
		//String pwd="parvathy";
		String username=ExcelUtilities.readStringData(1, 0, "adminusers");
		
		String password=ExcelUtilities.readStringData(1, 1,"adminusers");
		String uname=fakerutility.creatARandomFirstName();
		String pwd=fakerutility.creatARandomFirstName();
		//String uname=ExcelUtilities.readStringData(1, 2, "adminusers");
		//String pwd=ExcelUtilities.readStringData(1, 3, "adminusers");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		//loginpage.enterPassword(password);
		logoutpage=loginpage.clickSignIn();
		adminuserspage=logoutpage.adminUsersMoreInfo();
		//AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		//adminuserspage.adminUsersMoreInfo();
		adminuserspage.clickNew();
		adminuserspage.enterUserName(uname);
		adminuserspage.enterPassword(pwd);
		adminuserspage.selectUserType();
		adminuserspage.clickSaveButton();
		//adminuserspage.isAlertDisplayed();
		boolean alertmessage=adminuserspage.alertdisplay();
		Assert.assertTrue(alertmessage);
		//adminuserspage.closeAlert();
	}
	
	
}
