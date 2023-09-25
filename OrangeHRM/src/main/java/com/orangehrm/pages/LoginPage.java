package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.orangehrm.base.OrangeHRMBase;

public class LoginPage extends OrangeHRMBase {

	By invalidcred=By.xpath("//p[text()='Invalid credentials']");
	By req=By.xpath("//span[text()='Required']");
	By loginbtn=By.xpath("//button[@type = 'submit']");
	By forgotl=By.xpath("//p[text()='Forgot your password? ']");
	public String getTitle() {
		return driver.getTitle();
	}
	public boolean getUserNameFieldPresent() {
		return driver.findElement(By.name("username")).isDisplayed();
	}
	public boolean getPasswordFieldPresent() {
		return driver.findElement(By.name("password")).isDisplayed();
	}
	public boolean verifywarningmsg() {
		
		WebElement acttitle=driver.findElement(invalidcred);
		 String actresult=acttitle.getText();	 
		 System.out.println(actresult);
		String excpresult= "Invalid credentials";
		 if(excpresult.equals(actresult) ) {
				System.out.println("Invalid credentials :Testcase Passed");
		 }
		 else {
				System.out.println("Invalid credentials :Testcase Failed");
		 }
		return driver.findElement(invalidcred).isDisplayed();
	}
	public boolean validateblankfield_warningmsg() {

		WebElement acttitle=driver.findElement(req);
		 String actresult=acttitle.getText();
		 
		 System.out.println(actresult);
		String excpresult= "Required";
		/*
		 if(excpresult.equals(actresult) ) {
				System.out.println("Blank field validation Passed ");
		 }
		 else {
				System.out.println("Blank field validation Failed");
		 }*/
		return driver.findElement(req).isDisplayed();

	}
	
	public DashboardPage login() {
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(loginbtn).click();
		return new DashboardPage();
	}
	public LoginPage invalidlogin() {
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("invalidusername"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("invalidpassword"));
		driver.findElement(loginbtn).click();
		return new LoginPage();
	}

	public LoginPage blanklogin() {
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("blankcred"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("invalidpassword"));
		driver.findElement(loginbtn).click();
		return new LoginPage();
	}
	public boolean forgotpasswordlink() {
		WebElement forgot=driver.findElement(forgotl);
		return forgot.isDisplayed();
		
		//return driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).isDisplayed();

	}
}
