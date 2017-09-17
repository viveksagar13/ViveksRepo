package com.automation.socialtrade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest 
{
	static WebDriver driver;
    static Wait<WebDriver> wait;	
    public static void main(String[] args) 
    {        
    	System.setProperty("webdriver.chrome.driver","D:\\TechSoftwares\\selenium-java-2.53.0\\chromedriver_win32\\chromedriver.exe");
    	driver = new ChromeDriver();

     wait = new WebDriverWait(driver, 30);

     driver.get("https://socialtrade.biz/");
     try 
     {

         login();

     }
     catch(Exception e) 
     {

         e.printStackTrace();

     }
     finally 
     {

         driver.close();

     }     
    }
	private static void login() 
	{
		
		driver.findElement(By.name("txtEmailID")).sendKeys("61296629");
		driver.findElement(By.name("txtPassword")).sendKeys("Ashu@123");
		
		driver.findElement(By.name("CndSignIn")).click();
		System.out.println("Logged In");
		
	}

}
