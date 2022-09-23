package org.pomRepository;

import java.util.List;

import org.devonicventures.genericUtility.MobileUtility;
import org.devonicventures.genericUtility.ThreadSafeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class bigBasketHomePage {
	
	@FindBy(xpath="//android.widget.ImageView[@resource-id='com.bigbasket.mobileapp:id/imgCategory']")
	private List<WebElement> BakeryImg ;
	
	
	public bigBasketHomePage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business library
	public BakeryPage selectBakeryProduct() throws InterruptedException {
		Thread.sleep(5000);
		ThreadSafeClass.getMobileUtility().tapAction(1, 715, 289, 500);
		Thread.sleep(2000);
		ThreadSafeClass.getMobileUtility().swipeAction(517, 1582, 517, 844, 500);
		BakeryImg.get(7).click();
		return new BakeryPage(ThreadSafeClass.getDriver());
	}

	

}
