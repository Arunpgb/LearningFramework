import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;

public class Chromer {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
  System.setProperty("webdriver.chrome.driver","E:\\Tech Java\\chromedriver.exe");
  WebDriver driver=new ChromeDriver();
  driver.manage().window().maximize();
  //Thread.sleep(5000);
 // driver.get("https://facebook.com");
  Thread.sleep(5000);
  driver.get("http://the-internet.herokuapp.com/dropdown");
   //driver.switchTo().
  Thread.sleep(5000);
  WebElement dropdown=driver.findElement(By.id("dropdown"));
  //Select lists=new Select(dropdown);
  //lists.selectByIndex(1);
  //fn_Select(dropdown, 1);
  Select selObj=new Select(dropdown);
  //selObj.selectByIndex(IndexValue);
	List<WebElement> li=selObj.getOptions();
	for(WebElement name: li){
		System.out.println(name.getText());			
	}	
  Thread.sleep(5000);
  driver.quit();
  
	}
	
	public static void fn_Select(WebElement WE, int IndexValue){
		Select selObj=new Select(WE);
		System.out.println(selObj.getFirstSelectedOption());
		selObj.selectByIndex(IndexValue);
		List<WebElement> li=selObj.getOptions();
		//System.out.println(li.size());
		//System.out.println(li.get(0).isEnabled());
		//System.out.println(li.get(1).getText());
		//java.util.Iterator<WebElement> it=li.iterator();
		
		}


}
