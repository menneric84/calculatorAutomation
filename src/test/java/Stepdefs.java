import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;


public class Stepdefs {
    private WebDriver driver;

    private String CALC_PATH = "C:\\Windows\\System32\\calc.exe";
    private String WINIUM_PATH = "http://localhost:9999";
    private int number1;
    private int number2;
    private String result;
    private DesktopOptions options;

    @Given("^I want to add \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iWantToAddTo(int number1, int number2) throws MalformedURLException {
        options = new DesktopOptions();
        options.setApplicationPath(CALC_PATH);
        driver = new WiniumDriver(new URL(WINIUM_PATH), options);
        this.number1 = number1;
        this.number2 = number2;
    }
    @When("I add")
    public void add(){
        driver.findElement(By.id("num7Button")).click();
        driver.findElement(By.id("plusButton")).click();
        driver.findElement(By.id("num3Button")).click();
        driver.findElement(By.id("equalButton")).click();
        result = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
    }

    @Then("^my answer should equal \"([^\"]*)\"$")
    public void myAnswerShouldEqual(String result){
        assertEquals(result, this.result);
    }

    @After
    public void cleanUp(){
        driver.findElement(By.id("Close")).click();
    }

}
