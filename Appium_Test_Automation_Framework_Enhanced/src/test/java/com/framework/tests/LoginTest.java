package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean shouldFail) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.tapLoginButton();

        if (shouldFail) {
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message should be displayed for invalid login");
        } else {
            Assert.assertFalse(loginPage.isErrorMessageDisplayed(), "Error message should NOT be displayed for valid login");
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"validUser", "validPass", false},  // Positive case
            {"invalidUser", "invalidPass", true} // Negative case
        };
    }
}