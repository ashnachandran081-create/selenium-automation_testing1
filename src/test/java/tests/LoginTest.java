package tests;

import javax.swing.border.TitledBorder;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest{
	
	@Test
	public void validLogin() {
		test =ExtentReportManager.createTest("Login test");
		LoginPage loginPage =new LoginPage(driver);
		Log.info("Giving user name");
		test.info("adding credentails");
		loginPage.enterUsername("admin@yourstore.com");
		Log.info("Giving password");
		loginPage.enterPassword("admin");
		test.info("submitting the credentails");
		Log.info("Submitting");
		loginPage.submitLogin();
		System.out.println("Login is passed");
		System.out.println("title of the page is: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		Log.info("Login is passed");
		test.info("test is passed");
	}
	@Test
	public void loginValid() {
		test =ExtentReportManager.createTest("Login test");
		LoginPage loginPage =new LoginPage(driver);
		loginPage.clicklogin("admin@yourstore.com", "admin");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		Log.info("Login is passed");
		test.info("test is passed");
	}
	@Test
	public void invalidLogin() {
		test =ExtentReportManager.createTest("Login invalid test");
		LoginPage loginPage =new LoginPage(driver);
		loginPage.enterUsername("invalid@yourstore.com");
		loginPage.enterPassword("admin");
		test.info("Submitting");
		loginPage.submitLogin();
		System.out.println("Login is failed");
		System.out.println("title of the page is: "+driver.getTitle());
		Assert.assertNotEquals("Just a moment1...", driver.getTitle());
		test.info("test is passed: invalid test");
	}

}
