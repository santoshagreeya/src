package HP.pageobjects.home;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import testngant.webdriver.src.LatestHpLogin;

import HP.webaut.base.BasePage;
import HP.webaut.base.GlobalConst;
import HP.webaut.utils.CustomLogger;

public class HomePage extends BasePage  {

	
	
	
	
	
	
	
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
	 * Listings of the services/operations provided by Home page of Praxify Web:
	 * 1. A specific url for home page
	 * 2. A header which contains:
	 *   a. A section to display Add User tab.
	 *   b. A section to display Device info tab.
	 *   c. A section to display Home, Tenants, User, Device, Policies, Logout link.
	 *   d. Name of the user who logs in.
	 *   e. HP Logo.
	 *   * 3. A footer that displays:
	 *   a. © 2013 | HP Cloud 
	 * 
	 * 
	 */

	
	
	/**
	 * Constructor to verify that the page, and possibly critical elements on
	 * the page, were loaded correctly.
	 * @param driverFromTest: an object of ChromeDriver passed either from a test class or another pageobject class where HomePage was instantiated.
	 * @param loggerFromTest: object of CustomLogger
	 * @param testDataMapFromTest: object of test-data Hash-map created in BaseTest and passed from a test class.
	 */
	
	public HomePage(WebDriver driverFromTest, CustomLogger loggerFromTest,
			HashMap<String, String> testDataMapFromTest) {

		super(driverFromTest, loggerFromTest, testDataMapFromTest);

		
		
	/*	homeScreenLinkLocator = testDataMap.get("homeScreenLinkLocator");
		tenantsLinkLocator = testDataMap.get("tenantsLinkLocator");
		userLinkLocator = testDataMap.get("userScreenLinkLocator");
		deviceLinkLocator = testDataMap.get("deviceLinkLocator");
		policiesLinkLocator = testDataMap.get("policiesLinkLocator");
		emailEditfieldLocator = testDataMap.get("emailEditfieldLocator");
		logoutLinkLocator = testDataMap.get("logoutLinkLocator");
		addUserLinkocator = testDataMap.get("addUserLinkLocator");
		addtogroupLinkLocator = testDataMap.get("addtogroupLinkLocator");
		deleteuserLinkLocator = testDataMap.get("deleteuserLinkLocator");*/
		usernameOnHeaderLocator = testDataMap.get("usernameOnHeaderLocator");
		
		
		

		
		
		if (!driver.getCurrentUrl().equals(GlobalConst.USERSCREEN_URL)) {

			throw new IllegalStateException(
					"This is not the home page. Current page" + "is"
							+ driver.getCurrentUrl());
		}

	}// end-of-constructor
	
	
	
	public LatestHpLogin logout() throws Exception {

		try {

			checkLoaderGone();
			logger.log("Logging out of the application");
			logoutLink = driver.findElement(By.id(logoutLinkLocator));
			
			logoutLink.click();
		} catch (Exception e) {

			pageSnap.capture(e, this.getClass().getSimpleName());
		}

		logger.log("Logged out of the application successfully");
		return new LatestHpLogin(driver, logger, testDataMap);

	}

	/*
	 * 
	 * End of method for admin singin 
	 */


	}

