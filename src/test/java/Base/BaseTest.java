package Base;

import Pages.HomePage;
import Pages.LoginPage;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeClass
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://172.16.11.119:3000/");
        driver.manage().window().maximize();
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);

    }
    @AfterMethod
    public void recordFailure(ITestResult result) throws IOException {
        if(ITestResult.FAILURE==result.getStatus()){
            var camera=(TakesScreenshot)driver;
            File screenshot=camera.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot taken: "+screenshot.getAbsolutePath());
            Files.move(screenshot,new File("Resources/Screenshots/"+result.getName()+".png"));
        }

    }
    /*@AfterClass
    public void emailSending() throws EmailException {
        EmailAttachment attachment1 = new EmailAttachment();
        EmailAttachment attachment2 = new EmailAttachment();
        attachment1.setPath("D:\\UnifyAutomation\\Resources\\Screenshots\\succusfullregistration.png");
        attachment2.setPath("D:\\UnifyAutomation\\test-output\\old\\index.html");
        attachment1.setDisposition(EmailAttachment.ATTACHMENT);
        attachment2.setDisposition(EmailAttachment.ATTACHMENT);
        attachment1.setDescription("Screenshots");
        attachment2.setDescription("index");
        attachment1.setName("Failed Test Screenshot");

        MultiPartEmail email = new MultiPartEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator("naveed.urrehman779@gmail.com", "Pak.03472468667n!"));
        email.setSSLOnConnect(true);
        email.setFrom("naveed.urrehman779@gmail.com");
        email.setSubject("Final email with index and Screenshots");
        email.setMsg("Hi Adnan Bhai,\nI am sending this email through selenium IDE, PFA index.html and Screenshots of the failed test cases, will share source files of the code on the progress thread \nThanks");
*//*        email.addTo("adnan.adil@avanzasolutions.com");
        email.addCc("asad.rasheed@avanzasolutions.com");
        email.addCc("farhan.ahmed@avanzasolutions.com");*//*
        email.addTo("naveed.rehman@avanzasolutions.com");
        email.attach(attachment1);
        email.attach(attachment2);
        email.send();
    }*/

    @AfterClass
    public void terminate(){
        driver.quit();
    }

}
