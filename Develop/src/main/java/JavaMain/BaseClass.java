package JavaMain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	// public static EventFiringWebDriver e_driver;
	// public static WebDriverEventListener eventListener;
    
	public WebDriver driver() {
		return driver;
	}
	public BaseClass() {
		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream(
					"D:\\Arun\\Arun_2020\\Automation_new\\Work\\Develop\\src\\main\\java\\Utility\\BaseUtility.properties");

			// FileInputStream ip = new FileInputStream(".\\BaseUtility.properties");
			prop.load(ip);
			  PropertyConfigurator.configure("D:\\Arun\\Arun_2020\\Automation_new\\Work\\Develop\\src\\main\\resources\\log4j.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {

			// System.setProperty("webdriver.chrome.driver", "‪‪‪‪E:\\Tech
			// Java\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		// eventListener = new WebSocketListener();
		// e_driver.register(ErrorListener);
		// driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		/*
		 * driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,
		 * TimeUnit.SECONDS);
		 * driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
		 * TimeUnit.SECONDS);
		 */

		driver.get(prop.getProperty("url"));

	}
}
