package SeleniumMavenProj.SeleniumCodingChallenges;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bootstrap_dropown {
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // nav-link-accountList

		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.findElement(By.id("menu1")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> droplist = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
		for (WebElement btstrp : droplist) {
			System.out.println(btstrp.getText());

		}

		driver.quit();
	}
}