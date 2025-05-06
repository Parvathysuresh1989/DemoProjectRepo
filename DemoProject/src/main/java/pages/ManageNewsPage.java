package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage 
{
	WebDriver driver;
	@FindBy(xpath="(//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-news')])[1]")WebElement managenewsmoreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement clicknews;
	@FindBy(xpath="//textarea[@id='news']")WebElement enternews;
	@FindBy(xpath="//button[text()='Save']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public  ManageNewsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void manageNewsMoreinfoClick()
	{
		managenewsmoreinfo.click();
	}
	public ManageNewsPage clickNews()
	{
		clicknews.click();
		return this;
	}
	public ManageNewsPage enterNews(String news)
	{
		enternews.sendKeys(news);
		return this;
	}
	public ManageNewsPage saveButtonclick()
	{
		save.click();
		return this;
	}
	public boolean alertdisplay()
	{
		 return alert.isDisplayed();
		
	}
	
}
