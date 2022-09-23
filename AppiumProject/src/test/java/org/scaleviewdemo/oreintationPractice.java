package org.scaleviewdemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class oreintationPractice {
	@Test
	public void orientation() throws MalformedURLException
	{
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
	cap.setCapability(MobileCapabilityType.UDID, "48b3c620");
	cap.setCapability("appPackage", "com.davemorrissey.labs.subscaleview.sample");
	cap.setCapability("appActivity", ".MainActivity");
	
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url, cap);
	ScreenOrientation orientation = driver.getOrientation();
	driver.rotate(ScreenOrientation.LANDSCAPE);
	driver.rotate(ScreenOrientation.PORTRAIT);
	
	}

}
