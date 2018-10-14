package com.configreader.configreader.main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {

	public final WebDriver driver;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchText(String searchText) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement searchBox = driver.findElement(By.name("q"));
		WebElement srchBox = wait.until(ExpectedConditions.visibilityOf(searchBox));
		srchBox.click();
		srchBox.sendKeys(searchText);
		srchBox.sendKeys(Keys.TAB);
		WebElement srchBtn = driver.findElement(By.name("btnK"));
		srchBtn.click();

	}
}
