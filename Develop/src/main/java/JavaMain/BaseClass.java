package JavaMain;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utility.PropertyHelper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	// public static ThreadLocal<WebDriver> driver;
	public static WebDriver driver;

	// public static EventFiringWebDriver e_driver;
	// public static WebDriverEventListener eventListener;

	public BaseClass() throws Exception {
		// PropertyConfigurator.configure("D:\\Arun\\Arun_2020\\Automation_new\\Work\\Develop\\src\\main\\resources\\log4j.properties");

		// ** Initialize the Log4j Configurations
		PropertyConfigurator.configure(PropertyHelper.getPropertyvalue("LogConfig"));
	}

	public static void initialization() throws Exception {

		String browserName = PropertyHelper.getPropertyvalue("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
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
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(PropertyHelper.getPropertyvalue("pageloadtime")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertyHelper.getPropertyvalue("implicittime")),
				TimeUnit.SECONDS);
		driver.get(PropertyHelper.getPropertyvalue("url"));

	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver;
	}

	public String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename
				+ "_" + dateName + ".png";
		return destination;
	}
}
