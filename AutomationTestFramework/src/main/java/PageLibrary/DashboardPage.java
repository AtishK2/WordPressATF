package PageLibrary;

import TestBase.BaseClass;
import Utility.Util;

public class DashboardPage extends BaseClass {

	
	public boolean validateAllUsers() throws InterruptedException{
		String usersMenu=pageObjects.getProperty("UsersMenu");
		String allUsersMenu=pageObjects.getProperty("AllUsersMenu");
		String lnkUserName=pageObjects.getProperty("lnkUserName");
		String lnkEmail=pageObjects.getProperty("lnkEmail");
		
		Util.clickElement(usersMenu);
		Thread.sleep(1000);
		Util.clickElement(allUsersMenu);
		boolean flag=(Util.findElement(lnkUserName).isDisplayed() && 
				Util.findElement(lnkEmail).isDisplayed());
		return flag;
		
	}
}
