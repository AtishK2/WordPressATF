package TestCases;

import java.io.IOException;
import java.util.Properties;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import PageLibrary.DashboardPage;
import PageLibrary.LoginPage;
import TestBase.BaseClass;

public class TestFramework extends BaseClass {
	
	private static WebDriver driver;
	private static Properties configProperties, pageObjects;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	
	public TestFramework(){
		this.driver = super.driver;
		this.configProperties = super.configProperties;
		this.pageObjects = super.pageObjects;
	}
	
	@Before
	public void setUp() throws IOException{
		driver=BaseClass.initializeBrowser();
		System.out.println("Done with before");
	}
	
	@Test
	public void Login() {
		System.out.println("Inside Login");
		loginPage=new LoginPage();
		String userName=pageObjects.getProperty("txtUsername");
		String password=pageObjects.getProperty("txtPassword");
		dashboardPage=loginPage.performLogin(userName, password);
		Assert.assertTrue(driver.getTitle().contains("Dashboard"));
		
	}

}
