package test.cases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.github.javafaker.Faker;

import io.qameta.allure.Step;
import junit.framework.Assert;

import locator.pages.BasePage;
import locator.pages.CartPage;
import locator.pages.CheckoutCompletePage;
import locator.pages.CheckoutOverviewPage;
import locator.pages.CheckoutYourInformationPage;
import locator.pages.HomePage;
import locator.pages.LoginPage;
import test.data.BaseData;
import util.loggers.Log;

public class BaseTest {

	// Declare Class
	public WebDriver driver;
	public Faker faker;
	public BaseData baseData;

	// Declare Pages
	public BasePage basePg;
	public LoginPage loginPg;
	public HomePage homePg;
	public CartPage cartPg;
	public CheckoutYourInformationPage checkoutYourInformationPg;
	public CheckoutOverviewPage checkoutOverviewPg;
	public CheckoutCompletePage checkoutCompletePage;

	// Get WebDriver Method
	public WebDriver getDriver() {
		return driver;
	}

	@BeforeClass
	@Step("Automation test are starting !")
	public void configEnvironment() {
		// FirefoxDriver driver = new FirefoxDriver();
		// SafariDriver driver = new SafariDriver();
		// ChromeDriver driver = new ChromeDriver();

		// For handling org.openqa.selenium.remote.http.WebSocket$Listener onError?
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		// options.addArguments("--headless");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);

		// Webdriver Declaration
		Log.info("Automation test are starting !");
		driver = new ChromeDriver(options);
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\FileAutomation\\Driver\\chromedriver.exe");

		// Implicitly Wait Timeouts
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@BeforeMethod
	public void initClass() {
		// Class
		faker = new Faker();
		baseData = new BaseData();

		// Pages
		basePg = new BasePage(driver);
		loginPg = new LoginPage(driver);
		homePg = new HomePage(driver);
		cartPg = new CartPage(driver);
		checkoutYourInformationPg = new CheckoutYourInformationPage(driver);
		checkoutOverviewPg = new CheckoutOverviewPage(driver);
		checkoutCompletePage = new CheckoutCompletePage(driver);
	}

	@BeforeMethod
	@Step("Go To Apps and Verify")
	public void goToApps() {
		// Go To Apps
		String baseURL = "https://www.saucedemo.com/";
		driver.get(baseURL);

		// Verify Current URL & Pages Title
		String currentURL = driver.getCurrentUrl();
		String pagesTitle = driver.getTitle();
		Log.info(currentURL);
		Assert.assertEquals(currentURL, baseURL);
		Log.info(pagesTitle);
		Assert.assertEquals(pagesTitle, "Swag Labs");

		// Maximize current window
		driver.manage().window().maximize();
	}

	@AfterMethod
	@Step("Delete All Cookies After Method")
	public void deleteAllCookiesAfterMethod() {
		if (driver.manage().getCookies() != null) {
			basePg.deleteAllCookies();
		}
	}

	@AfterClass
	@Step("Automation test are ending !")
	public void tearDown() {
		Log.info("Automation test are ending !");
		driver.quit();
	}
}
