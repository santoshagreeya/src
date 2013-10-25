package testngant.webdriver.src;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class HpMdmLogin {

	WebDriver driver;
	Properties allProps;
	WebElement loginControl;

	@Test(groups={"init"})
	public void openURL() {
		System.setProperty("webdriver.Firefox.driver",
				"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		allProps = new Properties();
		try {

			allProps.load(new FileInputStream(
					"D:\\HP\\Automation\\myproperties.properties"));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(allProps.getProperty("url"));

	}

	@AfterTest
	public void closeConnection() throws Exception {

		
		Thread.sleep(5000);
		WebElement LogoutMenu = driver.findElement(By.xpath(allProps.getProperty("logoutDropMenu")));
		LogoutMenu.click();
		WebElement LogoutControl = driver.findElement(By.xpath(allProps.getProperty("logoutLinkLocator")));
		LogoutControl.click();
		/*	WebElement logoutDropMenu = driver.findElement(By
				.xpath(".//*[@id='header']/div/div/div/div/a/span[1]"));
		logoutDropMenu.click();
		Thread.sleep(5000);

		WebElement logout = driver.findElement(By
				.xpath(".//*[@id='header']/div/div/div/div/ul/li[2]/a"));
		logout.click();*/
		driver.close();
		System.out.println("Database connection closed");
	}

	@Test(dependsOnGroups={"init"})
	public void testLogin() {

		loginControl = driver.findElement(By.name(allProps.getProperty("usernameTextFieldLocator")));

		loginControl.sendKeys(allProps.getProperty("username"));
		loginControl = driver.findElement(By.name(allProps.getProperty("passwordTextFieldLocator")));
		loginControl.sendKeys(allProps.getProperty("password"));
		try {
			loginControl = driver.findElement(By.className(allProps.getProperty("loginbuttonLocator")));
			if (loginControl.isDisplayed())
				loginControl.click();
			System.out.println("login Sucessfully");


		} catch (NoSuchElementException e) {

			System.out.println("login button not found");
		}

	}

	/*@Test(dependsOnGroups={"init"})
	public void testUserScreen() {
		long end = System.currentTimeMillis() + 5000;
		while (System.currentTimeMillis() < end) {
			WebElement resultsDiv = driver.findElement(By
					.partialLinkText(allProps.getProperty("addUserLocator")));


			// If Add User option is displayed, App should click on the option

			if (resultsDiv.isDisplayed()) {
				resultsDiv.click();
				System.out.println("User Screen option is displayed");
				break;
			}
		}
	}*/
}


