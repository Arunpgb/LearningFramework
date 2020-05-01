import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.chrome.driver","E:\\Tech Java\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.jabong.com/");
		  Thread.sleep(3000);
	      String attri=driver.findElement(By.id("search")).getAttribute("placeholder");
	      System.out.println(attri);
	      driver.quit();
	}

}
