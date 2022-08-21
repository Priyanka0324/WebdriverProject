package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLoginEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//Step1 : enter the userName for facebook login
//		WebElement UserName = driver.findElement(By.xpath("//input[@name='email']"));
		
		//by Css selector 
		WebElement UserNamecss = driver.findElement(By.cssSelector("input#email"));
		
		//Step2 : enter the password for facebook login		
		WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		
		
		//Step3 : Click on login button to enter into the facebook login page
		WebElement LoginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		
		UserNamecss.sendKeys("Priyanka@gmail.com");
		Password.sendKeys("abcd12345");
		LoginButton.click();
		
		driver.close();

	}

}
