package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base
{
	public LogoutPage logoutpage;
	public ManageNewsPage managenewspage;
	@Test
	public void manageNews() throws Exception
	{
		//String username="admin";
		//String password="admin";
		//String text="hai";
		String username=ExcelUtilities.readStringData(1, 0, "managenews");
		String password=ExcelUtilities.readStringData(1, 1,"managenews");
		String text=ExcelUtilities.readStringData(1, 2, "managenews");
		LoginPage loginpage=new LoginPage(driver).enterUserName(username).enterPassword(password);
		
		//loginpage.enterUserName(username);
		//loginpage.enterPassword(password);
		logoutpage=loginpage.clickSignIn();
		//ManageNewsPage managenewspage=new ManageNewsPage(driver);
		//managenewspage.manageNewsMoreinfoClick();
		managenewspage=logoutpage.manageNewsMoreinfoClick();
		managenewspage.clickNews().enterNews(text).saveButtonclick();
		//managenewspage.enterNews(text);
		//managenewspage.saveButtonclick();
		boolean alertmessage=managenewspage.alertdisplay();
		Assert.assertTrue(alertmessage);
	}
}
