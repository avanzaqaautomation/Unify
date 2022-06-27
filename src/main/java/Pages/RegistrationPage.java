package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationPage {
    private WebDriver driver;
    private By fullnamebox= By.xpath("//input[@id='fullName']");
    private By usernamebox=By.xpath("//input[@id='userName']");
    private By emailbox=By.xpath("//input[@id='email']");
    private By password1Box=By.xpath("//input[@id='password']");
    private By password2Box=By.xpath("//input[@id='confirmPassword']");
    private By submitButton=By.xpath("//body/div[@id='root']/div[1]/div[1]/main[1]/div[1]/form[1]/div[1]/div[5]/div[1]/button[1]");

    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
    }

    public void writeFullName(){
        driver.findElement(fullnamebox).sendKeys("naveed1234");
    }
    public void writeUserName(){
        driver.findElement(usernamebox).sendKeys("naveed1234");
    }
    public void writeEmail(){
        driver.findElement(emailbox).sendKeys("nepada8272@aikusy.com");
    }
    public void writePass1(){
        driver.findElement(password1Box).sendKeys("Pakistan.123456@");
    }
    public void writePass2(){
        driver.findElement(password2Box).sendKeys("Pakistan.123456@");
    }
    public SuccessPage clickSubmit(){
        driver.findElement(submitButton).click();
        return new SuccessPage(driver);
    }

}
