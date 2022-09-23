package org.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Notification {
	@Test()
	public void notification() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.UDID, "x4soukivqw59pnjr");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url, cap);
		WebElement continueBtn = driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		driver.tap(1, continueBtn, 500);
		WebElement okBtn = driver.findElement(By.id("android:id/button1"));
		driver.tap(1, okBtn, 500);
		
		driver.findElementByAccessibilityId("App").click();
		driver.findElementByAccessibilityId("Notification").click();
		driver.findElementByAccessibilityId("IncomingMessage").click();
		driver.findElementByAccessibilityId("Show App Notification").click();
		Thread.sleep(2000);
		
		driver.openNotifications();
		Thread.sleep(5000);
		driver.findElementByAccessibilityId("//android.widget.TextView[@text='Joe']").click();
		
		
	}

}
