package browserFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

	@Override
	void createDriver() {
		// ADD SERVICE AND NEW DRIVER
		System.setProperty("webdriver.chrome.driver", ".\\libraries\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);	
	}

}