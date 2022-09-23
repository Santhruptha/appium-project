package org.ApiDemosPracticeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstallApp {

	@Test()
	public void installApp() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		cap.setCapability(MobileCapabilityType.UDID, "48b3c620");
		

		//it will install and open the App no nedd to use driver.launchApp();
		cap.setCapability(MobileCapabilityType.APP, "C:\\TY files\\Apk files\\ApiDemos-debug.apk");

		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, cap);
        driver.installApp("C:\\TY files\\Apk files\\ApiDemos-debug.apk");
		//if we are not using capability after driver.install we have to give driver.launchApp()
     	//driver.launchApp();
		boolean value = driver.isAppInstalled("io.appium.android.apis");
		System.out.println(value);
	}

}
