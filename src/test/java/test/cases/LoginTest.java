package test.cases;

import static util.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("All Login Condition")
@Feature("All Login Condition Test")

public class LoginTest extends BaseTest {

	@Test(priority = 0, description = "User login with correct data")
	@Severity(SeverityLevel.BLOCKER)
	@Description("User login with correct data")
	@Story("User can login to apps with correct data")

	public void loginWithCorrectData(Method method) throws InterruptedException {
		startTest(method.getName(), "User login with correct data");

		// Steps
		loginPg.verifyLoginPage();
		loginPg.inputUsername(baseData.standard_user);
		loginPg.inputPassword(baseData.default_password);
		loginPg.clickLoginButton();
		homePg.verifyHomePage();
	}

	@Test(priority = 1, description = "User login with incorrect data")
	@Severity(SeverityLevel.NORMAL)
	@Description("User login with incorrect data")
	@Story("User cant login to apps with incorrect data")

	public void loginWithIncorrectData(Method method) throws InterruptedException {
		startTest(method.getName(), "User login with incorrect data");

		// Steps
		loginPg.verifyLoginPage();
		loginPg.inputUsername("dummy");
		loginPg.inputPassword("dummy");
		loginPg.clickLoginButton();
		loginPg.verifyUsernameAndPasswordNotMatchAlert();
	}

	@Test(priority = 1, description = "User login with locked out account")
	@Severity(SeverityLevel.NORMAL)
	@Description("User login with locked out account")
	@Story("User cant login to apps with locked out account")

	public void loginWithLockedOutAccount(Method method) throws InterruptedException {
		startTest(method.getName(), "User login with locked out account");

		// Steps
		loginPg.verifyLoginPage();
		loginPg.inputUsername(baseData.locked_out_user);
		loginPg.inputPassword(baseData.default_password);
		loginPg.clickLoginButton();
		loginPg.verifyLockedAccountAlert();
	}

	@Test(priority = 2, description = "User login with problem account")
	@Severity(SeverityLevel.NORMAL)
	@Description("User login with problem account")
	@Story("User can login to apps with problem account, but some feature has error")

	public void loginWithProblemAccount(Method method) throws InterruptedException {
		startTest(method.getName(), "User login with problem account");

		// Steps
		loginPg.verifyLoginPage();
		loginPg.inputUsername(baseData.problem_user);
		loginPg.inputPassword(baseData.default_password);
		loginPg.clickLoginButton();
		homePg.verifyHomePage();
		homePg.verifyRemoveFromCartFeature();
	}

	@Test(priority = 3, description = "User login with performance glitch account")
	@Severity(SeverityLevel.NORMAL)
	@Description("User login with performance glitch account")
	@Story("User can login to apps with performance glitch account, but long response")

	public void loginWithPerformanceGlitchAccount(Method method) throws InterruptedException {
		startTest(method.getName(), "User login with performance glitch account");

		// Steps
		loginPg.verifyLoginPage();
		loginPg.inputUsername(baseData.performance_glitch_user);
		loginPg.inputPassword(baseData.default_password);
		loginPg.clickLoginButton();
		homePg.verifyPerformanceGlitchAccount();
	}

}
