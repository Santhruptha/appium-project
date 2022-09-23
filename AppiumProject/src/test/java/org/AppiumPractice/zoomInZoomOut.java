package org.AppiumPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.devonicventures.genericUtility.ExcelUtility;
import org.devonicventures.genericUtility.FileUtility;
import org.devonicventures.genericUtility.IConstants;
import org.devonicventures.genericUtility.JavaUtility;
import org.devonicventures.genericUtility.MobileUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class zoomInZoomOut {
	@Test
	public void zoomAction() throws MalformedURLException, InterruptedException {
		MobileUtility mobileUtility=new MobileUtility();
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		JavaUtility javaUtility=new JavaUtility();
		
		//initialize fileutility
		fileUtility.initializePropertyFile(IConstants.PROPERTYFILEPATH);
		DesiredCapabilities cap = mobileUtility.initializeDesiredCapabilities(IConstants.PLATFORMNAME, fileUtility.getDataFromProperties("platFormVersion"), fileUtility.getDataFromProperties("deviceId"),fileUtility.getDataFromProperties("appPackage"),fileUtility.getDataFromProperties("appActivity"));
		URL url = mobileUtility.initializeUrl(fileUtility.getDataFromProperties("urlAddress"));
		AndroidDriver<WebElement> driver = mobileUtility.initializeAndroidDriver(url, cap);
		mobileUtility.implicitWait(5);
		
		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/basicFeatures")).click();
		WebElement img = driver.findElement(By.id("com.davemorrissey.labs.subscaleview.sample:id/imageView"));
		driver.zoom(img);
		Thread.sleep(5000);
		driver.pinch(img);
		Thread.sleep(2000);
	}

}
