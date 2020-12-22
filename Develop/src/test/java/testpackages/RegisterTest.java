package testpackages;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import HelperFunctions.AssertionHelper;
import JavaMain.BaseClass;
import JavaMain.Home;
import JavaMain.Registration;
import reportHelper.ExtentManager;

public class RegisterTest extends BaseClass {

	Home lp;
	Registration reg;
	AssertionHelper Assertion;

	public RegisterTest() throws IOException {
		super();
	}

	@Test(priority = 1,enabled=false)
	public void Automate() throws IOException, InterruptedException {
		lp.pagereg();
		reg.passDatas();
	}

	@Test(priority = 2)
	public void TestPass() {
		AssertionHelper.markPass("Test Pass");
		ExtentManager.test.info("Test Pass");
	}

	@Test(priority = 3)
	public void TestFail() {
		AssertionHelper.markFail("Test Fail");
		ExtentManager.test.info("Test Fail");
	}

	@BeforeClass
	public void Fireon() throws IOException {
		initialization();
		lp = new Home();
		reg = new Registration();
	}

	@AfterClass
	public void Teardown() {
		driver.quit();

	}

}
