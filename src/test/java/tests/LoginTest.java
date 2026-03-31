package tests;

import java.io.IOException;

import javax.swing.border.TitledBorder;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	@DataProvider(name="logindata")
	public Object[][] getLoginData() throws IOException{
		String filePath = System.getProperty("user.dir") + "/test_data/TestData.xlsx";
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount =ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount-1][2];
		
		for(int i=1 ; i<rowCount ; i++ ) {
			data[i-1][0]=ExcelUtils.getCellData(i, 0);
			data[i-1][1]=ExcelUtils.getCellData(i, 1);
		}
		ExcelUtils.closeExcel();
		return data;
	}

	@Test (dataProvider = "logindata")
	public void validLogin(String username , String password) {
		test = extent.createTest("Login test");
		LoginPage loginPage = new LoginPage(driver);
		Log.info("Giving user name");
		test.info("adding credentails");
		loginPage.enterUsername(username);
		Log.info("Giving password");
		loginPage.enterPassword(password);
		test.info("submitting the credentails");
		Log.info("Submitting");
		loginPage.submitLogin();
		System.out.println("Login is passed");
		System.out.println("title of the page is: " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		Log.info("Login is passed");
		test.info("test is passed");
	}

	@Test
	public void loginValid() {
		test = ExtentReportManager.createTest("Login test");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clicklogin("admin@yourstore.com", "admin");
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		Log.info("Login is passed");
		test.info("test is passed");
	}

	@Test
	public void invalidLogin() {
		test = ExtentReportManager.createTest("Login invalid test");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("invalid@yourstore.com");
		loginPage.enterPassword("admin");
		test.info("Submitting");
		loginPage.submitLogin();
		System.out.println("Login is failed");
		System.out.println("title of the page is: " + driver.getTitle());
		Assert.assertNotEquals("Just a moment1...", driver.getTitle());
		test.info("test is passed: invalid test");
	}

}
