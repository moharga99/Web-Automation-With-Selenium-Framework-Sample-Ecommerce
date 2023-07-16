package test.cases;

import static util.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("User Login To Apps and Checkout Several Items E2E")
@Feature("User Checkout Several Items on Apps")

public class CheckoutItemsE2ETest extends BaseTest {

	@Test(priority = 0, description = "User login to apps and checkout several items")
	@Severity(SeverityLevel.BLOCKER)
	@Description("User login to apps and checkout several items")
	@Story("User can login to apps and user can checkout serveral items until successfully")
	@Flaky

	public void checkoutSeveralItemsUntilSuccessfullyTest(Method method) throws InterruptedException {
		startTest(method.getName(), "User login to apps and checkout several items");

		// Login Page
		loginPg.verifyLoginPage();
		loginPg.inputUsername(baseData.standard_user);
		loginPg.inputPassword(baseData.default_password);
		loginPg.clickLoginButton();

		// Home Page
		homePg.verifyHomePage();
		homePg.clickAddToCartItems();
		homePg.clickCheckoutButton();

		// Cart Page
		cartPg.verifyCartPage();
		cartPg.clickRemoveOneItem();
		cartPg.clickCheckoutButton();

		// Checkout Your Information Page
		checkoutYourInformationPg.verifyCheckoutYourInformationPage();
		checkoutYourInformationPg.inputFirstName();
		checkoutYourInformationPg.inputLastName();
		checkoutYourInformationPg.inputPostalCode();
		checkoutYourInformationPg.clickContinueButton();

		// Checkout Overview Page
		checkoutOverviewPg.verifyCheckoutOverviewPage();
		checkoutOverviewPg.verifyTotalItemPrice();
		checkoutOverviewPg.verifyTotalItemPriceWithTax();
		checkoutOverviewPg.clickFinishButton();

		// Checkout Complete Page
		checkoutCompletePage.verifyCheckoutCompletePage();
		checkoutCompletePage.verifyCheckoutCompleteText();
		checkoutCompletePage.clickBackHomeButton();

		// Home Page
		homePg.verifyHomePage();

	}
}
