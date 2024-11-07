package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class addToCardDefination {
    WebDriver driver ;
    @Given("User should navigate to the app")
    public void userShouldNavigateToTheApp() {
        driver = new ChromeDriver();
        driver.get("https://bookcart.azurewebsites.net/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Given("User should login  to application as {string} and {string}")
    public void userShouldLoginToApplicationAsAnd(String username, String password) {
        WebElement login = driver.findElement(By.xpath("//span[normalize-space()='Login']"));
        login.click();
        WebElement userName = driver.findElement(By.id("mat-input-0"));
        userName.sendKeys(username);
        WebElement pas = driver.findElement(By.id("mat-input-1"));
        pas.sendKeys(password);
        driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/div[1]/app-login[1]/div[1]/mat-card[1]/mat-card-content[1]/form[1]/mat-card-actions[1]/button[1]/span[2]")).click();
    }
    @Given("User should  Search the {string}")
    public void userShouldSearchThe(String searchKey) {
        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search books or authors']"));
        search.sendKeys(searchKey);
    }
    @Given("User Add to the book in Card")
    public void userAddToTheBookInCard() {
        driver.findElement(By.cssSelector("button[color='primary']")).click() ;
    }
    @Then("The Card Should Be Updated")
    public void theCardShouldBeUpdated() {

        String txt = driver.findElement(By.cssSelector("#mat-badge-content-0")).getText();
        int cnt = Integer.parseInt(txt)+1;
        Assert.assertEquals(cnt > 0 ,true);
    }

}
