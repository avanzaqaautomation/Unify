package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage {
    private WebDriver driver;
    private By emailactivationalert= By.xpath("//h6[contains(text(),'An activation link has been sent to your email add')]");


    public SuccessPage(WebDriver driver){
        this.driver=driver;
    }

    public String getTextOfActivationAlert(){
        return driver.findElement(emailactivationalert).getText();
    }
}

