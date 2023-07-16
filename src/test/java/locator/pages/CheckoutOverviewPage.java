package locator.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import util.loggers.Log;

public class CheckoutOverviewPage extends BasePage {
	/** Constructor */
	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
	}

	/** Web Elements */
	By checkoutOverviewPageTitle = By.className("title");
	By labelItemPrice = By.xpath("//div[@class='inventory_item_price']");
	By labelTotalItemPrice = By.className("summary_subtotal_label");
	By labelTaxItem = By.className("summary_tax_label");
	By labelTotalItemPriceWithTax = By.cssSelector(".summary_info_label.summary_total_label");
	By finishButton = By.id("finish");

	/** Page Methods */
	@Step("Verify Checkout Overview Page")
	public void verifyCheckoutOverviewPage() throws InterruptedException {
		delay(2000);
		String sCOText = getText(checkoutOverviewPageTitle);
		assertEqualsTo(sCOText, "Checkout: Overview");
		printVerifyPage(sCOText);
	}

	@Step("Verify Total Item Price")
	public void verifyTotalItemPrice() {
		double totalPrice = 0;
		for (int i = 0; i < getElementList(labelItemPrice).size(); i++) {
			String itemPrice = getElementList(labelItemPrice).get(i).getText();
			double price = Double.parseDouble(itemPrice.substring(1));
			totalPrice += price;
		}
		double totalPriceLabel = Double.parseDouble(getText(labelTotalItemPrice).split(":")[1].substring(2).trim());

		if (totalPrice == totalPriceLabel) {
			Log.info("Total price is correct : " + totalPrice + " = " + totalPriceLabel);
		} else {
			Log.info("Total price is incorrect : " + totalPrice + " = " + totalPriceLabel);
		}
	}

	@Step("Verify Total Item Price With Tax")
	public void verifyTotalItemPriceWithTax() {
		double totalPriceLabel = Double.parseDouble(getText(labelTotalItemPrice).split(":")[1].substring(2).trim());
		double totalTaxLabel = Double.parseDouble(getText(labelTaxItem).split(":")[1].substring(2).trim());
		double totalItemPriceWithTax = totalPriceLabel + totalTaxLabel;
		double totalItemPriceWithTaxLabel = Double
				.parseDouble(getText(labelTotalItemPriceWithTax).split(":")[1].substring(2).trim());

		if (totalItemPriceWithTax == totalItemPriceWithTaxLabel) {
			Log.info("Total price with tax is correct : " + totalItemPriceWithTax + " = " + totalItemPriceWithTaxLabel);
		} else {
			Log.info("Total price with tax is incorrect : " + totalItemPriceWithTax + " = "
					+ totalItemPriceWithTaxLabel);
		}
	}

	@Step("Click Finish Button")
	public void clickFinishButton() {
		click(finishButton);
	}

}
