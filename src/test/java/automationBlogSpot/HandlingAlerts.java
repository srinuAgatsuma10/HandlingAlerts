package automationBlogSpot;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingAlerts {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void sampleAlert() {
		WebElement sampleAlert = driver.findElement(By.xpath("//button[@id='alertBtn']"));
		sampleAlert.click();
		Alert sa = driver.switchTo().alert();
		System.out.println(sa.getText());
		sa.accept();
	}

	@Test(priority = 2)
	public void confirmationAlert() {
		WebElement confirmAlert = driver.findElement(By.xpath("//button[@id='confirmBtn']"));
		confirmAlert.click();
		Alert sa = driver.switchTo().alert();
		System.out.println(sa.getText());
		// Accept the Alert
		sa.accept();
		String result = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(result);
		
		// Cancel the Alert
//		sa.dismiss();
//		System.out.println(result);
	}

	@Test(priority = 3)
	public void promptAlert() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
