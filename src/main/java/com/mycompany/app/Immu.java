package com.mycompany.app;

import com.isanuric.utils.Element;
import com.isanuric.utils.PageHelper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * ----------------------------------------------
 * (c)2017 Copyright iC Consult GmbH
 * <p/>
 * Project: immu
 * Created by Ehsan on 19/11/2017.
 */
public class Immu {

    //    private static final String PASSWORD = Configuration.getProperty("myPassword");
    private static final String PASSWORD = "";
    public static final String IDENTIFIER_NEXT = "//*[@id=\"identifierNext\"]/content/span";
    public static final String PASSWORD_INPUT = "//*[@id=\"password\"]/div[1]/div/div[1]/input";
    public static final String PASSWORD_NEXT = "//*[@id=\"passwordNext\"]/content/span";
    private PageHelper pageHelper;
    private WebDriver driver;

    public Immu() {

        String baseUrl   = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
        driver = new ChromeDriver();
        this.pageHelper  = new PageHelper(baseUrl, driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void loginGmail() {

        // google mail
//        this.pageHelper.setTextByXpath("//*[@id=\"identifierId\"]", Element.YOUR_EMAIL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.pageHelper.setTextByXpath("//*[@id=\"identifierId\"]", PASSWORD);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // click next
        this.pageHelper.clickElementByXpath(IDENTIFIER_NEXT);


        // password
        String pass = PASSWORD;
        this.pageHelper.setTextByXpath(PASSWORD_INPUT, PASSWORD);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // click next
        this.pageHelper.clickElementByXpath(PASSWORD_NEXT);
    }

    public void getNewEmails() {

        List<WebElement> unreadEmail = driver.findElements(By.xpath("//*[@class='zF']"));

        for (int i=0; i < unreadEmail.size(); i++) {
            if (unreadEmail.get(i).isDisplayed() == true && i < 20) {

                if (unreadEmail.get(i).getText().equals("ImmobilienScout24")) {
                    System.out.println(unreadEmail.get(i).getText());
                }
            }else {
                System.out.println("not found!");
            }
        }

    }





}
