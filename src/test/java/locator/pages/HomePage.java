package locator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import util.loggers.Log;

public class HomePage extends BasePage {
	/** Constructor */
	public HomePage(WebDriver driver) {
		super(driver);
	}

	/** Web Elements */
	By homePageTitle = By.className("app_logo");
	By addToCartButton = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
	By checkoutButton = By.className("shopping_cart_link");
	By removeFromCartButton = By.xpath("//button[@class='btn btn_secondary btn_small btn_inventory']");

	/** Page Methods */
	@Step("Verify Home Page")
	public void verifyHomePage() throws InterruptedException {
		delay(2000);
		String sHomeText = getText(homePageTitle);
		assertEqualsTo(sHomeText, "Swag Labs");
		printVerifyPage(sHomeText);
	}

	@Step("Click Add To Cart Items")
	public void clickAddToCartItems() {
		int addItems = 3;

		for (int i = 0; i < addItems; i++) {
			getElementList(addToCartButton).get(i).click();
		}
	}

	@Step("Click Checkout Button")
	public void clickCheckoutButton() {
		click(checkoutButton);
	}

	@Step("Verify Remove From Cart Feature")
	public void verifyRemoveFromCartFeature() {
		getElementList(addToCartButton).get(0).click();
		getElementList(addToCartButton).get(0).click();

		if (getWebElement(removeFromCartButton).isDisplayed() == true) {
			Log.info("Remove from cart button is not working!");
		} else {
			Log.info("Remove from cart button is working!");
		}
	}

	@Step("Verify Performance Glitch Account")
	public void verifyPerformanceGlitchAccount() throws InterruptedException {
		delay(3);
		int attemptCheck = 3;
		for (int i = 0; i < attemptCheck; i++) {
			if (getWebElement(homePageTitle).isDisplayed() == false) {
				Log.info("User still not logged in to the app!");
			} else {
				Log.info("User has logged in to the app!");
			}
		}
	}

}
