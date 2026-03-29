package tests;

import javax.swing.border.TitledBorder;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void validLogin() {
		LoginPage loginPage =new LoginPage(driver);
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.submitLogin();
		System.out.println("Login is passed");
		System.out.println("title of the page is: "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
	}
	
	@Test
	public void invalidLogin() {
		LoginPage loginPage =new LoginPage(driver);
		loginPage.enterUsername("invalid@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.submitLogin();
		System.out.println("Login is failed");
		System.out.println("title of the page is: "+driver.getTitle());
		Assert.assertNotEquals("Just a mft...", driver.getTitle());
	}

}
