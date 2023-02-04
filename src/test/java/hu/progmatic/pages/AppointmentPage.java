package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AppointmentPage {
    WebDriver driver;
    WebDriverWait wait;
    By facilitySelectorLocated = By.name("facility");
    By applyCheckboxLocated = By.id("chk_hospotal_readmission");
    By healthcareRadioBtnLocated = By.cssSelector("input[type='radio'][value='Medicaid']");
    By dateTxtLocated = By.name("visit_date");
    By commentTxtLocated = By.id("txt_comment");
    By bookBtnLocated = By.cssSelector("button[type='submit']");
    public AppointmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void isMakeAppointmentScreen() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
        System.out.println("Make appointment screen loaded");
    }
    public void selectFacility(String facilityInput) {
        Select facilityDropDown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(facilitySelectorLocated)));
        facilityDropDown.selectByVisibleText(facilityInput);
        System.out.println("Selected " + facilityInput);
    }
    public void setApplyCheckboxClick() {
        WebElement applyCheckbox = wait.until(ExpectedConditions.elementToBeClickable(applyCheckboxLocated));
        applyCheckbox.click();
        System.out.println("Apply button clicked");
    }
    public void setHealthcareRadioBtnClick() {
        WebElement healthRadiobox = wait.until(ExpectedConditions.elementToBeClickable(healthcareRadioBtnLocated));
        healthRadiobox.click();
        System.out.println("Healthcare button clicked");
    }
    public void fillDateTxt(String fillDate) {
        WebElement date = driver.findElement(dateTxtLocated);
        date.sendKeys(fillDate);
        System.out.println("Filled date text");
    }
    public void fillCommentTxt(String fillTxt) {
        WebElement comment = driver.findElement(commentTxtLocated);
        comment.sendKeys(fillTxt);
        System.out.println("Filled comment text");
    }
    public void bookBtnClick() {
        WebElement bookBtn = wait.until(ExpectedConditions.elementToBeClickable(bookBtnLocated));
        bookBtn.click();
        System.out.println("Book appointment button clicked");
    }
}
