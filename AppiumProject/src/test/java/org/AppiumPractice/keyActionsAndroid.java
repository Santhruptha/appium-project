package org.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class keyActionsAndroid {
	@Test
	public void keyActions() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", ".SplashActivity");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//These are to get the numbers
		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_UP);
		
		System.out.println(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
		
		System.out.println(AndroidKeyCode.BACK);
		
		System.out.println(AndroidKeyCode.ENTER);
		
		System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_UP);
		
		System.out.println(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
		
		System.out.println(AndroidKeyCode.KEYCODE_CAMERA);
		
		System.out.println(AndroidKeyCode.KEYCODE_HOME);
		
		
		
		Thread.sleep(2000);
		

		//to perform actions
//		driver.pressKeyCode(AndroidKeyCode.KEYCODE_HOME);
		
//		driver.pressKeyCode(AndroidKeyCode.KEYCODE_HOME);
//		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_BRIGHTNESS_DOWN);
//		
		driver.pressKeyCode(AndroidKeyCode.KEYCODE_VOLUME_DOWN);
//		
		driver.openNotifications();
//		
//		driver.closeApp();
		
	}

}
