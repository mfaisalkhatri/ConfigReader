package com.configreader.configreader.main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

	public final WebDriver driver;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
	}

	public void searchText(String searchText) {
		WebElement srchBox = driver.findElement(By.id("lst-ib"));
		srchBox.click();
		srchBox.sendKeys(searchText);
		srchBox.sendKeys(Keys.TAB);
		WebElement srchBtn = driver.findElement(By.name("btnK"));
		srchBtn.click();

	}
}
