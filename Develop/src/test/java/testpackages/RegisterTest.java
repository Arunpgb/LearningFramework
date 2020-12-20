package testpackages;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
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

	@BeforeSuite
	public void Beforesuite() {
		ExtentManager.setExtent();
			}

	@Test
	public void Automate() throws IOException, InterruptedException {
		lp.pagereg();
		reg.passDatas();
	}

	@Test
	public void TestPass()
	{
		Assertion.markPass("Test Pass");
		ExtentManager.test.info("Test Pass");
	}
	
	@Test
	public void TestFail()
	{
		Assertion.markFail("Test Fail");
		ExtentManager.test.info("Test Fail");
	}
	@BeforeMethod
	public void Fireon() throws IOException {
		initialization();
		lp = new Home();
		reg = new Registration();
	}

	@AfterClass
	public void Teardown() {
		driver.quit();

	}
	
	@AfterSuite
	public void Aftersuite() {
		ExtentManager.endReport();
			}
	

}
