
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;


public class Stepdefs {
    private WebDriver driver;

    private String CALC_PATH = "C:\\Windows\\System32\\calc.exe";
    private String WINIUM_PATH = "http://localhost:9999";
    private int number1;
    private int number2;
    private String result;
    private DesktopOptions options;

    @Before()
    public void beforeScenarioStart() throws MalformedURLException {
        options = new DesktopOptions();
        options.setApplicationPath(CALC_PATH);
        driver = new WiniumDriver(new URL(WINIUM_PATH), options);
    }

    @Given("^I want to add \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iWantToAddTo(int number1, int number2) {
        System.out.println(number1);
        System.out.println(number2);
        this.number1 = number1;
        this.number2 = number2;
    }

    @When("I add")
    public void add() {
        driver.findElement(By.id("num" + number1 + "Button")).click();
        driver.findElement(By.id("plusButton")).click();
        driver.findElement(By.id("num" + number2 + "Button")).click();
        driver.findElement(By.id("equalButton")).click();
        result = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
    }

    @Then("^my answer should equal \"([^\"]*)\"$")
    public void myAnswerShouldEqual(String result) {
        assertEquals(result, this.result);
    }

    @After
    public void cleanUp() throws InterruptedException {
        driver.findElement(By.id("Close")).click();
    }

    @Given("^I want to subtract \"([^\"]*)\" from \"([^\"]*)\"$")
    public void iWantToSubtractFrom(int number1, int number2) throws Throwable {
        options = new DesktopOptions();
        options.setApplicationPath(CALC_PATH);
        driver = new WiniumDriver(new URL(WINIUM_PATH), options);
        this.number1 = number1;
        this.number2 = number2;
    }

    @When("^I subtract$")
    public void iSubtract() throws Throwable {

        driver.findElement(By.id("num" + number1 + "Button")).click();
        driver.findElement(By.id("minusButton")).click();
        driver.findElement(By.id("num" + number2 + "Button")).click();
        driver.findElement(By.id("equalButton")).click();
        result = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
    }
}
