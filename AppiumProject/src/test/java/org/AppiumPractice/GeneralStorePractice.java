package org.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.pomRepository.loginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class GeneralStorePractice {
	@Test
	public void generalStore() throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", ".SplashActivity");
		
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url, cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//from pom
		loginPage loginPage=new loginPage(driver);
		loginPage.logintoApp();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 4 Retro']/following-sibling::android.widget.LinearLayout[@index='3']/child::android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Air Jordan 1 Mid SE']/following-sibling::android.widget.LinearLayout[@index='3']/child::android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String actualTotalPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println(actualTotalPrice);
		String expectedTotalPrice="$ 280.97";
		Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
	}

}
