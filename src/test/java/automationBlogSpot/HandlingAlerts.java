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
		System.out.println("----Handling Normal Alerts----");
		WebElement sampleAlert = driver.findElement(By.xpath("//button[@id='alertBtn']"));
		sampleAlert.click();
		Alert sa = driver.switchTo().alert();
		System.out.println(sa.getText());
		sa.accept();
	}

	@Test(priority = 2)
	public void confirmationAlert() {
		System.out.println("----Handling Confirmation Alerts----");
		WebElement confirmAlert = driver.findElement(By.xpath("//button[@id='confirmBtn']"));
		confirmAlert.click();
		Alert ca = driver.switchTo().alert();
		System.out.println(ca.getText());
		// Accept the Alert
		ca.accept();
		String result = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(result);
		
		// Cancel the Alert
//		sa.dismiss();
//		String result = driver.findElement(By.xpath("//p[@id='demo']")).getText();
//		System.out.println(result);
	}

	@Test(priority = 3)
	public void promptAlert() {
		System.out.println("----Handling Prompt Alerts----");
		WebElement promptAlert = driver.findElement(By.xpath("//button[@id='promptBtn']"));
		promptAlert.click();
		Alert pa = driver.switchTo().alert();
		System.out.println(pa.getText());
		// Enter text and Accept the Alert
		pa.sendKeys("Monkey D Luffy");
		pa.accept();
		String result = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(result);
		
		// Cancel the Alert
//		sa.dismiss();
//		String result = driver.findElement(By.xpath("//p[@id='demo']")).getText();
//		System.out.println(result);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
