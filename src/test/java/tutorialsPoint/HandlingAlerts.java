package tutorialsPoint;

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
		driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
		driver.manage().window().maximize();
	}

	// 1) Handling normal alert
	@Test(priority = 1)
	public void normalAlerts() throws Exception {
		driver.findElement(By.xpath("//button[normalize-space()='Alert']")).click();
		Thread.sleep(3000);
		Alert myal = driver.switchTo().alert();
		System.out.println(myal.getText());
		myal.accept();
	}

	// 2) Alert will appear after 5 seconds
	@Test(priority = 2)
	public void accessNameofAlert() throws Exception {
		driver.findElement(By.xpath("//button[@onclick='myMessage()']")).click();
		Thread.sleep(5000);
		Alert myal = driver.switchTo().alert();
		System.out.println(myal.getText());
		myal.accept();
	}

	// 3) Handling Confirmation Alert
	@Test(priority = 3)
	public void confirmationAlerts() throws Exception {
		driver.findElement(By.xpath("//button[@onclick='myDesk()']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept(); // Accept the Alert
		//	driver.switchTo().alert().dismiss(); // Dismiss the Alert
	}

	// 4) Handling prompt Alert
	@Test(priority = 4)
	public void promptAlerts() {
		driver.findElement(By.xpath("//button[@onclick='myPromp()']")).click();
		Alert myal = driver.switchTo().alert();
		myal.sendKeys("Sai Charan");
		System.out.println(myal.getText());
		myal.accept();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
