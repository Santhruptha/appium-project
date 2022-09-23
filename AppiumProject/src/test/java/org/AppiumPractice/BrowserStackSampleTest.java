package org.AppiumPractice;
	import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.pomRepository.loginPage;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
	public class BrowserStackSampleTest 
	{
		public static void main(String[] args) throws MalformedURLException, InterruptedException
		{
			
	    	DesiredCapabilities caps = new DesiredCapabilities();
	    	
	    	// Set your access credentials
	    	caps.setCapability("browserstack.user", "santhrupthaks_teRvkf");
	    	caps.setCapability("browserstack.key", "jUMKjb9ZjtKmy7PfmHjR");
	    	
	    	// Set URL of the application under test
	    	caps.setCapability("app", "bs://75d11673a8f334962a8c5d9c974a7ce110674cb0");
	    	
	    	// Specify device and os_version for testing
	        caps.setCapability("device", "Samsung Galaxy S22");
	        caps.setCapability("os_version", "12.0");
	        
	    	// Set other BrowserStack capabilities
	    	caps.setCapability("project", "First Java Project");
	    	caps.setCapability("build", "browserstack-build-1");
	    	caps.setCapability("name", "first_test");
	    	caps.setCapability("appPackage", "com.androidsample.generalstore");
			caps.setCapability("appActivity", ".SplashActivity");
	    	
	    	
	    	URL url=new URL("https://santhrupthaks_teRvkf:jUMKjb9ZjtKmy7PfmHjR@hub-cloud.browserstack.com/wd/hub");
	       
	    	
	    AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url,caps);
	    Thread.sleep(3000);
	   driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("santhruptha");
	   driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
	   driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']/following-sibling::android.widget.LinearLayout[@index='3']/child::android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']/following-sibling::android.widget.LinearLayout[@index='3']/child::android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String actualTotalPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println(actualTotalPrice);
		String expectedTotalPrice="$ 280.97";
		Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	        
	        
	        // Invoke driver.quit() after the test is done to indicate that the test is completed.
	        driver.quit();
			
		}
	}


