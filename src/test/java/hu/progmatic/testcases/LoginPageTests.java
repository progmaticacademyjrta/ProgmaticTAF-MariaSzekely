package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends DriverBaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @Test(description = "TC03: login on Login screen with fault username and password, is show an error message", groups = "regression")
    public void loginWithWrongDatasTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        homePage.loadHomePage();
        homePage.menuBtnClick();
        homePage.loginBtnClick();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#login");
        loginPage = new LoginPage(driver, wait);
        loginPage.fillUsername("WrongUsername");
        loginPage.fillPassword("WrongPassword");
        loginPage.loginBtnClick();
        Thread.sleep(1000);
        loginPage.errorMessageVisible();

    }
}
