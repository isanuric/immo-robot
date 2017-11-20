package com.mycompany.app;

import com.isanuric.utils.PageHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import junit.framework.TestCase;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    public static final String LOGIN        = "//*[@id=\"link_loginAccountLink\"]/span[1]/span[1]/span";
    public static final String SELECT_LOGIN = "//*[@id=\"link_loginLinkInternal\"]";
    public static final String MAIL_FIELD   = "//*[@id=\"j_username\"]";
    public static final String YOUR_EMAIL   = "ehsan.salmani.application@gmail.com";
    public static final String YOUR_PASS    = "YkEnh6MLmAAp\"&$76gGT$%\"&df";
    public static final String PASS_FIELD   = "//*[@id=\"j_password\"]";
    public static final String LOGIN_BUTTON = "//*[@id=\"registration.submit\"]";
    public static final String SAVEDSEARCH = "//*[@id=\"savedsearch-myscout-manage\"]/span[1]";

    private PageHelper pageHelper;
    private WebDriver driver;
    private String xpathExpression;
    Immu immu;

    public void setUp() throws Exception {
//        super.setUp();
////        String baseUrl   = "/Users/isanuric/Documents/me/http/Mietwohnungen.htm";
//        String baseUrl   = "https://www.immobilienscout24.de/Suche/S-T/Wohnung-Miete/Fahrzeitsuche/Stuttgart_2dMitte/-/-59588/2097321/-/1276001039018/30/1,00-/20,00-/EURO--850,00?enteredFrom=result_list";
//        driver = new ChromeDriver();
//        this.pageHelper  = new PageHelper(baseUrl, driver);
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.immu = new Immu();
    }

//    public void tearDown() throws Exception {
//        super.tearDown();
//        this.driver.quit();
//    }

//    @Test
//    public void testLogin() throws Exception {
//
//        // login link
//        pageHelper.clickElementByXpath(LOGIN);
//
//        // select login
//        pageHelper.clickElementByXpath(SELECT_LOGIN);
//
//        // give email
//        pageHelper.setTextByXpath(MAIL_FIELD, YOUR_EMAIL);
//
//        // give password
//        pageHelper.setTextByXpath(PASS_FIELD, YOUR_PASS);
//
//        // click login button
//        pageHelper.clickElementByXpath(LOGIN_BUTTON);
//
//    }
//
//    @Test(dependsOnMethods = "testLogin")
//    public void testSelectSavedSearches() throws Exception {
//
//        // select your saved search
//        pageHelper.clickElementByXpath(SAVEDSEARCH);
//
//        // select one of saved searches
//        pageHelper.clickElementByXpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[2]/div[1]/div/div/div[1]");
//
//        // select results
//        pageHelper.clickElementByXpath("/html/body/div[1]/div[1]/div/div/div[2]/ul/li[2]/div[2]/div[2]/ul/li[4]/a");
//    }

//    public void testgetResults() throws Exception {
//
//        List<WebElement> links = driver.findElements(By.className("result-list-entry__brand-title"));
//
//        for (WebElement link : links) {
//            System.out.println(link);
//        }
//    }

    public void testLoginGoogle() throws Exception {

        this.immu.loginGmail();
        this.immu.getNewEmails();

    }
}
