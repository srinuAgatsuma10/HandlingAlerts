package demoQA;

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
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void normalAlert() {
		System.out.println("----Handling Normal Alerts----");
		// Click the Button
		driver.findElement(By.xpath("//button[@id='alertButton']")).click();
		// Get the Alert into a variable
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.accept();
	}

	@Test(priority = 2)
	public void timerAlert() throws Exception {
		System.out.println("----Handling Timer Alerts----");
		// Click the Button
		driver.findElement(By.xpath("//button[@id='timerAlertButton']")).click();
		// Get the Alert into a variable
		Thread.sleep(5000);
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.accept();
	}

	@Test(priority = 3)
	public void confirmAlert() throws Exception {
		System.out.println("----Handling Confirmation Alerts----");
		// Click the Button
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		// Get the Alert into a variable
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());

		// Accept/Confirm the Alert
		myAlert.accept();
		System.out.println(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText());

		// Dismiss the Alert
//		myAlert.dismiss();
//		System.out.println(driver.findElement(By.xpath("//span[@id='confirmResult']")).getText());
	}

	@Test(priority = 4)
	public void promptAlert() {
		System.out.println("----Handling Prompt Alerts----");
		// Click the Button
		driver.findElement(By.xpath("//button[@id='promtButton']")).click();
		// Get the Alert into a variable
		Alert myAlert = driver.switchTo().alert();
		System.out.println(myAlert.getText());
		myAlert.sendKeys("Luffy is still Joy Boy");
		myAlert.accept();
		System.out.println(driver.findElement(By.xpath("//span[@id='promptResult']")).getText());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
