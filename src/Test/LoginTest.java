package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		// Step1. Click on login link
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));  // findelement returns a single webelement
		LoginLink.click();
		
		// Step2. Enter userID
		WebElement userID = driver.findElement(By.name("user_login"));
		userID.sendKeys("piya@gmail.com");
		
		// Step3. Enter pswd
		WebElement Pswd = driver.findElement(By.id("password"));
		Pswd.sendKeys("pomKabcde1");
		
		// Step4. click on the checkbox
		WebElement Checkbox = driver.findElement(By.className("rememberMe"));
		Checkbox.click();
		
		// Step5. Click on login button
		WebElement Login = driver.findElement(By.name("btn_login"));
		Login.click();
		
		// step6. Validate the error message
		WebElement Error = driver.findElement(By.id("msg_box"));
		
		String ActualError = Error.getText();
		String ExpError = "The email or password you have entered is invalid.";
		
		if(ActualError.equals(ExpError)) {
			System.out.println("TC is Passed");			
		}
		else {
			System.out.println("TC is failed");
		}
		
		//step7. Finding all hyperlinks and storing in a list with tag as "a-> anchor tag"
		List<WebElement> Links = driver.findElements(By.tagName("a"));	// whereas findelements returns list of webelements
		System.out.println("The total num of links are: " +Links.size());
		
		for (int index=0;index<Links.size();index++) {
			
			System.out.println(Links.get(index).getAttribute("href"));
		}
		
		//step8. Close the browser
		driver.close();
	}

}
