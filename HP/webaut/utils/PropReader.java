package HP.webaut.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import HP.webaut.base.GlobalConst;


public class PropReader {

	private Properties globPropReader;
	
	private InputStream inputStream;
	
	
	public PropReader(String propFile){
		
		
		globPropReader = new Properties();
		
		
				try {
					
					if(GlobalConst.RUNFROMANT == true)
					 inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propFile);
					
					else
						inputStream = new FileInputStream(propFile);
					 
                     globPropReader.load(inputStream);

				} catch (FileNotFoundException e) {
		            
					System.out.println("Problem with loading properties file: "+e.getMessage());
					
				} catch (IOException e) {
					System.out.println("Problem with loading properties file: "+e.getMessage());
				}
	}
	
	
	public String get(String propKey)
	{
		return(globPropReader.getProperty(propKey));
	}
}
