package org.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class calculatorClickAction {
	@Test()
	public void calClick() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.UDID, "48b3c620");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", ".cal.AllInOneCalculatorActivity");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, cap);
		driver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();
		driver.findElement(By.id("com.miui.calculator:id/btn_plus_s")).click();
		driver.findElement(By.id("com.miui.calculator:id/btn_5_s")).click();
		driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
		String value = driver.findElement(By.id("com.miui.calculator:id/result")).getText();
		System.out.println(value);
		
	}

}
