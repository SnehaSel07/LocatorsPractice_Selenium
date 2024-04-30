package SeleniumMavenProj.SeleniumCodingChallenges;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClass_dropDown {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Sneha
		// Chindarkar\\Selenium_Tutorial\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize(); // nav-link-accountList

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

		driver.findElement(By.id("justAnInputBox")).click();

		selectCheckBoxList(driver, "choice 1", "choice 2 3");
		// selectCheckBoxList(driver, "all");
	}

	public static void selectCheckBoxList(WebDriver driver, String... values) {
		List<WebElement> checklist = driver.findElements(By.className("comboTreeItemTitle"));
		if (!values[0].equalsIgnoreCase("all")) {
			for (WebElement list : checklist) {
				String text = list.getText();
				for (String val : values) {

					if (text.equals(val)) {
						list.click();
						break;
					}

				}

			}

		} else {

			for (WebElement list : checklist)
				list.click();
		}
	}

}
