package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement Button1 = driver.findElement(By.id("alertButton"));
		JavascriptExecutor obj =  (JavascriptExecutor) driver; 
		
		Button1.click();
		// here we are taking the Alert class to tell that the driver has a alert after button is clicked
		Alert alert = driver.switchTo().alert();  
		System.out.println(alert.getText());
		alert.accept();
		
		WebElement Button2 = driver.findElement(By.id("confirmButton"));		
		Button2.click();		
		alert = driver.switchTo().alert();  
		System.out.println(alert.getText());
		alert.dismiss();
		
		
		WebElement Button3 = driver.findElement(By.id("promtButton"));
		// Added this below line due to small screen and exception
		obj.executeScript("arguments[0].scrollIntoView();", Button3);
		Button3.click();		
		
		alert = driver.switchTo().alert();  
		System.out.println(alert.getText());		
		alert.sendKeys("Priyanka");
		alert.accept();
	}

}
