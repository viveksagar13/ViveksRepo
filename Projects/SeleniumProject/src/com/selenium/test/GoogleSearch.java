package com.selenium.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
11
 * Search Google example.
12
 *
13
 * @author Rahul
14
 */

public class GoogleSearch {

    static WebDriver driver;
    static Wait<WebDriver> wait;	
    public static void main(String[] args) 
    {
        //driver = new FirefoxDriver();
    	System.setProperty("webdriver.ie.driver","D:\\TechSoftwares\\selenium-java-2.53.0\\IEDriverServer_x64_2.53.0\\IEDriverServer.exe");
    	driver = new InternetExplorerDriver();

     wait = new WebDriverWait(driver, 30);

     driver.get("http://www.google.com/");



     boolean result;

     try {

         result = firstPageContainsQAANet();

     } catch(Exception e) {

         e.printStackTrace();

         result = false;

     } finally {

         driver.close();

     }



     System.out.println("Test " + (result? "passed." : "failed."));

     if (!result) {

         System.exit(1);

     }

 }



 private static boolean firstPageContainsQAANet() {

     //type search query

     driver.findElement(By.name("q")).sendKeys("qa automation\n");



     // click search

     driver.findElement(By.name("btnG")).click();



     // Wait for search to complete

     wait.until(new ExpectedCondition<Boolean>() {

         public Boolean apply(WebDriver webDriver) {

             System.out.println("Searching ...");

             return webDriver.findElement(By.id("resultStats")) != null;

         }

     });



     // Look for QAAutomation.net in the results

     return driver.findElement(By.tagName("body")).getText().contains("qaautomation.net");

 }

}
