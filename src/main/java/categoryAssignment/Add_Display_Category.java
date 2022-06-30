package categoryAssignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Add_Display_Category {
	WebDriver driver;

	@BeforeMethod
	public void init() {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver102.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/test/103/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void addCategory() {
		driver.findElement(By.cssSelector("input[name='categorydata']")).sendKeys("BasketBall");
		driver.findElement(By.xpath("/html/body/div[4]/span/input[2]")).click();
		Boolean visibleCategory = driver.findElement(By.xpath("/html/body/div[4]/span/input[2]")).isDisplayed();
		System.out.println("The Textbox visibility is: " + visibleCategory);
		if (visibleCategory) {
			Boolean status = driver.findElement(By.xpath("/html/body/div[4]/span/input[2]")).isEnabled();
			System.out.println("The status of Textbox is: " + status);
			// If TextBox is enabled set a value to it
			if (status) {
				driver.findElement(By.xpath("/html/body/div[4]/span/input[2]")).sendKeys("BasketBall");
			}
		}
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}