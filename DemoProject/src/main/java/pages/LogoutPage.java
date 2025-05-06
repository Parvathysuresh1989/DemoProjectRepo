package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
	WebDriver driver;
	@FindBy(xpath="//img[@alt='User Image'and @class='img-circle']")WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logout;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement signinpage;
	@FindBy(xpath="//a[@class='small-box-footer'][1]")WebElement adminusermoreinfo;
	@FindBy(xpath="(//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-news')])[1]")WebElement managenewsmoreinfo;
	public LogoutPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public AdminUsersPage adminUsersMoreInfo()
	{
		adminusermoreinfo.click();
		return new AdminUsersPage(driver);
	}
	public ManageNewsPage manageNewsMoreinfoClick()
	{
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}
	public void clickAdmin()
	{
		admin.click();
	}
	public void clickLogout()
	{
		logout.click();
	}
	public boolean isSigninPageLoaded()
	{
		return signinpage.isDisplayed();
	}
	
}
