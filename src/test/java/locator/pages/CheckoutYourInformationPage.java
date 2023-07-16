package locator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

public class CheckoutYourInformationPage extends BasePage {
	/** Constructor */
	public CheckoutYourInformationPage(WebDriver driver) {
		super(driver);
	}

	/** Web Elements */
	By checkoutYourInformationPageTitle = By.className("title");
	By inputFirstName = By.id("first-name");
	By inputLastName = By.id("last-name");
	By inputPostalCode = By.id("postal-code");
	By continueButton = By.id("continue");

	/** Page Methods */
	@Step("Verify Checkout Your Information Page")
	public void verifyCheckoutYourInformationPage() throws InterruptedException {
		delay(2000);
		String sCYIText = getText(checkoutYourInformationPageTitle);
		assertEqualsTo(sCYIText, "Checkout: Your Information");
		printVerifyPage(sCYIText);
	}

	@Step("Input First Name")
	public void inputFirstName() {
		sendText(inputFirstName, generateFirstName());
	}

	@Step("Input Last Name")
	public void inputLastName() {
		sendText(inputLastName, generateLastName());
	}

	@Step("Input Postal Code")
	public void inputPostalCode() {
		sendText(inputPostalCode, generateNumber(5));
	}

	@Step("Click Continue Button")
	public void clickContinueButton() {
		click(continueButton);
	}
}
