package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilPage {
    WebDriver driver;
    WebDriverWait wait;
    By profilBtnLocaton = By.cssSelector("a[href='profile.php#profile']");
    By logoutBtnLocaton = By.cssSelector("a[class='btn btn-default']");


    public ProfilPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void profileBtnClick() {
        WebElement profilBtn = wait.until(ExpectedConditions.elementToBeClickable(profilBtnLocaton));
        profilBtn.click();
        System.out.println("Menu Profile button clicked");
    }

    public void profileLogoutBtnVisible() {
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutBtnLocaton));
        Assert.assertTrue(logoutBtn.isDisplayed());
        System.out.println("Profile logout button is visible");
    }

}
