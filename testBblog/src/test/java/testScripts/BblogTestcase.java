package testScripts;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BblogTestcase {
	

	public WebDriver driver;

		
	@BeforeSuite
	
	public void setsuite() throws InvocationTargetException, Exception {
			

		ChromeOptions Options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver(Options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
		
	@Test(priority=1)
	public void loginBBlog() throws InterruptedException
	{
		driver.get("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/#/");
		System.out.println("Open Application");
		driver.findElement(By.xpath(".//a[contains(text(),'Sign in')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//input[@placeholder='Username']")).sendKeys("ramyareddyqa@gmail.com");// 
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//input[@placeholder='Password']")).sendKeys("ramyareddyqa");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//button[contains(text(),'Sign in')]")).click();
		Thread.sleep(3000);
	}
	
	
	@Test(priority=2)
	public void addArticle() throws InterruptedException
	{	
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//a[contains(text(),'Post')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//input[contains(@placeholder,'Title')]")).sendKeys("Test Article");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//input[contains(@placeholder,'about')]")).sendKeys("Earth Day");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//textarea[contains(@placeholder,'markdown')]")).sendKeys("Desc Article on Earth Day");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//input[contains(@placeholder,'Tags')]")).sendKeys("earth");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//button[@type='button']")).click();
		
	}
	
	

	@Test(priority=3)
	public void UpdateArticle() throws InterruptedException
	{	
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//a[contains(text(),'Edit')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//input[contains(@placeholder,'about')]")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//input[contains(@placeholder,'about')]")).sendKeys("Earth Day Celebration");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//button[@type='button']")).click();
		
	}
	
	
	@Test(priority=4)
	public void DeleteArticle() throws InterruptedException
	{	
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//button[contains(text(),'Delete')]")).click();
		Thread.sleep(2000);
	}
	
	@Test(priority=5)
	public void logOut() throws InterruptedException
	{	
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//a[contains(text(),'Settings')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//button[contains(text(),'Or click here to logout.')]")).click();
		Thread.sleep(2000);
	}
	
	@AfterSuite
	public void teardown() throws Throwable {
		
			driver.close();
			driver.quit();	
}
}