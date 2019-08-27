package com.atmecs.testscripts;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.atmecs.orangehrm.getdatafrompropertyfile.ReadFile;

public class HomePageTesting {

	private static WebDriver driver;
	static ReadFile read = new ReadFile();

	public static void main(String[] args) {
		setUp();
	}

//	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Before class run");
		testHome();
	}

//	@AfterClass
	public static void tearDown() {
		driver.quit();
		System.out.println("After class run");

	}

//	@Test
	public static void testHome() {
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("cta_button_3749854_7956a89e-6f16-4650-8d49-9f825d5cc7d6")).click();
		driver.findElement(By.id(read.getLocater("first_name"))).click();
		driver.findElement(By.id(read.getLocater("first_name"))).sendKeys("saurabh");
		driver.findElement(By.id(read.getLocater("last_name"))).sendKeys("chauhan");
		driver.findElement(By.id(read.getLocater("Bussiness_email"))).sendKeys("chauhaninfj@gmail.com");
		driver.findElement(By.id(read.getLocater("job_title"))).sendKeys("engineer");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='optanon-allow-all accept-cookies-button']")).click();
		driver.findElement(By.id(read.getLocater("no_of_employees"))).click();
		{
//		{
			WebElement dropdown = driver.findElement(By.id(read.getLocater("no_of_employees")));
			dropdown.findElement(By.xpath("//option[. = '401 - 450']")).click();
		}
		driver.findElement(By.id(read.getLocater("no_of_employees"))).click();
		driver.findElement(By.id(read.getLocater("company_name"))).click();
		driver.findElement(By.id(read.getLocater("company_name"))).sendKeys("Atmecs");
		driver.findElement(By.id(read.getLocater("industry"))).click();
		{
			WebElement dropdown = driver.findElement(By.id(read.getLocater("industry")));
			dropdown.findElement(By.xpath("//option[. = 'Computer / Technology - Services / Consultancy']")).click();
		}
		driver.findElement(By.id(read.getLocater("industry"))).click();
		driver.findElement(By.id(read.getLocater("phone_no"))).click();
		driver.findElement(By.id(read.getLocater("phone_no"))).sendKeys("9179424242");
		driver.findElement(By.id(read.getLocater("country"))).click();
		{
			WebElement dropdown = driver.findElement(By.id(read.getLocater("country")));
			dropdown.findElement(By.xpath("//option[. = 'India']")).click();
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Time out");
			e.printStackTrace();
		}
		driver.findElement(By.id(read.getLocater("state"))).click();
		{
			WebElement dropdown = driver.findElement(By.id(read.getLocater("state")));
			dropdown.findElement(By.xpath("//option[. = 'Madhya Pradesh']")).click();
		}
		driver.findElement(By.id(read.getLocater("url"))).sendKeys("cody9897");
		driver.findElement(By.id(read.getLocater("submit"))).click();
		System.out.println("Test run");
		tearDown();
	}
}
