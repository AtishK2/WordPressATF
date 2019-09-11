package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.BaseClass;

public class Util extends BaseClass {
	private static String directoryLocation = null;
	private static WebDriver driver;
	
	public Util(){
		driver=super.driver;
	}
	public static String getProjectDirectory() {
		return System.getProperty("user.dir");
	}

	public static Properties loadProperties(String file) throws IOException {
		FileInputStream inputStream = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(inputStream);
		System.out.println("Properties extracted from " + file + " are: \n"
				+ properties);
		return properties;
	}
	
	public static WebElement findElement(String element) {
		String locatorType, locatorValue;
		String[] locatorFields = element.split(":");
		locatorType = locatorFields[0];
		locatorValue = locatorFields[1];

		if(locatorType.toLowerCase().equals("id")){
			return driver.findElement(By.id(locatorValue));
		}
		else if(locatorType.toLowerCase().equals("css")){
			return driver.findElement(By.cssSelector(locatorValue));
		}
		else if(locatorType.toLowerCase().equals("name")){ 
			return driver.findElement(By.name(locatorValue));
		}
		else if(locatorType.toLowerCase().equals("linktext")){
			return driver.findElement(By.linkText(locatorValue));
		}
		else if(locatorType.toLowerCase().equals("partiallinktext")){
			return driver.findElement(By.partialLinkText(locatorValue));
		}
		else if(locatorType.toLowerCase().equals("tagname")){
			return driver.findElement(By.tagName(locatorValue));
		}
		else if(locatorType.toLowerCase().equals("xpath")){
			return driver.findElement(By.xpath(locatorValue));
		}
		else{
			System.out
					.println("Invalid locatorType provided in configuration file");
			return null;
		}
	}

	public static void clickElement(String element) {
		findElement(element).click();
	}
	
	public static void enterText(String element, String textToEnter){
		findElement(element).clear();
		findElement(element).sendKeys(textToEnter);
	}

	public static void main(String[] args) throws IOException {
		System.out.println(getProjectDirectory());
		loadProperties(getProjectDirectory()+"\\src\\main\\java\\LocalConfig\\Config.properties");
	}
}
