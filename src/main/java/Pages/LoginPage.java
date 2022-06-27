package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;
    private By usernameTextbox= By.id("userName");
    private By passwordTextbox=By.id("password");
    private By signInButton=By.xpath("//button[1]");
    private By registrationLink=By.xpath("/html/body/div[2]/div/div/main/div/div[6]/div[2]");

    private By captchabox=By.xpath("//*[@id='recaptcha-anchor']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void writeUsername(String username){
        driver.findElement(usernameTextbox).sendKeys(username);
    }
    public void writePassword(String password){
        driver.findElement(passwordTextbox).sendKeys(password);
    }
    public HomePage clickSignIn() throws InterruptedException {
   /*     driver.switchTo().frame(1);
        driver.findElement(captchabox).click();
        driver.switchTo().parentFrame();*/
        driver.findElement(signInButton).click();
        return new HomePage(driver);
    }
    public RegistrationPage clickRegisterLink(){
        driver.findElement(registrationLink).click();
        return new RegistrationPage(driver);
    }

}
