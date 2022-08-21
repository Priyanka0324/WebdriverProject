package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		WebElement Target = driver.findElement(By.xpath("//h2[text()='HTML Table Tags']"));

		JavascriptExecutor obj =  (JavascriptExecutor) driver; // here we are assigning the driver to javascriptexecutor
		
		// scrolling to the target - if we have to go to any element on the Html page 
		obj.executeScript("arguments[0].scrollIntoView();", Target);
//
//		//scrollDown
		obj.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//
//		//scrollUp
		obj.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		
		// By action class to perform any keyboard activity ex: downArrowkey,
		Actions act = new Actions(driver);
		
		//PageDown keyboard function
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		//Multiple keyboard like CTRL+END
		act.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).build().perform();




	}

}
