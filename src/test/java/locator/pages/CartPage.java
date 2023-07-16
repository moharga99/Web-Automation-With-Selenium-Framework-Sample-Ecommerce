package locator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class CartPage extends BasePage {
	/** Constructor */
	public CartPage(WebDriver driver) {
		super(driver);
	}

	/** Web Elements */
	By cartPageTitle = By.className("title");
	By removeButton = By.xpath("//button[.='Remove']");
	By checkoutButton = By.id("checkout");

	/** Page Methods */
	@Step("Verify Cart Page")
	public void verifyCartPage() throws InterruptedException {
		delay(2000);
		String sCartText = getText(cartPageTitle);
		assertEqualsTo(sCartText, "Your Cart");
		printVerifyPage(sCartText);
	}

	@Step("Click Remove One Item")
	public void clickRemoveOneItem() {
		int removeItems = 1;

		for (int i = 0; i < removeItems; i++) {
			getElementList(removeButton).get(i).click();
		}
	}

	@Step("Click Checkout Button")
	public void clickCheckoutButton() {
		click(checkoutButton);
	}

}
