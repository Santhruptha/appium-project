package org.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class apiDemosPractice {
	
	@Test()
	public void apiDemo() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
		cap.setCapability(MobileCapabilityType.UDID, "48b3c620");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url, cap);
		WebElement continueBtn = driver.findElement(By.id("com.android.permissioncontroller:id/continue_button"));
		driver.tap(1, continueBtn, 500);
		WebElement okBtn = driver.findElement(By.id("android:id/button1"));
		driver.tap(1, okBtn, 500);
		WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
		driver.tap(1, views, 500);
		WebElement controls = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]"));
		driver.tap(1, controls, 500);
		WebElement lightTheme = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]"));
		driver.tap(1, lightTheme, 500);
		driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("santhruptha");
		WebElement checkBox1 = driver.findElement(By.id("io.appium.android.apis:id/check1"));
		driver.tap(1, checkBox1, 500);
		driver.findElement(By.id("io.appium.android.apis:id/check2")).click();
		WebElement radio1 = driver.findElement(By.id("io.appium.android.apis:id/radio1"));
		driver.tap(1, radio1, 500);
		WebElement radio2 = driver.findElement(By.id("io.appium.android.apis:id/radio2"));
		driver.tap(1, radio2, 500);
		WebElement star = driver.findElement(By.id("io.appium.android.apis:id/star"));
		driver.tap(1, star, 500);
		WebElement toggle1 = driver.findElement(By.id("io.appium.android.apis:id/toggle1"));
		driver.tap(1, toggle1, 500);
		WebElement toggle2 = driver.findElement(By.id("io.appium.android.apis:id/toggle2"));
		driver.tap(1, toggle2, 500);
		driver.findElement(By.id("io.appium.android.apis:id/spinner1")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Earth']")).click();
		driver.findElement(By.id("io.appium.android.apis:id/spinner1")).click();
		 List<WebElement> values = driver.findElements(By.className("android.widget.CheckedTextView"));
		 for(WebElement planets:values)
		 {
			 System.out.println(planets.getText());
		 }
//		driver.findElement(By.id("io.appium.android.apis:id/button")).click();
	}

}
