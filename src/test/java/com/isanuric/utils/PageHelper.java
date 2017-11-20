package com.isanuric.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ----------------------------------------------
 * (c)2017 Copyright iC Consult GmbH
 * <p/>
 * Project: immu
 * Created by Ehsan on 19/11/2017.
 */
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
