package SeleniumMavenProj.SeleniumCodingChallenges;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicElements {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String population_xpath = "//div[@class='maincounter-number']/span[@class='rts-counter']";
		String todays_pop_xpath = "//div[text()='Today']//parent::div//span[@class='rts-counter']";
		String thisyear_pop_xapth = "//div[text()='This year']//parent::div//span[@class='rts-counter']";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sneha Chindarkar\\Selenium_Tutorial\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/world-population/");

		// worldPop(population_xpath);
		//worldPop(todays_pop_xpath);
		worldPop(thisyear_pop_xapth);
	}

	public static void worldPop(String locator) {
		while (true) {
			List<WebElement> poplist = driver.findElements(By.xpath(locator));

			for (WebElement e : poplist) {
				System.out.println(e.getText());

			}
		}

	}

}
