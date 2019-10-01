package TestBase;

import static Utility.Util.getProjectDirectory;
import static Utility.Util.loadProperties;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	protected static Properties configProperties = null;
	protected static Properties pageObjects = null;
	protected static WebDriver driver = null;
	
	public BaseClass(){
		
	}

	public static WebDriver initializeBrowser() throws IOException {
		configProperties = loadProperties(getProjectDirectory()
				+ "\\src\\main\\java\\LocalConfig\\Config.properties");

		pageObjects=loadProperties(getProjectDirectory()
				+ "\\src\\main\\java\\PageLibrary\\PageObjects.properties");
		driver = openBrowser(configProperties);
		driver.get(configProperties.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(configProperties.getProperty("implicit_wait")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(configProperties.getProperty("page_load_timeout")), TimeUnit.SECONDS);
		return driver;
	}

	public static WebDriver openBrowser(Properties properties) {
		String browserName = properties.getProperty("browser");
		String browserPath = null;
		if (browserName.toLowerCase().equals("chrome")) {

			browserPath = getProjectDirectory()
					+ properties.getProperty("chrome_path");
			System.setProperty("webdriver.chrome.driver", browserPath);
			WebDriver drivers = new ChromeDriver();
			return drivers;

		} else {
			System.out.println("invalid browser property specified");
			return null;
		}

	}

}
