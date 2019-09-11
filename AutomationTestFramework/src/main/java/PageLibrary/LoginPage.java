package PageLibrary;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import TestBase.BaseClass;
import Utility.Util;

public class LoginPage extends BaseClass {
//	private static WebDriver driver;
//	Properties configProperties, pageObjects;
//
//	public LoginPage(WebDriver driver, Properties configProperties,
//			Properties pageObjects) {
//		this.driver = super.driver;
//		this.configProperties = super.configProperties;
//		this.pageObjects = super.pageObjects;
//	}

	public DashboardPage performLogin(String username, String password) {
		Util.enterText("txtUsername", username);
		Util.enterText("txtPassword", password);
		return new DashboardPage();
	}
}
