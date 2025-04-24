package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends Base 
{
	@Test
	public void loginMethod()
	{
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/login");
		String username="admin";
		String password="admin";
		WebElement uname=driver.findElement(By.xpath("//input[@name='username']"));
		uname.sendKeys(username);
		WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys(password);
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
		WebElement dashboard=driver.findElement(By.xpath("//p[text()='Dashboard']"));
		boolean ishomepageloaded=dashboard.isDisplayed();
		Assert.assertTrue(ishomepageloaded);//use assertion for validation
	}
	@Test
	public void loginMethod2()
	{
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/login");
		String username="admin";
		String password="password";
		WebElement uname=driver.findElement(By.xpath("//input[@name='username']"));
		uname.sendKeys(username);
		WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys(password);
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
		WebElement alert=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean alertdisplay=alert.isDisplayed();
		Assert.assertTrue(alertdisplay);
		
		
	}
	@Test
	public void loginMethod3()
	{
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/login");
		String username="uname";
		String password="admin";
		WebElement uname=driver.findElement(By.xpath("//input[@name='username']"));
		uname.sendKeys(username);
		WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys(password);
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
		WebElement alert=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean alertdisplay=alert.isDisplayed();
		Assert.assertTrue(alertdisplay);
		
		
	}
	@Test
	public void loginMethod4()
	{
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/login");
		String username="uname";
		String password="pwd";
		WebElement uname=driver.findElement(By.xpath("//input[@name='username']"));
		uname.sendKeys(username);
		WebElement pwd=driver.findElement(By.xpath("//input[@name='password']"));
		pwd.sendKeys(password);
		WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		signin.click();
		WebElement alert=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		boolean alertdisplay=alert.isDisplayed();
		Assert.assertTrue(alertdisplay);
		
		
	}
}
