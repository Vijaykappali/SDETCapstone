package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	private AndroidDriver driver;

	// Locators using @AndroidFindBy annotation
	@AndroidFindBy(id = "com.example:id/username")
	private WebElement usernameField;

	@AndroidFindBy(id = "com.example:id/password")
	private WebElement passwordField;

	@AndroidFindBy(id = "com.example:id/loginButton")
	private WebElement loginButton;

	@AndroidFindBy(id = "com.example:id/errorMessage")
	private WebElement errorMessage;

	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void tapLoginButton() {
		loginButton.click();
	}

	public boolean isErrorMessageDisplayed() {
		return errorMessage.isDisplayed();
	}
}