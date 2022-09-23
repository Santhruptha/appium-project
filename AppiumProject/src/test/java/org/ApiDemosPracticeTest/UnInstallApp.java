package org.ApiDemosPracticeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UnInstallApp {
	
	@Test()
	public void uninstallApp() throws MalformedURLException
	{
		DesiredCapabilities cap =new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.UDID, "48b3c620");
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");
//		cap.setCapability(MobileCapabilityType.FULL_RESET, "true");
		
		URL url =new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, cap);
		driver.removeApp("io.appium.android.apis");
		boolean value = driver.isAppInstalled("io.appium.android.apis");
		System.out.println(value);
	}

}
