package com.configreader.configreader.test;

import static com.configreader.configreader.utils.Sleeper.sleep;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.configreader.configreader.main.GooglePage;
import com.configreader.configreader.main.PropertiesReader;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Epic("Unit Test for Config ReadGet Value from er Repo")
@Feature("Get values from config.properties and pass in tests")
public class PropertiesReaderTest {

	private WebDriver driver = null;
	@Step
	public void setup() throws IOException {

		PropertiesReader prop = new PropertiesReader();
		final String exe = prop.getKey("exe");
		final String path = getClass().getClassLoader().getResource(exe).getPath();

		String website = prop.getKey("url");

		System.setProperty("webdriver.chrome.driver", path);

		driver = new ChromeDriver();
		driver.get(website);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Step
	public void quitBrowser() {
		driver.quit();
	}

	@Test(priority = 1)
	@Story("Get Key Value from config and search text in Google Site")
	public void test1() throws FileNotFoundException, IOException, Throwable {

		setup();
		
		PropertiesReader prop = new PropertiesReader();
		String srch = prop.getKey("searchtext");
		GooglePage google = new GooglePage(driver);
		google.searchText(srch);
		sleep(2000);

		quitBrowser();
	}

	@Test(priority = 2)
	@Story("Get Key Value from config and print in console")
	public void test2() throws FileNotFoundException, IOException, Throwable {
		PropertiesReader prop = new PropertiesReader();
		String exe = prop.getKey("exe");
		String website = prop.getKey("url");
		String srch = prop.getKey("searchtext");

		System.out.println("Value of url key is: " + website);
		System.out.println("Value of search text key is: " + srch);
		System.out.println("Value of exe key is: " + exe);
		Assert.assertEquals(exe, "Chromedriver.exe");
		Assert.assertEquals(website, "http://www.google.co.in");
		Assert.assertEquals(srch, "Apple iphone 8");

	}

	@Test(priority = 3)
	@Story("Get Key 2 valid values and 1 Invalid value from config and check for exceptions/errors")
	public void test3() throws IOException {
		PropertiesReader prop = new PropertiesReader();
		String exe = prop.getKey("exe");
		String invalidval = prop.getKey("invalidval");
		String url = prop.getKey("url");

		System.out.println(invalidval + " " + exe + " " + url);

	}
}
