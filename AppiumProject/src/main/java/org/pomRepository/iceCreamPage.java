package org.pomRepository;

import java.util.List;

import org.devonicventures.genericUtility.ThreadSafeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class iceCreamPage {
	public iceCreamPage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//android.widget.TextView[@text='Add']")
	private List<WebElement> addCartBtn0;
	
	@FindBy(xpath="//android.widget.TextView[@bounds='[763,1566][1052,1662]']")
	private WebElement addCartBtn1;
	
	@FindBy(id="com.bigbasket.mobileapp:id/cartcountView")
	private WebElement cartBtn;
	
	
	
	//buiseness library
	public reviewBasketPage addiceCreamToCart() {
		addCartBtn0.get(0).click();
		addCartBtn1.click();
		cartBtn.click();
		return new reviewBasketPage(ThreadSafeClass.getDriver());
		
	}
	
	//business libarary2
	public reviewBasketPage addIceCreamtoCartAndVerifyName() {
		addCartBtn0.get(0).click();
		cartBtn.click();
		return new reviewBasketPage(ThreadSafeClass.getDriver());
		
	}

}
