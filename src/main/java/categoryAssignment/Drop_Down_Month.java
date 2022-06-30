package categoryAssignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Drop_Down_Month {
	WebDriver driver;

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver102.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("http://techfios.com/test/103/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void addCategory() throws InterruptedException {
		// Relative xpath : //select[@name='category']
		By MONTH_DROPDOWN_FIELD = By.xpath("//select[@name='due_month']");
		Select sel = new Select(driver.findElement(MONTH_DROPDOWN_FIELD));
		sel.selectByVisibleText("None");
		Thread.sleep(4000);
		List<WebElement> op = sel.getOptions();
		int size = op.size();
		for (int i = 0; i < size; i++) {

			String options = op.get(i).getText();
			System.out.println(options);

		}

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
