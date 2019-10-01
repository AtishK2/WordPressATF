package PageLibrary;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import TestBase.BaseClass;
import Utility.Util;

public class LoginPage extends BaseClass {

	public DashboardPage performLogin() {
		String username = configProperties.getProperty("userName");
		String password = configProperties.getProperty("password");
		String txtUserName=pageObjects.getProperty("txtUsername");
		String txtPassword=pageObjects.getProperty("txtPassword");
		String btnLogin=pageObjects.getProperty("btnLogin");
		
		Util.enterText(txtUserName, username);
		Util.enterText(txtPassword, password);
		Util.clickElement(btnLogin);
		return new DashboardPage();
	}
}
