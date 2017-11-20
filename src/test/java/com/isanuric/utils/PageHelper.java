package com.isanuric.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PageHelper {

    String baseUrl;
    WebDriver driver;

    public PageHelper(String baseUrl, WebDriver driver) {
        this.baseUrl = baseUrl;
        this.driver = driver;
        this.driver.get(this.baseUrl);
    }

    public void clickElementByXpath(String element) {
        driver.findElement(By.xpath(element)).click();
    }

    public void setTextByXpath(String element, String text) { driver.findElement(By.xpath(element)).sendKeys(text); }

}
