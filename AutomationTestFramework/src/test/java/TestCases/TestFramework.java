package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import PageLibrary.DashboardPage;
import PageLibrary.LoginPage;
import TestBase.BaseClass;

public class TestFramework extends BaseClass {

	
	private LoginPage loginPage;
	private DashboardPage dashboardPage;

	public TestFramework() {
	}

	@BeforeMethod
	public void setUp() throws IOException {
		driver = BaseClass.initializeBrowser();
		loginPage = new LoginPage();
	}

	@Test
	public void LoginTest() {
		dashboardPage = loginPage.performLogin();
		Assert.assertTrue(driver.getTitle().contains("Cleanboard"),"Test failed since the actual title of window is "+driver.getTitle());
	}

//	@Test
	public void ValidateAllUsersTest() throws InterruptedException {
		dashboardPage = loginPage.performLogin();
		Assert.assertTrue(dashboardPage.validateAllUsers(),"Email or Username not present on Users page");
	}
	

	@AfterMethod
	public void tearDown(ITestResult result) throws InterruptedException, IOException {
		Thread.sleep(500);
		
		if(result.getStatus()==ITestResult.FAILURE) {
			String filePath=Utility.Util.captureScreenshotInCaseOfError(result);
			
		}
		
//		driver.close();
		loginPage = null;
		dashboardPage = null;
	}
}
