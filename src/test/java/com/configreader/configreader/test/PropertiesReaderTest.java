package com.configreader.configreader.test;

import static com.configreader.configreader.utils.Sleeper.sleep;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.configreader.configreader.main.PropertiesReader;
import com.configreader.configreader.pages.GooglePage;
import com.configreader.configreader.utils.OSCheck;

/**
 * Unit Tests for checking values from config file.
 * @author Faisal Khatri
 * @version 1.0.0
 * @since 2018-10-20
 *
 */
public class PropertiesReaderTest {

	private WebDriver driver = null;

	/**
	 * This is setup method to initialize browser.
	 * @throws IOException
	 */
	public void setup() throws IOException {

		PropertiesReader prop = new PropertiesReader();
		String website = prop.getKey("url");

		OSCheck osSetup = new OSCheck();
		osSetup.setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		options.addArguments("start-maximized");
		options.addArguments("--disable-dev-shm-usage");
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		driver.get(website);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().setSize(new Dimension(1024, 768));

	}

	/**
	 * This method quits browser
	 */
	public void quitBrowser() {
		driver.quit();
	}

	/**
	 * Test 1
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Throwable
	 */
	@Test(priority = 1)
	public void test1() throws FileNotFoundException, IOException, Throwable {

		setup();
		PropertiesReader prop = new PropertiesReader();
		String srch = prop.getKey("searchtext");
		GooglePage google = new GooglePage(driver);
		google.searchText(srch);
		sleep(2000);
		quitBrowser();
	}

	/**
	 * Test 2
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Throwable
	 */
	@Test(priority = 2)
	public void test2() throws FileNotFoundException, IOException, Throwable {
		PropertiesReader prop = new PropertiesReader();
		String exe = prop.getKey("exe");
		String website = prop.getKey("url");
		String srch = prop.getKey("searchtext");

		System.out.println("Value of url key is: " + website);
		System.out.println("Value of search text key is: " + srch);
		System.out.println("Value of exe key is: " + exe);
		Assert.assertEquals(exe, "chromedriver");
		Assert.assertEquals(website, "http://www.google.co.in");
		Assert.assertEquals(srch, "Apple iphone 8");

	}

	/**
	 * Test 3 
	 * @throws IOException
	 */
	@Test(priority = 3)
	public void test3() throws IOException {
		PropertiesReader prop = new PropertiesReader();
		String exe = prop.getKey("exe");
		String invalidval = prop.getKey("invalidval");
		String url = prop.getKey("url");

		System.out.println("Values in config file are: " +invalidval + " " + exe + " " + url);

	}
}
