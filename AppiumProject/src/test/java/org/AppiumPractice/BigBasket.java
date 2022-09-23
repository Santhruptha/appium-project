package org.AppiumPractice;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.devonicventures.genericUtility.ExcelUtility;
import org.devonicventures.genericUtility.FileUtility;
import org.devonicventures.genericUtility.IConstants;
import org.devonicventures.genericUtility.JavaUtility;
import org.devonicventures.genericUtility.MobileUtility;
import org.devonicventures.genericUtility.ThreadSafeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
@Listeners(org.devonicventures.genericUtility.ListenerImplimentationclass.class)
public class BigBasket  {
	JavaUtility javaUtility;
	MobileUtility mobileUtility;
	@Test
	public void bigBasket() throws MalformedURLException, InterruptedException
	{
		 mobileUtility=new MobileUtility();
		FileUtility fileUtility=new FileUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		 javaUtility=new JavaUtility();
		
		//initialize fileutility
		fileUtility.initializePropertyFile(IConstants.PROPERTYFILEPATH);
		DesiredCapabilities cap = mobileUtility.initializeDesiredCapabilities(IConstants.PLATFORMNAME, fileUtility.getDataFromProperties("platFormVersion"), fileUtility.getDataFromProperties("deviceId"),fileUtility.getDataFromProperties("appPackage"),fileUtility.getDataFromProperties("appActivity"));
		URL url = mobileUtility.initializeUrl(fileUtility.getDataFromProperties("urlAddress"));
		AndroidDriver<WebElement> driver = mobileUtility.initializeAndroidDriver(url, cap);
		mobileUtility.implicitWait(5);
		Thread.sleep(5000);
		mobileUtility.tapAction(1, 715, 289, 500);
		Thread.sleep(2000);
		mobileUtility.swipeAction(517, 1582, 517, 844, 500);
		driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.bigbasket.mobileapp:id/slotRecycleView']//child::androidx.recyclerview.widget.RecyclerView[@resource-id='com.bigbasket.mobileapp:id/listCategory']//child::android.widget.ImageView")).get(6).click();
		driver.findElements(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.bigbasket.mobileapp:id/slotRecycleView']//child::android.widget.FrameLayout[@resource-id='com.bigbasket.mobileapp:id/gridTopView']//child::android.widget.ImageView")).get(0).click();
		Thread.sleep(2000);
		for(int i=0;i<=2;i++) 
		{
			swipeAndFetch(driver);
			
		}
	}
		public void swipeAndFetch(AndroidDriver<WebElement> driver) 
		{
		mobileUtility.swipeAction(517, 1582, 517, 844, 500);
		List<WebElement> chocolates = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/txtProductDesc']"));
		List<WebElement> prices = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/txtSalePrice']"));
		for (int i=0;i<chocolates.size();i++)
		{
//			System.out.println(chocolates.get(i).getText());
//			System.out.println(prices.get(i).getText());
				String[] chocoPrice = javaUtility.splitString(prices.get(i).getText(), "₹");
				double newPrice = Double.parseDouble(chocoPrice[1]);
				if(newPrice>=100)
				{
				System.out.println(chocolates.get(i).getText());
				System.out.println(newPrice);
				}	
		}
	}
		
}		
	


