package HelperFunctions;

import java.util.Objects;

import org.openqa.selenium.WebElement;
import JavaMain.BaseClass;
import LogHelper.Loghelp;

public class BasicHelper extends BaseClass {
	WaitHelper wait;

	public BasicHelper() {
		Loghelp.info("Basic Helper has been initialized....");
		wait = new WaitHelper();
	}

	public boolean isElementDisplayed(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		wait.WaitForElementVisibleWithPollingTime(element, timeOutInSeconds, pollingEveryInMiliSec);
		try {
			element.isDisplayed();
			Loghelp.info("Element is Displayed", element);
			return true;

		} catch (Exception e) {
			Loghelp.info("Element is not Displayed the cause is: " + e.getMessage());
			return false;
		}
	}

	public boolean isElementEnabled(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		wait.WaitForElementVisibleWithPollingTime(element, timeOutInSeconds, pollingEveryInMiliSec);
		try {
			element.isDisplayed();
			Loghelp.info("Element is Enabled", element);
			return true;

		} catch (Exception e) {
			Loghelp.info("Element is not enabled and  the cause is: " + e.getMessage());
			return false;
		}
	}

	public String getElementText(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		wait.WaitForElementVisibleWithPollingTime(element, timeOutInSeconds, pollingEveryInMiliSec);
		try {
			if (element.isDisplayed()) {
				Loghelp.info("Element Text is fetched", element);
				return element.getText();
			}

		} catch (Exception e) {
			Loghelp.info("Element's Text not able to fetch and  the cause is: " + e.getMessage());
		}
		return null;
	}

	public void enterdatainField(WebElement element, String data, int timeOutInSeconds, int pollingEveryInMiliSec) {
		wait.WaitForElementVisibleWithPollingTime(element, timeOutInSeconds, pollingEveryInMiliSec);
		try {
			if (element.isDisplayed() == true && element.isEnabled() == true && Objects.nonNull(data)) {
				wait.waitForElement(element, timeOutInSeconds);
				element.click();
				element.clear();
				element.sendKeys(data);
				Loghelp.info("Data is  entered in the Field", element);
			}

		} catch (Exception e) {
			Loghelp.info("Failed to enter the Data in the Field: " + element.getText() + " " + e.getMessage());
		}
	}

	public void cleardata(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		wait.WaitForElementVisibleWithPollingTime(element, timeOutInSeconds, pollingEveryInMiliSec);
		try {
			if (element.isDisplayed() == true && element.isEnabled() == true) {
				wait.waitForElement(element, timeOutInSeconds);
				element.click();
				element.clear();
				Loghelp.info("Data is cleared from the Field", element);
			}

		} catch (Exception e) {
			Loghelp.info("Failed to clear the Data in the Field: " + element.getText() + " " + e.getMessage());
		}
	}

	public void clickon(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec) {
		wait.WaitForElementVisibleWithPollingTime(element, timeOutInSeconds, pollingEveryInMiliSec);
		try {
			if (element.isDisplayed() == true && element.isEnabled() == true) {
				wait.waitForElement(element, timeOutInSeconds);
				element.click();
				Loghelp.info("is clicked", element);
			}

		} catch (Exception e) {
			Loghelp.info("Failed to enter the Data in the Field: " + element.getText() + " " + e.getMessage());
		}
	}

}
