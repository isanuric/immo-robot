package com.mycompany.app;

import com.isanuric.utils.Element;
import com.isanuric.utils.PageHelper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Immu {

    //    private static final String PASSWORD = Configuration.getProperty("myPassword");
    private static final String PASSWORD = "";

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
        this.pageHelper.clickElementByXpath(Element.IDENTIFIER_NEXT);


        // password
        String pass = PASSWORD;
        this.pageHelper.setTextByXpath(Element.PASSWORD_INPUT, PASSWORD);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // click next
        this.pageHelper.clickElementByXpath(Element.PASSWORD_NEXT);
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
