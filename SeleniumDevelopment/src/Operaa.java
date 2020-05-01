import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Operaa {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.opera.driver","‪E:\\Tech Java\\operadriver_win64\\operadriver.exe");
		  WebDriver driver=new OperaDriver();
		  Thread.sleep(5000);
		  driver.get("https://facebook.com");
		  driver.quit();
	}

}
