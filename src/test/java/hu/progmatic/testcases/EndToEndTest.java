package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.ProfilPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends DriverBaseTest {
    HomePage homePage;
    LoginPage loginPage;
    ProfilPage profilPage;
    AppointmentPage appointmentPage;

    @Test(description = "TC06: end to end test, login, fill appointment,log out to home page", groups = "smoke")
    public void profileScreenLoadTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        homePage.loadHomePage();
        homePage.makeApointmentBtnClick();
        Thread.sleep(2000);
        loginPage = new LoginPage(driver, wait);
        loginPage.fillUsername("John Doe");
        loginPage.fillPassword("ThisIsNotAPassword");
        loginPage.loginBtnClick();
        Thread.sleep(3000);
        appointmentPage = new AppointmentPage(driver, wait);
        appointmentPage.selectFacility("Hongkong CURA Healthcare Center");
        appointmentPage.setApplyCheckboxClick();
        appointmentPage.setHealthcareRadioBtnClick();
        appointmentPage.fillDateTxt("01/02/2023");
        appointmentPage.fillCommentTxt("Comment Text");
        Thread.sleep(2000);
        appointmentPage.bookBtnClick();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
        homePage.menuBtnClick();
        homePage.logoutBtnClick();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
    }
}
