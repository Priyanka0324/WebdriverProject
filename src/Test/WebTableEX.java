package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableEX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		// Listing out all the rows
		List<WebElement> RowsList = driver.findElements(By.xpath("//table[@id ='customers']/tbody/tr"));		 
		System.out.println("Total number of rows are :" + RowsList.size());

		// Listing out all the columns
		List<WebElement> ColumnsList = driver.findElements(By.xpath("//table[@id ='customers']/tbody//th"));
		System.out.println("Total number of Columns are :" + ColumnsList.size());

		//Finding out the data in the 3rd row and 1st column
		WebElement Data = driver.findElement(By.xpath("//table[@id ='customers']/tbody//tr[4]/td[1]"));
		System.out.println("The required data is :" +Data.getText());


		//		for(WebElement RowElm:RowsList) {
		//			List<WebElement> Allcells = RowElm.findElements(By.tagName("td"));
		//			
		//			for(WebElement Cell : Allcells) {
		//				System.out.print(Cell.getText()+ " ");
		//			}
		//			System.out.println();
		//		}

		for (int row = 1 ;row<=RowsList.size();row++) {
			for(int column = 1 ;column<=ColumnsList.size();column++) {
				WebElement cell = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + row + "]/*[" + column + "]"));
				System.out.print(cell.getText() + "\t");
			}
			System.out.println();

			String Company = "Magazzini Alimentari Riuniti";
			
			String Xpath = "//td[text()='" + Company + "']/following-sibling::td[2]";
			WebElement Country = driver.findElement(By.xpath(Xpath));
			System.out.println("The country is " + Country.getText());
			
		}

	}

}
