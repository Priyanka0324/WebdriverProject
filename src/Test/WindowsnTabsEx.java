package Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsnTabsEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://demoqa.com/browser-windows");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		String ParentWin = driver.getWindowHandle();
		System.out.println("Before Clicking Tab button the win is " + ParentWin);
		
		WebElement Tab = driver.findElement(By.id("tabButton"));
		Tab.click();
		
		Set<String> Allwins = driver.getWindowHandles();
		for(String win : Allwins) {
			System.out.println(win);
			// switching to the child window with if condtn
			if(!win.equals(ParentWin)) {
				driver.switchTo().window(win);
			}
		}
		
		WebElement childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println(childHeader.getText());
		
		driver.switchTo().window(ParentWin);
		
		WebElement Winbutton = driver.findElement(By.id("windowButton"));
		Winbutton.click();
		
		driver.quit();
		
		
	}

}
