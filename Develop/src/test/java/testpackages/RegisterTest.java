package testpackages;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import JavaMain.BaseClass;
import JavaMain.Home;
import JavaMain.Registration;

public class RegisterTest extends BaseClass {

	Home lp;
	Registration reg;

	public RegisterTest() throws IOException {
		super();
	}

	@BeforeSuite
	public void Beforesuite() {

	}

	@Test
	public void Automate() throws IOException, InterruptedException {
		lp.pagereg();
		reg.passDatas();
	}

	@BeforeMethod
	public void Fireon() throws IOException {
		initialization();
		lp = new Home();
		reg = new Registration();
	}

	@AfterMethod
	public void Teardown() {
		driver.quit();

	}

}
