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
        homePage.makeAppointmentBtnClick();
        loginPage = new LoginPage(driver, wait);
        loginPage.fillUsername("John Doe");
        loginPage.fillPassword("ThisIsNotAPassword");
        loginPage.loginBtnClick();
        appointmentPage = new AppointmentPage(driver, wait);
        appointmentPage.selectFacility("Hongkong CURA Healthcare Center");
        appointmentPage.setApplyCheckboxClick();
        appointmentPage.setHealthcareRadioBtnClick();
        appointmentPage.fillDateTxt("01/02/2023");
        appointmentPage.fillCommentTxt("Comment Text");
        appointmentPage.bookBtnClick();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
        homePage.menuBtnClick();
        homePage.logoutBtnClick();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
    }
}
