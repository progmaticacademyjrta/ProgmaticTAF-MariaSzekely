package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppointmentPageTests extends DriverBaseTest {
    LoginPage loginPage;
    HomePage homePage;
    AppointmentPage appointmentPage;

    @Test(description = "TC04: make appointement is work ", groups = "regression")
    public void makeAppointmentFillWorkTest() throws InterruptedException {
        homePage = new HomePage(driver, wait);
        homePage.loadHomePage();
        homePage.makeApointmentBtnClick();
        Thread.sleep(2000);
        loginPage = new LoginPage(driver, wait);
        loginPage.fillUsername("John Doe");
        loginPage.fillPassword("ThisIsNotAPassword");
        loginPage.loginBtnClick();
        Thread.sleep(1000);
        appointmentPage = new AppointmentPage(driver, wait);
        appointmentPage.isMakeApointmentScreen();
        appointmentPage.selectFacility("Hongkong CURA Healthcare Center");
        appointmentPage.setApplyCheckboxClick();
        appointmentPage.setHealthcareRadioBtnClick();
        appointmentPage.fillDateTxt("01/02/2023");
        appointmentPage.fillCommentTxt("Comment Text");
        Thread.sleep(2000);
        appointmentPage.bookBtnClick();
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

    }
}
