package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class loginDefination {


    WebDriver driver ;

    @Given("User should navigate to the application")
    public void userShouldNavigateToTheApplication() {
       driver = new ChromeDriver();
       driver.get("https://bookcart.azurewebsites.net/");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Given("User should go to the login page")
    public void userShouldGoToTheLoginPage() {
        WebElement login = driver.findElement(By.xpath("//span[normalize-space()='Login']"));
        login.click();
    }
//    @Given("User should enter the username Admin")
//    public void userShouldEnterTheUsernameAdmin() {
//
//        WebElement userName = driver.findElement(By.id("mat-input-0"));
//        userName.sendKeys("myTest");
//    }
//    @Given("User should enter the password admin123")
//    public void userShouldEnterThePasswordAdmin123() {
//
//        WebElement password = driver.findElement(By.id("mat-input-1"));
//        password.sendKeys("myTest123");
//    }
    @When("User click the login button")
    public void userClickTheLoginButton() {
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-login[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-card-actions[1]/button[1]/span[2]")).click();
    }
    @Then("Login should be Success")
    public void loginShuoldBeSuccess() {
       String verify = driver.findElement(By.xpath("//span[contains(text(),'myTest')]")).getText();
       if (verify.equals("myTest")){
           System.out.println("Success");
       }else {
           System.out.println("failed");
       }


    }

//    @Given("User should enter the username as mif")
//    public void userShouldEnterTheUsernameAsMif() {
//        WebElement userName = driver.findElement(By.id("mat-input-0"));
//        userName.sendKeys("mif");
//    }
//    @Given("User should enter the password as myTest123")
//    public void userShouldEnterThePasswordAsMyTest123() {
//
//        WebElement password = driver.findElement(By.id("mat-input-1"));
//        password.sendKeys("myTest123");
//    }
    @Then("Login should be Fail")
    public void loginShouldBeFail() {
       String err = driver.findElement(By.id("mat-mdc-error-0")).getText();
       if (err.equals("Username or Password is incorrect.")){
           System.out.println("failed");
       }else {
           System.out.println("something went wrong");
       }
    }

    @Given("User should enter the username as {string}")
    public void userShouldEnterTheUsernameAs(String username) {
        WebElement userName = driver.findElement(By.id("mat-input-0"));
   userName.sendKeys(username);
    }
    @Given("User should enter the password as {string}")
    public void userShouldEnterThePasswordAs(String password) {
        WebElement pas = driver.findElement(By.id("mat-input-1"));
       pas.sendKeys(password);
    }






}
