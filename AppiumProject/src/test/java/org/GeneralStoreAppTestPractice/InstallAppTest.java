package org.GeneralStoreAppTestPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallAppTest {
	
	@Test()
	public void installapp() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.UDID, "48b3c620");
//		cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\santh\\Dropbox\\PC\\Downloads\\General-Store.apk");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, cap);
		driver.installApp("C:\\TY files\\General-Store.apk");
		boolean value = driver.isAppInstalled("com.androidsample.generalstore");
	}

}
