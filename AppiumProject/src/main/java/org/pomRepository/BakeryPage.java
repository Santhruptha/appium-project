package org.pomRepository;

import java.util.List;

import org.devonicventures.genericUtility.ThreadSafeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class BakeryPage {
	@FindBy(xpath="//android.widget.ImageView[@resource-id='com.bigbasket.mobileapp:id/imgCategory']")
	private List<WebElement> iceCreamImg;
	
	public BakeryPage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business library
	public iceCreamPage selectIceCream() throws InterruptedException {
		Thread.sleep(2000);
		iceCreamImg.get(2).click();
		return new iceCreamPage(ThreadSafeClass.getDriver());
		
	}

}
