package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignupEx {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);// should be given only once in the code

		// Step1: Signup into facebook page
		WebElement SignUpBtn = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		SignUpBtn.click();
		Thread.sleep(2000); // make sure to give some delay here

		// Step2: Add the firstname into the page
		WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));

		// Step3: Add the lasttname into the page
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));

		// Step4: Add the emailID into the page
		WebElement emailaddress = driver.findElement(By.xpath("//input[@name='reg_email__']"));

		// Step5: Add the password into the page
		WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));


		firstname.sendKeys("Priyanka");
		lastname.sendKeys("Mehta");
		emailaddress.sendKeys("Priyanka@gmail.com");
		password.sendKeys("abc@234567");

		// Step6: Add the birthday into the page
		WebElement Day = driver.findElement(By.name("birthday_day"));		
		Select bday = new Select(Day); // Here Select class is used for Dropdown and an object is required to be created fr it
		bday.selectByVisibleText("24");

		//finding the list of days dropdown - 1st method by using getOptions() class 
		//		List<WebElement> Days = bday.getOptions();		
		//		for(WebElement Element : Days) {
		//			System.out.println(Element.getText());
		//		}
		//		
		// Step7: Add the birthday month into the page
		WebElement Month = driver.findElement(By.name("birthday_month"));		
		Select bmonth = new Select(Month);
		bmonth.selectByVisibleText("Mar");

		System.out.println("The selected motnh is :" + bmonth.getFirstSelectedOption().getText());
		// use the selected value //select[@name='birthday_month']/option[@selected='1']

		//finding the list of months dropdown -- 1st method by using getOptions() class 
		//		List<WebElement> Months = bmonth.getOptions();
		//		
		//		for(WebElement Element : Months) {
		//			System.out.println(Element.getText());
		//		}

		// Step8: Add the birthday year into the page
		WebElement Year = driver.findElement(By.name("birthday_year"));		
		Select byear = new Select(Year);
		byear.selectByVisibleText("2022");

		//finding the list of years dropdown -- 1st method by using getOptions() class 
		//				List<WebElement> years = byear.getOptions();
		//				
		//				for(WebElement Element : years) {
		//					System.out.println(Element.getText());
		//				}

		//2nd method without the use of getOptions

		List<WebElement> Allyears = driver.findElements(By.xpath("//select[@name ='birthday_year']/option"));

		for(WebElement Elem:Allyears) {
			System.out.println(Elem.getText());
		}


		//		WebElement Female = driver.findElement(By.xpath("//input[@type ='radio'and @value ='1']"));
		//		Female.click();
		//		

		String Gender = "Female";
//
//		WebElement Female = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
//		WebElement Male = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
//		WebElement Other = driver.findElement(By.xpath("//input[@type='radio' and @value='-1']"));
//
//		if(Gender.equals("Female")) {
//			Female.click();
//		}else if(Gender.equals("Male")) {
//			Male.click();
//		}else {
//			Other.click();
//		}
		
		// this is a dynamic xpath here we use the Gender , hence thats why String Gender is created
		String Xpath = "//label[text()='" +Gender+"']//following-sibling::input";
		String newxpath = Xpath.replace("Placeholder", Gender);
		WebElement GenderRadiobtn = driver.findElement(By.xpath(newxpath));
		GenderRadiobtn.click();
		
		// Step9: add driver close
			driver.close();

	}

}
