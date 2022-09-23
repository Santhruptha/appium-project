package org.pomRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class loginPage {
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	@iOSFindBy()
	@FindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryDropDown;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	@iOSFindBy()
	@FindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameTextFeild;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	@iOSFindBy()
	@FindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleDropDown;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	@iOSFindBy()
	@FindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleDropDown;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	@iOSFindBy()
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopBtn;
	
	
	//for android and ios feild decorator
//	public loginPage(AndroidDriver driver) {
//		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//	}
	
	public loginPage(AndroidDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void logintoApp() {
		nameTextFeild.sendKeys("sks");
		maleDropDown.click();
		letsShopBtn.click();	
	}
	
	

}
