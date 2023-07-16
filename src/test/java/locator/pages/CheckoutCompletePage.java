package locator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import util.loggers.Log;

public class CheckoutCompletePage extends BasePage {
	/** Constructor */
	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
	}

	/** Web Elements */
	By checkoutCompletePageTitle = By.className("title");
	By completeOrder1Label = By.cssSelector(".complete-header");
	By completeOrder2Label = By.cssSelector(".complete-text");
	By backHomeButton = By.cssSelector("#back-to-products");

	/** Page Methods */
	@Step("Verify Checkout Complete Page")
	public void verifyCheckoutCompletePage() throws InterruptedException {
		delay(2000);
		String sCCText = getText(checkoutCompletePageTitle);
		assertEqualsTo(sCCText, "Checkout: Complete!");
		printVerifyPage(sCCText);
	}

	@Step("Verify Checkout Complete Text")
	public void verifyCheckoutCompleteText() {
		if (getWebElement(completeOrder1Label).isDisplayed()
				&& getWebElement(completeOrder2Label).isDisplayed() == true) {
			Log.info(getText(completeOrder1Label) + " , " + getText(completeOrder2Label));
		} else {
			Log.info("Checkout has failed!");
		}
	}

	@Step("Click Back Home Button")
	public void clickBackHomeButton() {
		click(backHomeButton);
	}

}
