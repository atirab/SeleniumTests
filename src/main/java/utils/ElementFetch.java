package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class ElementFetch {
	
	public WebElement getWebElement(String idType, String idValue) {
		
		switch(idType) {
		case "XPATH":
		return BaseTest.driver.findElement(By.xpath(idValue));
		case "CSS":
		return BaseTest.driver.findElement(By.cssSelector(idValue));
		case "ID":
			return BaseTest.driver.findElement(By.id(idValue));
		default:
		return null;
		}
		
	}
public List<WebElement> getWebElements(String idType, String idValue) {
		
		switch(idType) {
		case "XPATH":
		return BaseTest.driver.findElements(By.xpath(idValue));
		case "CSS":
		return BaseTest.driver.findElements(By.cssSelector(idValue));
		case "ID":
			return BaseTest.driver.findElements(By.id(idValue));
		default:
		return null;
		}
		
	}

}
