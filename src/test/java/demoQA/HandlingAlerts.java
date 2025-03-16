package demoQA;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		driver.get("https://demoqa.com/alerts");
//		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void normalAlert() {
		//Click the Button
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		// Get the Alert into a variable
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.accept();
	}
	
	@Test(priority = 2)
	public void timerAlert()throws Exception {
		//Click the Button
		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		// Get the Alert into a variable
		Thread.sleep(5000);
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.accept();
	}
	
	@Test(priority = 3)
	public void confirmAlert() {
		
	}
	
	@Test(priority = 4)
	public void promptAlert() {
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
