package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectScren {
    private WebDriver driver;
    private By createnewscreen=By.xpath("//p[contains(text(),'Create new screen')]");
    private By Screen=By.xpath("//body/div[@id='root']/div[1]/div[4]/div[1]/div[1]/h1[1]");

    private By screenBtn=By.xpath("//header/div[1]/div[1]/button[1]");
    private By widgetsBtn=By.xpath("//header/div[1]/div[1]/button[2]");
    private By triggersBtn=By.xpath("//header/div[1]/div[1]/button[3]");
    private By assetsBtn=By.xpath("//header/div[1]/div[1]/button[4]");
    public ProjectScren (WebDriver driver){
        this.driver=driver;
    }

    public String getScreenText(){
        return driver.findElement(Screen).getText();
    }
    public int countNumberOfButtons(){
        int numbers=0;
        driver.findElement(screenBtn);
        numbers=numbers+1;
        driver.findElement(widgetsBtn);
        numbers=numbers+1;
        driver.findElement(triggersBtn);
        numbers=numbers+1;
        driver.findElement(assetsBtn);
        numbers=numbers+1;

        return numbers;
    }
    public String getScreenButtonText(){
        return driver.findElement(screenBtn).getText();
    }
    public String getWidgetButtonText(){
        return driver.findElement(widgetsBtn).getText();
    }
    public String getTriggerButtonText(){
        return driver.findElement(triggersBtn).getText();
    }
    public String getAssetButtonText(){
        return driver.findElement(assetsBtn).getText();
    }
    public String getCreateNewScreenText(){
        return driver.findElement(createnewscreen).getText();
    }

}
