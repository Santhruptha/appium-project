package org.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class webSwitchApp {
	@Test
	public void webSwitchApp() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.UDID, "48b3c620");
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", ".SplashActivity");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("santhruptha");
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']/following-sibling::android.widget.LinearLayout[@index='3']/child::android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']/following-sibling::android.widget.LinearLayout[@index='3']/child::android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String actualTotalPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println(actualTotalPrice);
		String expectedTotalPrice="$ 280.97";
		Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Set<String> windows = driver.getContextHandles();
		for(String window:windows)
		{
			System.out.println("Active windows"+window);
			driver.context("WEBVIEW_com.androidsample.generalstore");
			driver.findElement(By.xpath("//android.widget.EditText[@bounds='[99,619][1060,680]']")).sendKeys("santhruptha");
		}
		
		//switching from native to web
	}

}
