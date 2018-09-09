package seleniumgluecode;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import org.junit.Assert;

public class Test {
    public static WebDriver driver;
    @Given("^user is on homepage$")
    public void user_is_on_homepage()  throws Throwable {  
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\dvillur2\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	//System.setProperty("webdriver.gecko.driver","/Users/Documents/geckodriver");
       //driver = new FirefoxDriver();
    	//ChromeOptions opts = new ChromeOptions();
        //opts.setExperimentalOption("useAutomationExtension", false);
    	driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://newtours.demoaut.com/");
    }
    
    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
        driver.findElement(By.linkText("SIGN-ON")).click();
    }
    
    @When("^user enters username and Password$")
    public void user_enters_username_and_Password() throws Throwable {
    	driver.findElement(By.name("userName")).sendKeys("diwakar");
    	Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("testing@1987");
        Thread.sleep(2000);
        driver.findElement(By.name("login")).click();   
        Thread.sleep(2000);
    }
    
    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
//String exp_message = "Welcome back to Mercury Tours! Enter your user information to access the member-only areas of this site. If you don't have a log-in, please fill out the registration form.";

String bodyText = driver.findElement(By.tagName("body")).getText();
String text= ("Welcome back to Mercury Tours!");
Assert.assertTrue("Welcome back to Mercury Tours!", bodyText.contains(text));
    	//String Stringactual = driver.findElement(By.cssSelector(".info-account")).getText();
        //Assert.assertEquals(exp_message, Stringactual);
        driver.quit();  
        
      /*  @Given("^user is on homepages$")
        public void user_is_on_homepages() throws Throwable { 
        	System.setProperty("webdriver.chrome.driver", "C:\\Users\\dvillur2\\Downloads\\chromedriver_win32\\chromedriver.exe");
        	//System.setProperty("webdriver.gecko.driver","/Users/Documents/geckodriver");
           //driver = new FirefoxDriver();
        	//ChromeOptions opts = new ChromeOptions();
            //opts.setExperimentalOption("useAutomationExtension", false);
        	driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://newtours.demoaut.com/");
        }
        
        @When("^user navigates to Login Pagee$")
        public void user_navigates_to_Login_Pagee() throws Throwable {
            driver.findElement(By.linkText("SIGN-ON")).click();
        }*/
    }      
}