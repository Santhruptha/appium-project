package org.AppiumPractice;

import org.devonicventures.genericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(org.devonicventures.genericUtility.ListenerImplimentationclass.class)
public class BigbasketEndtoEndsc2 extends BaseClass {
	@Test
	public void bigBasketscenario2() throws InterruptedException {
		mobileUtility.implicitWait(5);
		
		String expPrice = excelUtility.getDataFromExcelSheet("sheet1",1,1);
		System.out.println(expPrice);
		double expectedPrice = Double.parseDouble(expPrice);
		double actualPrice = homePage.selectBakeryProduct().selectIceCream().addiceCreamToCart().getPrice();
		
		
		System.out.println(expectedPrice);
		System.out.println(actualPrice);
		Assert.assertEquals(actualPrice,expectedPrice );
		
	}

}
