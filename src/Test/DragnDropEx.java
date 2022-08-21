package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragnDropEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement From = driver.findElement(By.xpath("//li[@id='credit2']/a"));
		WebElement To = driver.findElement(By.xpath("//ol[@id=\"bank\"]/li"));
		
		Actions act = new Actions(driver); // Action class is provided by Selenium by which we can do drag&Drop->
		//here we are calling the driver as an Action class constructor 
		
		act.dragAndDrop(From, To).build().perform(); // build & perform is used to perform the activity of mouse
		
		
	}

}
