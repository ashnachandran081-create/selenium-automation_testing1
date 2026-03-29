package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	private By email_field = By.xpath("//input[@value ='admin@yourstore.com']");
	private By password_fieldBy = By.xpath("//input[@name='Password']");
	private By login_button = By.xpath("//button[@class='button-1 login-button']");
	
	public LoginPage (WebDriver driver) {                  //constructor
		this.driver =driver;
	}
	
	public void enterUsername(String emailvalue) {
		driver.findElement(email_field).clear();
		driver.findElement(email_field).sendKeys(emailvalue);
	}
	
	public void enterPassword(String passwordValue) {
		driver.findElement(password_fieldBy).clear();
		driver.findElement(password_fieldBy).sendKeys(passwordValue);	
	}
	
	public void submitLogin() {
		driver.findElement(login_button).click();
	}

}
