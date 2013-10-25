package HP.webaut.base;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import HP.webaut.utils.CustomLogger;
import HP.webaut.utils.ScreenShotCapture;
//Custom package imports


public class BasePage {
	
	/**
	 * 
	 * This is a base class for all PageObject classes.
	 */
	
	protected static WebDriver driver;
	protected static CustomLogger logger;
	protected static HashMap<String, String> testDataMap;
	protected ScreenShotCapture pageSnap;
	

	protected WebElement usernameOnHeader;
	protected String usernameOnHeaderLocator;
	protected HashMap<String, WebElement> webElementMap;
	
	
	protected BasePage(WebDriver driver, CustomLogger logger,HashMap<String, String> testDataMap) 
	{
		BasePage.driver = driver;
		BasePage.logger = logger;
		BasePage.testDataMap = testDataMap;
		
		pageSnap = new ScreenShotCapture(BasePage.driver, GlobalConst.SCREENSHOTS_PATH, this.logger);
		webElementMap = new HashMap<String, WebElement>();

		
		if(driver == null)
		{
		System.out.println("Driver is null");
	
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		usernameOnHeaderLocator = BasePage.testDataMap.get("usernameOnHeaderLocator");
		
		

	}

}
