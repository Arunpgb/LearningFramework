package LearningSelenium.LearningProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{   	
	public void baseMethod()
	{
    WebDriverManager.chromedriver().setup();
    //System.setProperty("webdriver.chrome.driver","E:\\Tech Java\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
 	driver.get("http://localhost:8080");
    }

	public static void main(String[] args) {
		BaseClass bc=new BaseClass();
		bc.baseMethod();
		
	}
	}


 
 