package com.training.automation.testscripts;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.automation.base.MobileTestBase;

public class SwagLogin extends MobileTestBase {

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() throws IOException {

		return new Object[][] { { "standard_user", "secret_sauce" } };

	}

	@Test(dataProvider = "data-provider")
	void login(String username, String password) throws MalformedURLException, InterruptedException {
		Thread.sleep(5000);
		WebElement userName = driver
				.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]"));
		userName.sendKeys(username);

		WebElement passWord = driver
				.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]"));
		passWord.sendKeys(password);

		WebElement loginButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]"));
		loginButton.click();
	}
}
