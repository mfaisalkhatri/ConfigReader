package com.configreader.propertiesfilereader.test;

import static com.configreader.propertiesfilereader.utils.Sleeper.sleep;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.configreader.propertiesfilereader.main.GooglePage;
import com.configreader.propertiesfilereader.main.PropertiesReader;

public class PropertiesReaderTest {

	@Test(priority = 1)
	public void Test1() throws Exception,FileNotFoundException {
		final WebDriver driver;
		PropertiesReader prop = new PropertiesReader();

		final String exe = prop.getKey("exe");
		final String path = getClass().getClassLoader().getResource(exe).getPath();

		String website = prop.getKey("url");
		String srch = prop.getKey("searchtext");

		System.setProperty("webdriver.chrome.driver", path);

		driver = new ChromeDriver();
		driver.get(website);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		GooglePage google = new GooglePage(driver);
		google.searchText(srch);
		sleep(2000);

		driver.quit();
	}

	@Test(priority = 2)
	public void Test2() throws Exception,FileNotFoundException {

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

}
