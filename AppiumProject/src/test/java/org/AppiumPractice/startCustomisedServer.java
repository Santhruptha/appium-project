package org.AppiumPractice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class startCustomisedServer {
	@Test
	public void stratServer() throws MalformedURLException
	{
		AppiumDriverLocalService server=AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				.usingPort(4723)
				.withLogFile(new File("../SDET36/Logs.txt")));

		server.start();

		DesiredCapabilities cap=new DesiredCapabilities();
		//common DC (ios or android)
		cap.setCapability("deviceName","Redmi");
		cap.setCapability("automationame", "appium");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platFormVersion", "7");
		cap.setCapability("deviceId","emulator-5554");

		cap.setCapability("noReset", true);
		//Dc for Android
		cap.setCapability("appPackage", "io.appium.android.apis");
		cap.setCapability("appActivity", ".ApiDemos");


		//Appium server port no 
		//this is used to connect the server
		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver<WebElement> driver=new AndroidDriver<WebElement>(url, cap);
		server.stop();
	}

}
