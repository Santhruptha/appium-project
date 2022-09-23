package org.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DragNDropPractice {
	@Test
	public void DragDrop() throws MalformedURLException
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
		WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
		driver.tap(1, views, 500);
		driver.findElementByAccessibilityId("Drag and Drop").click();
		WebElement src = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement dest = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));
		
		/* MobileElement src = (MobileElement)driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		MobileElement  dest = (MobileElement)driver.findElement(By.id("io.appium.android.apis:id/drag_dot_3"));*/
		
		TouchAction to=new TouchAction(driver);
		to.longPress(src).waitAction(2000).moveTo(dest).release().perform();
		
		//driver.closeApp();
	}

}
