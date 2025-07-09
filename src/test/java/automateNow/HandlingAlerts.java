package automateNow;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		driver.get("https://practice-automation.com/popups/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void sampleAlert() {
		// Click Alert Popup button
		driver.findElement(By.xpath("//button[@id='alert']")).click();		
		Alert sa = driver.switchTo().alert();
		System.out.println(sa.getText());
		sa.accept();
	}

//	@Test(priority = 2)
	public void confirmationAlert() {

	}

//	@Test(priority = 3)
	public void promptAlert() {

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
