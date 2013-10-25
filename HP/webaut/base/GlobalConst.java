package HP.webaut.base;

import HP.webaut.utils.PropReader;


/**
 * @author santosh
 *
 */
public class GlobalConst {


		public static final String APP_PROPERTIES = "C:\\Users\\Santosh\\workspace\\Selenium_Automation\\app.properties";
		public static final String TESTDATASET1 = "C:\\Users\\Santosh\\workspace\\Selenium_Automation\\testdata\\testDataSet1.properties";
	    public static final String SCENARIODATAXML = "C:\\Users\\Santosh\\workspace\\Selenium_Automation\\testdata\\scenariodata_dev.xml";
		public static final String FIREFOX_DRIVER = "webdriver.Firefox.driver";
	//	public static final String FIREFOX_DRIVER_PATH = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
	//	public static final String MUTT_PATH = "";
	//	public static final String SEND_MAIL_PATH = "";
	//	public static final String MAIL_PATH = "";
		public static final String FIREFOX_INSTALL_PATH = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
		public static final String SCREENSHOTS_PATH = "C:\\Users\\Santosh\\workspace\\Selenium_Automation\\Reports\\Screenshots";
		public static boolean RUNFROMANT = false;

		public static final String CONNECTION_TYPE;
	    public static final String BASE_URL;  
	    public static final String LOGIN_URL;
	    public static final String USERSCREEN_URL;
	    public static final String DEVICESCREEN_URL;
	    public static final String DEVICEINFO_URL;

	    public static final String ADDUSER_URL;
	    public static final boolean SCREEN_RECORD;
	    

	    
	    
	    static {
	    	
	    	/*Properties p;
	    	p = new Properties();
	    	try {
				p.load(new FileInputStream(APP_PROPERTIES));
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}*/
	    	
	    	PropReader p = new PropReader(GlobalConst.APP_PROPERTIES);
	    	
	    	BASE_URL = p.get("BASE_URL");
	    	CONNECTION_TYPE = p.get("CONNECTION_TYPE");

			LOGIN_URL = CONNECTION_TYPE + BASE_URL + p.get("LOGIN");
			USERSCREEN_URL = CONNECTION_TYPE + BASE_URL + p.get("HOME");
			DEVICESCREEN_URL = CONNECTION_TYPE + BASE_URL + p.get("DEVICE");
			DEVICEINFO_URL = CONNECTION_TYPE + BASE_URL + p.get("DEVICEINFO");
			ADDUSER_URL = CONNECTION_TYPE + BASE_URL + p.get("ADDUSER");
	        SCREEN_RECORD = Boolean.parseBoolean(p.get("SCREENRECORD"));

	    }
		
	}


