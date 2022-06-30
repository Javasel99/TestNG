package categoryAssignment;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class No_Duplicate_Category {
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
	public void noDuplicateItem() throws InterruptedException {

		By CATEGORY_DROPDOWN_Field = By.xpath("//select[@name='category']");

		Select sel = new Select(driver.findElement(CATEGORY_DROPDOWN_Field));
		List<WebElement> op = sel.getOptions();
		System.out.println("No of Items in the drop down is : " + op.size());

// for finding duplicate, we use Set method as set doesn't allow any duplicates           
		Set set = new HashSet();
		set.addAll(op);
		System.out.println("after removing duplicates : " + set.size());

		Thread.sleep(5000);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}