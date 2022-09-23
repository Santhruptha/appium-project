package org.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class swipeActions {
	
@Test
public void swipeAction() throws MalformedURLException
{
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
	cap.setCapability(MobileCapabilityType.UDID, "x4soukivqw59pnjr");
	cap.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
	cap.setCapability("appActivity", ".TouchScreenTestActivity");
	
	URL url=new URL("http://localhost:4723/wd/hub");
	AndroidDriver driver=new AndroidDriver(url, cap);
	//swiping vertically
	driver.swipe(217, 456, 251, 1571, 500);
	//swipe horizontlly
//	driver.swipe(99,1289,905,1312,500);
	
	Dimension value = driver.manage().window().getSize();
	int height = value.getHeight();
	int width = value.getWidth();
//	//vertical swipe equally half
//	driver.swipe(width/2, 0, width/2, height, 500);
//	horizontal swipe equally half
//	driver.swipe(100, height/2, width, height/2, 500);
	
	//vertical swipe
	driver.swipe(width/2,(int)(height*0.25),width/2,(int)(height*0.80),1000);
	driver.swipe((int)(width*0.1), (int)(height*0.2),(int) (width*0.1), (int)(height*0.8), 500);
	driver.swipe((int)(width*0.5), (int)(height*0.2),(int) (width*0.5), (int)(height*0.8), 500);
	driver.swipe((int)(width*0.9), (int)(height*0.2),(int) (width*0.9), (int)(height*0.8), 500);
	
	//horixontalSwipe
	driver.swipe((int)(width*0.25),height/2,(int)(width*0.80),height/2,1000);
	driver.swipe((int)(width*0.1), (int)(height*0.8),(int) (width*0.9), (int)(height*0.8), 500);
	driver.swipe((int)(width*0.1), (int)(height*0.2),(int) (width*0.9), (int)(height*0.2), 500);
	driver.swipe((int)(width*0.1), (int)(height*0.5),(int) (width*0.9), (int)(height*0.5), 500);
}

}
