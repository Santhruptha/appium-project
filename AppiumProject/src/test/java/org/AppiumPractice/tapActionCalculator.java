package org.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class tapActionCalculator {
	
	public class calculatorClickAction 
	{
		AndroidDriver driver;
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
			 driver=new AndroidDriver(url, cap);
			WebElement two = driver.findElement(By.id("com.miui.calculator:id/btn_2_s"));
//			driver.tap(1, two, 500);
			tapByFingers(1, two, 500);
			WebElement plus = driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
//			driver.tap(1, plus, 500);
			tapByCoordinates(1, 972, 1901, 500);
			WebElement five = driver.findElement(By.id("com.miui.calculator:id/btn_5_s"));
//			driver.tap(1, five, 500);
			tapByFingers(1, five, 500);
			WebElement equals = driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
//			driver.tap(1, equals, 500);
			tapByFingers(1, equals, 500);
			String value = driver.findElement(By.id("com.miui.calculator:id/result")).getText();
			System.out.println(value);
		}
		
		public void tapByFingers(int fingers,WebElement element,int duration)
		{
			driver.tap(fingers, element, duration);
		}
		
		public void tapByCoordinates(int fingers,int x,int y,int duration)
		{
			driver.tap(fingers, x, y, duration);
		}

}
}
