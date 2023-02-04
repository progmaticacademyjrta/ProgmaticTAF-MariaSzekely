package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    By headerBy = By.id("top");
    By makeAppointmentBtnLocaton = By.id("btn-make-appointment");
    By menuBtnLocaton = By.id("menu-toggle");
    By loginBtnLocaton = By.cssSelector("a[href='profile.php#login']");
    By logoutBtnLocaton = By.cssSelector("a[href='authenticate.php?logout']");
    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void loadHomePage() {
        driver.get("https://katalon-demo-cura.herokuapp.com");
        WebElement headerElement = driver.findElement(headerBy);
        Assert.assertTrue(headerElement.isDisplayed());
        System.out.println("Homepage loaded properly.");
    }
    public void makeAppointmentBtnVisible() {
        WebElement makeAppointment = wait.until(ExpectedConditions.elementToBeClickable(makeAppointmentBtnLocaton));
        System.out.println("Homepage make appointment button is clickable.");
    }
    public void makeAppointmentBtnClick() {
        WebElement makeAppointment = wait.until(ExpectedConditions.elementToBeClickable(makeAppointmentBtnLocaton));
        makeAppointment.click();
        System.out.println("Homepage make appointment button clicked.");
    }
    public void menuBtnClick() {
        WebElement menuBtn = wait.until(ExpectedConditions.elementToBeClickable(menuBtnLocaton));
        menuBtn.click();
        System.out.println("Homepage menu button clicked.");
    }
    public void loginBtnClick() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginBtnLocaton));
        loginBtn.click();
        System.out.println("Homepage menu login button clicked.");
    }
    public void logoutBtnClick() {
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutBtnLocaton));
        logoutBtn.click();
        System.out.println("Homepage menu logout button clicked.");
    }
}
