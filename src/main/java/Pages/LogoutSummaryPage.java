package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutSummaryPage {
    private WebDriver driver;
    private By logouttext= By.xpath("//h1[contains(text(),'Logout Session Summary')]");

    public LogoutSummaryPage(WebDriver driver){
        this.driver=driver;
    }
    public String logoutSummaryText(){
        return driver.findElement(logouttext).getText();
    }
}
