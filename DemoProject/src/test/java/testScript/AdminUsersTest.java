package testScript;

import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class AdminUsersTest extends Base
{
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
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignIn();
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.adminUsersMoreInfo();
		adminuserspage.clickNew();
		adminuserspage.enterUserName(uname);
		adminuserspage.enterPassword(pwd);
		adminuserspage.selectUserType();
		adminuserspage.clickSaveButton();
		adminuserspage.isAlertDisplayed();
		adminuserspage.closeAlert();
	}
	
	
}
