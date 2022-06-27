package UnifyNewProjectCreation;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProjectScren;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

public class NewProjectTesting extends BaseTest {
    ProjectScren ps=new ProjectScren(driver);
    @Test (priority = 0)
    public void successNewProjectOpen() throws InterruptedException {
        homePage=loginPage.clickSignIn();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
        homePage.clickWebBtn();
        homePage.clickNextBtn();
        ps=homePage.clickOpenBtn();
        assertTrue(ps.getScreenText().contains("Screens"),"Wrong text");
    }
    @Test (priority = 1)
    public void verificationOfNoOfButtons(){
        int n=ps.countNumberOfButtons();
        if(n==4){
            assertSame(n,n,"Four Buttons are present");
        }
    }
    @Test (priority = 2)
    public void verificationOfScreenButton(){
        assertTrue(ps.getScreenButtonText().contains("Screens"),"Screen Button not present");
    }
    @Test (priority = 3)
    public void verificationOfWidgetButton(){
        assertTrue(ps.getWidgetButtonText().contains("Widgets"),"Screen Button not present");
    }
    @Test (priority = 4)
    public void verificationOfTriggerButton(){
        assertTrue(ps.getTriggerButtonText().contains("Triggers"),"Screen Button not present");
    }
    @Test (priority = 5)
    public void verificationOfAssetButton(){
            assertTrue(ps.getAssetButtonText().contains("Assets"),"Screen Button not present");
    }
    @Test (priority = 6)
    public void verificationOfCreateNewScreenButton(){
        assertTrue(ps.getCreateNewScreenText().contains("Create new screen"),"Screen Button not present");

    }
}
