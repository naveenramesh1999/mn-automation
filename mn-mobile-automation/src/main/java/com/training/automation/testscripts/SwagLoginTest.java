package com.training.automation.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.automation.base.MobileTestBase;

public class SwagLoginTest extends MobileTestBase {

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() throws IOException {

		String home = System.getProperty("user.dir");
		String filePath = home + File.separator + "src" + File.separator + "main" + File.separator + "resources"
				+ File.separator + "LoginTest.xlsx";

		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		XSSFRow row;
		XSSFCell name, password;
		Object input[][] = new Object[3][2];
		for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
			row = sheet.getRow(rowIndex);
			name = row.getCell(0);
			password = row.getCell(1);
			String userName = name.getStringCellValue();
			String passWord = password.getStringCellValue();
			input[rowIndex][0] = userName;
			input[rowIndex][1] = passWord;

		}

		return input;

	}

	@Test(dataProvider = "data-provider")

	void loginSwagLab(String username, String password) throws MalformedURLException {

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