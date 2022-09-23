package org.pomRepository;

import java.util.List;

import org.devonicventures.genericUtility.ThreadSafeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class reviewBasketPage {
	public reviewBasketPage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="com.bigbasket.mobileapp:id/total_price_tv")
	private WebElement price;
	
	@FindBy(xpath="//android.widget.TextView[@text='Amul - Vanilla Magic Ice Cream - Real Milk']")
	private WebElement iceCreamName;
	
	//business library
	public double getPrice() {
		String totalPrice = price.getText();
		String[] newPrice = ThreadSafeClass.getJavaUtility().splitString(totalPrice, "₹");
		double priceinRs = Double.parseDouble(newPrice[1]);
		return priceinRs;
		
	}
	
	//business library2
	public String getActualProductName() throws InterruptedException {
		Thread.sleep(4000);
		String productName = iceCreamName.getText();
		return productName;
	}

}
