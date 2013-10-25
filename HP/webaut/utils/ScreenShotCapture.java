package HP.webaut.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotCapture {

	private WebDriver driver;
	private String screenshotsPath;
	private String absFilePath;
	private CustomLogger logger;

	public ScreenShotCapture(WebDriver driver, String screenshotsPath, CustomLogger logger) {
		this.driver = driver;
		this.screenshotsPath = screenshotsPath;
		this.logger = logger;

	}

	private String getCurrentTimeStamp() {
		DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_hhmmss");
		Calendar now = Calendar.getInstance();
		System.out.println("Returning timestamp");
		return (dateFormat.format(now.getTime()));

	}

	public void capture(Exception e, String pageName) throws Exception {
		
		
		logger.log("Something seems to be wrong. Capturing a screenshot");
		absFilePath = screenshotsPath +"("+pageName+")" + "_"+ getCurrentTimeStamp()
				+ ".png";
		File screenShot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot, new File(absFilePath));
		} catch (IOException ioe) {
			throw new RuntimeException(ioe.getMessage(), ioe);
		}
		
		logger.log("Throwing an exception now.");
		throw e;

	}

}
