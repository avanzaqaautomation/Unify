package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private By nameTxt=By.xpath("//input[@id='name']");
    private By saveBtn=By.xpath("/html/body/div[10]/div[3]/div[1]/div[2]/button[2]");
    private By popup=By.xpath("//div[contains(text(),'Project Created Successfully')]");
    private By webApplicationIcon=By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/p[1]/div[2]/div[1]/div[1]/div[1]");
    private By createBtn=By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/p[1]/div[3]/button[1]");
    private By logoutButton= By.xpath("//header/div[1]/div[5]/button[2]/*[1]");
    private  By welometext=By.xpath("//body/div[@id='root']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/p[1]/div[1]/h2[1]");


    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public LogoutSummaryPage clickLogout(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(logoutButton).click();
        return new LogoutSummaryPage(driver);
    }
    public String getWelcomeText(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

        return driver.findElement(welometext).getText();
    }
    public void createNewProject(){
      /* WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(webApplicationIcon));*/
        driver.findElement(webApplicationIcon).click();
        driver.findElement(createBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(nameTxt));
        driver.findElement(nameTxt).sendKeys("pkpk");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.elementToBeClickable(saveBtn));
        driver.findElement(saveBtn).click();
    }
    public String popUpText(){
        return driver.findElement(popup).getText();
    }
}
