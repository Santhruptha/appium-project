package org.AppiumPractice;

import org.devonicventures.genericUtility.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(org.devonicventures.genericUtility.ListenerImplimentationclass.class)
public class bigBasketendtoend3 extends BaseClass {
	@Test
	public void endtoend() throws InterruptedException {
		mobileUtility.implicitWait(5);

		String expectedName = excelUtility.getDataFromExcelSheet("sheet1",2,1);
		System.out.println(expectedName);
		String actualProductName = homePage.selectBakeryProduct().selectIceCream().addIceCreamtoCartAndVerifyName().getActualProductName();

		System.out.println(actualProductName+"&"+expectedName);
		
		
		Assert.assertTrue(actualProductName.contains(expectedName), "Product validated");

	}

}
