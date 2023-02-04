package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By usernameInputLocaton = By.name("username");
    By passwordInputLocaton = By.id("txt-password");
    By errorMessagetLocaton = By.cssSelector("p[class='lead text-danger']");
    By loginBtnLocaton = By.id("btn-login");
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void fillUsername(String username) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputLocaton));
        usernameInput.sendKeys(username);
        System.out.println("Username Filled");
    }
    public void fillPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputLocaton));
        passwordInput.sendKeys(password);
        System.out.println("Password Filled");
    }
    public void errorMessageVisible() {
        WebElement errormessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessagetLocaton));
        System.out.println(errormessage.getText());
        Assert.assertEquals(errormessage.getText(), "Login failed! Please ensure the username and password are valid.");
        System.out.println("Error message ok");
    }
    public void loginBtnClick() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginBtnLocaton));
        loginBtn.click();
        System.out.println("Login button clicked after filled username and password");
    }
}
