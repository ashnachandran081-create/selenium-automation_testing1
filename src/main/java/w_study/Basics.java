package w_study;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics {
	
	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://admin-demo.nopcommerce.com/login");
		String title= driver.getTitle();
		System.out.println("Title is: "+title);
				WebElement emailField =  driver.findElement(By.xpath("//input[@value ='admin@yourstore.com']"));
		emailField.clear();
		emailField.sendKeys("admin@yourstore.com");
		
		WebElement passwordField = driver.findElement(By.xpath("//input[@name='Password']"));
		passwordField.clear();
		passwordField.sendKeys("admin");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
		String nameofbutton =loginButton.getText();
		System.out.println(nameofbutton);
		loginButton.click();
		
		
		WebElement userPageText = driver.findElement(By.xpath("//div[@class='content-header']/h1"));
		String textString =  userPageText.getText();
		System.out.println(textString);
		//driver.close();		
		
	}

}
