package theInternetHerokuApp;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class HandlingAlerts {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//		driver.manage().window().maximize();
	}

	// 1) Handling normal alert
	@Test
	public void normalAlerts() throws Exception {
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}

	// 1.1) Accessing name of the Alert
	@Test
	public void accessNameofAlert() throws Exception {
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Thread.sleep(3000);
		Alert myal = driver.switchTo().alert();
		System.out.println(myal.getText());
		myal.accept();
	}

	// 2) Handling Confirmation Alert
	@Test
	public void confirmationAlerts() throws Exception {
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept(); // Accept the Alert
		driver.switchTo().alert().dismiss(); // Dismiss the Alert
	}

	// 3) Handling prompt Alert
	@Test
	public void promptAlerts() {
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
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
