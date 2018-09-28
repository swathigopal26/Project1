package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() 

	{
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Users\\sg28\\workspace\\Project_1\\src\\main\\java\\com\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Users\\sg28\\selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
		

	
	

}
