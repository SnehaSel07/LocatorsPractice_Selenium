package SeleniumMavenProj.SeleniumCodingChallenges;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggest_dropDown {
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // nav-link-accountList

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		// driver.findElement(By.xpath("//button[@jsname='ZUkOIc']")).click();
		driver.findElement(By.xpath("//div/textarea[@class='gLFyf']")).sendKeys("selenium");
		Thread.sleep(3000);
		List<WebElement> autoSuggestDD = driver
				.findElements(By.xpath("//li[@class='sbct PZPZlf']//div[@role='option']//div[1]/span"));
		System.out.println("autosuggestions = " + autoSuggestDD.size());

		for (WebElement autolist : autoSuggestDD) {
			if (autolist.getText().contains("interview")) {
				autolist.click();
				break;
			}
		}

	}

}
