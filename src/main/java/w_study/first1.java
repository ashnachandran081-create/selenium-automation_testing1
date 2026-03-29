package w_study;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class first1 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("i am back again");
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		Thread.sleep(1000);
		driver.close();
	}

}
