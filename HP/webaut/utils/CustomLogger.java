package HP.webaut.utils;


import org.testng.Reporter;

/**
 * @author santosh
 *
 */
public class CustomLogger {
	
	public CustomLogger()

	{
		
		System.out.println("Initializing the HP MDM.");
	}
	
	public void log(String message)
	{
		System.out.println(message);
		Reporter.log(message);
	}
	

}