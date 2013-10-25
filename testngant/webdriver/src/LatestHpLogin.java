package testngant.webdriver.src;

import org.testng.annotations.Test;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import HP.webaut.base.BasePage;
import HP.pageobjects.home.HomePage;
import HP.webaut.base.GlobalConst;
import HP.webaut.utils.CustomLogger;


public class LatestHpLogin extends BasePage {


	/*
	 * In the language of PageObject model design pattern the methods in the
	 * Page class are the services / operations provided by the Page.
	 * 
	 * Services/operations in all Page classes will not be client/build
	 * specific. Each service/operation implemented in Praxify Web for this page
	 * will be defined for testing here. You can chose which service to test
	 * based upon the type of testing to be done.
	 * 
	 * 
	 * Listings of the services/operations provided by Login page of Praxify
	 * Web: 
	 * 1. A specific url for login 
	 * 2. Display of Product Logo image 
	 * 3. Controls to enter user credentials and log-in to the app. 
	 * 4. Valid log-in
	 * 5. Invalid log-in
	 * 6. Logging in on empty credentials. 
	 * 7. Forgot password service initiation
	 */


	private WebElement usernameTextField;
	private WebElement passwordTextField;
	private WebElement loginButton;
	private WebElement invalidDetailsMsg;
	private WebElement emptyUserMsg;
	private WebElement emptyPasswordMsg;
	
	private String usernameTextFieldLocator;
	private String passwordTextFieldLocator;
	private String loginButtonLocator;

	private String invalidDetailsMsgLocator;
	private String emptyUserMsgLocator;
	private String emptyPasswordMsgLocator;

	/*
	 * Constructor to verify that the page, and possibly critical elements on
	 * the page, were loaded correctly.
	 */

	public LatestHpLogin(WebDriver driverFromTest, CustomLogger loggerFromTest,
			HashMap<String, String> testDataMapFromTest) throws Exception {
		super(driverFromTest, loggerFromTest, testDataMapFromTest);


		usernameTextFieldLocator = testDataMap.get("usernameTextFieldLocator");
		passwordTextFieldLocator = testDataMap.get("passwordTextFieldLocator");
		loginButtonLocator = testDataMap.get("loginButtonLocator");



		invalidDetailsMsgLocator = testDataMap.get("invalidDetailsMsgLocator");
		emptyUserMsgLocator = testDataMap.get("emptyUserMsgLocator");
		emptyPasswordMsgLocator = testDataMap.get("emptyPasswordMsgLocator");

		try {
			logger.log("Entering login URL and proceeding to log-in..");

			if (!driver.getCurrentUrl().equals(GlobalConst.LOGIN_URL)) {

				throw new IllegalStateException(
						"This is not the login page. Current page" + "is: "
								+ driver.getCurrentUrl());

			}

		} catch (Exception e) {

			pageSnap.capture(e, this.getClass().getSimpleName());
		}

	}



	/**
	 * helper method that enters login details for loginAsValidUser and loginAsInvalidUser services
	 * @param String username
	 * @param String password
	 * 
	 */

	public void submitLoginDetails(String username, String password) throws Exception
	{

		logger.log("Finding the username text-field");
		usernameTextField = driver.findElement(By
				.name(usernameTextFieldLocator));

		logger.log("Found. Entering "+username+ " as username");
		usernameTextField.sendKeys(username);


		logger.log("Finding the password text-field");
		passwordTextField = driver.findElement(By
				.name(passwordTextFieldLocator));


		logger.log("Found. Entering "+password+ " as password");
		passwordTextField.sendKeys(password);

		loginButton = driver.findElement(By.className(loginButtonLocator));


		logger.log("Clicking on the login button.");

		loginButton.click();

	}



	/**
	 * @return HomePage - An instance of homepage.
	 */
	public HomePage loginAsValidUser() throws Exception {

		try {
			logger.log("Trying to log in as a valid user.");
		} catch (NoSuchElementException e) {
			logger.log("Invalid Session encountered.");

		}

		return new HomePage(driver, logger, testDataMap);
	}



	// invalid user log-in service method
	public String loginAsInvalidUser() throws Exception {

		try {

			logger.log("Logging in as an invalid user");
			logger.log("Checking if error message has been generated.");
			invalidDetailsMsg = driver.findElement(By
					.cssSelector(invalidDetailsMsgLocator));


			logger.log("Error message generated.");

		}

		catch (Exception e) {

			pageSnap.capture(e, this.getClass().getSimpleName());
		}

		return (invalidDetailsMsg.getText());

	}



	//empty credentials log-in service method
	public boolean loginWithEmptyCredentials() throws Exception
	{
		boolean requiredTextShown = false;
		try {

			logger.log("Logging in by passing empty user name and password");
			emptyUserMsg = driver.findElement(By
					.cssSelector(emptyUserMsgLocator));

			emptyPasswordMsg = driver.findElement(By
					.cssSelector(emptyPasswordMsgLocator));


			logger.log("Checking if valid error message has been displayed for empty credentials");
			if ((emptyUserMsg.getText().compareTo("Required") == 0)
					&& (emptyPasswordMsg.getText().compareTo("Required") == 0))
			{
				requiredTextShown = true;
				logger.log("Valid error message has been displayed. Moving ahead");
			}

		} catch (Exception e) {

			pageSnap.capture(e, this.getClass().getSimpleName());

		}

		return requiredTextShown;
	}

}	
