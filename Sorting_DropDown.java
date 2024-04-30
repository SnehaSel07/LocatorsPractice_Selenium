package SeleniumMavenProj.SeleniumCodingChallenges;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sorting_DropDown {

	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // nav-link-accountList

		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.findElement(By.id("menu1")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> droplist = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));

		ArrayList ogList = new ArrayList(); // Original List
		ArrayList tempList = new ArrayList();// Temp List

		for (WebElement options : droplist) {
			ogList.add(options.getText());
			tempList.add(options.getText());

		}

		System.out.println("oglist" + ogList);
		Collections.sort(tempList); // sorting tempList
		System.out.println("after sorted templist" + tempList);

		// Check to compare both list if sorted or not.
		if (ogList.equals(tempList)) {
			System.out.println("Dropdown is in sorted manner.");

		} else {
			System.out.println("Dropdown is in un-sorted manner.");

		}

		driver.quit();
	}
}