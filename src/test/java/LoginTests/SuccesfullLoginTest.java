package LoginTests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LogoutSummaryPage;
import Pages.RegistrationPage;
import Pages.SuccessPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class SuccesfullLoginTest extends BaseTest {
    /*WebDriver driver=new ChromeDriver();
    HomePage homePage=new HomePage(driver);*/
@Test (priority = 1)
    public void successfullLoginTest() throws InterruptedException {

    loginPage.writeUsername("naveed779");
        loginPage.writePassword("Pakistan.652021");
        HomePage homePage=loginPage.clickSignIn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue(homePage.getWelcomeText().contains("Create new project"),"Alert Text incorrect");
}
@Test (priority = 2)
public void WebApplicationCreation(){
    homePage.createNewProject();
    assertTrue(homePage.popUpText().contains("Project Created Successfully"),"Text Not Found");
}
@Test(enabled = false)
    public void successfullLogoutTest(){
/*    loginPage.writeUsername("naveed779");
    loginPage.writePassword("Pakistan.652021");
    HomePage homePage=loginPage.clickSignIn();*/

    LogoutSummaryPage summary=homePage.clickLogout();
    assertTrue(summary.logoutSummaryText().contains("Logout Session Summary"),"Wrong logout summary");
}
@Test (enabled = false)
    public void succusfullregistration(){
    RegistrationPage RP=loginPage.clickRegisterLink();
    RP.writeFullName();
    RP.writeUserName();
    RP.writePass1();
    RP.writePass2();
    RP.writeEmail();
    SuccessPage SP=RP.clickSubmit();
    assertTrue(SP.getTextOfActivationAlert().contains("An activation link has been sent to your email add"),"Wrong");

}
}
