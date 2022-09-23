package org.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.sun.jna.platform.unix.X11.Display;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class backGroundAppRunningPractice {
	@Test
	public void appRunInBackground() throws MalformedURLException
	{
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
	cap.setCapability(MobileCapabilityType.UDID, "KZVWCINNINO7Q89H");
	cap.setCapability("appPackage", "io.appium.android.apis");
	cap.setCapability("appActivity", ".ApiDemos");
	
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url, cap);
	driver.runAppInBackground(5);
	
	
	}
	

}
