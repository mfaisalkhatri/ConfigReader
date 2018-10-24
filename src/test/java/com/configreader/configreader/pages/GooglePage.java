package com.configreader.configreader.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Faisal Khatri
 * @version 1.0.0
 * @since 2018-10-20
 */
public class GooglePage {

	private final WebDriver driver;

	/**
	 * @param driver
	 */
	public GooglePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @param searchText
	 */
	public void searchText(String searchText) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement searchBox = driver.findElement(By.name("q"));
		WebElement srchBox = wait.until(ExpectedConditions.visibilityOf(searchBox));
		srchBox.click();
		srchBox.sendKeys(searchText);
		srchBox.sendKeys(Keys.TAB);
		WebElement srchBtn = driver.findElement(By.name("btnK"));
		srchBtn.click();

	}
}
