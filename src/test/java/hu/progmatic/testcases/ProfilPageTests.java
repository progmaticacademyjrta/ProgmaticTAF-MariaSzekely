package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.ProfilPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfilPageTests extends DriverBaseTest {
    HomePage homePage;
    LoginPage loginPage;
    ProfilPage profilPage;

    @Test(description = "TC05: profil page loaded succesfully ", groups = "regression")
    public void profilScreenLoadTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        homePage.loadHomePage();
        homePage.menuBtnClick();
        homePage.loginBtnClick();
        Thread.sleep(2000);
        loginPage = new LoginPage(driver, wait);
        loginPage.fillUsername("John Doe");
        loginPage.fillPassword("ThisIsNotAPassword");
        loginPage.loginBtnClick();
        Thread.sleep(1000);
        homePage.menuBtnClick();
        profilPage = new ProfilPage(driver, wait);
        profilPage.profileBtnClick();
        Thread.sleep(3000);
        profilPage.profileLogoutBtnVisible();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/profile.php#profile");
    }
}
