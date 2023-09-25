package com.orangehrm.pages;

import org.openqa.selenium.By;

import com.orangehrm.base.OrangeHRMBase;

public class DashboardPage extends OrangeHRMBase {
	By timework=By.xpath("//p[text()='Time at Work']");
	By myinfo = By.xpath("//span[text()='My Info']");
	public boolean getTimeWorkSectionPresent() {
		
		return driver.findElement(timework).isDisplayed();
	}
	public boolean myinfotabPresent() {

		return driver.findElement(myinfo).isDisplayed();
	}
	public MyinfoPage getmyinfopage() {
			 	driver.findElement(myinfo).click();
	 	return new MyinfoPage();
	}

}
