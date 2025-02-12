package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ScreenshotUtil;

public class LoginTest {
	private WebDriver driver;

	@BeforeSuite
	public void setupSuite() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	@Parameters({ "validUsername", "validPassword" })
	public void testValidLogin(String username, String password) {
		driver.get("https://www.saucedemo.com/");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

		WebElement inventoryPage = driver.findElement(By.className("title"));
		Assert.assertTrue(inventoryPage.isDisplayed(), "User failed to login");

		ScreenshotUtil.captureScreenshot(driver, "valid_login");
	}

	@Test
	@Parameters({ "invalidUsername", "invalidPassword" })
	public void testInvalidLogin(String username, String password) {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

		WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
		Assert.assertTrue(errorMessage.isDisplayed(), "Error message not shown for invalid login");

		ScreenshotUtil.captureScreenshot(driver, "invalid_login");
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
