
package org.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.remote.MobileCapabilityType;

public class appMethods {
	@Test
	public void appPractice() throws MalformedURLException
	{
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
	cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	cap.setCapability("appPackage", "io.appium.android.apis");
	cap.setCapability("appActivity", ".ApiDemos");
	
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url, cap);
	
	//Activates the given app if it is installed ,but not running or if it is running in the background.
	//driver.activateApp("com.androidsample.generalstore");
	//this method is available in appium java client 7 version
	
	//Terminate the particular application if it is running
	//driver.terminateApp("io.appium.android,apis");
	//this method is available in appium java client 7 version
	
	//Queries the state of an application
	//NOT_iNSTALLED,NOT_RUNNING, RUNNING_IN_THE_BACKGROUND_SUSPENDED,
	//RUNNING_IN_THE_BACKGROUND,RUNNING_IN_THE_FOREGROUND
	
	//ApplicationState be=driver.qureyAppState("com.androidsample.generalstore");
	//System.out.println(be);
	
	driver.installApp("apk path");
	
	//Reset the currently running app together with the session
	driver.resetApp();
	driver.closeApp();
	driver.launchApp();
	
	
	
	//checks if an app is installed on the device
	boolean statusofApp = driver.isAppInstalled("io.appium.android.apis");
	System.out.println(statusofApp);
	
	//To check the device is lokced or not
//	driver.isDeviceLocked();
	
	//Emulator power state change on the connected emulator
//	driver.setpowerAC(PowerState.OFF);
//	driver.setpowerAC(PowerState.ON);
	
	}

}
