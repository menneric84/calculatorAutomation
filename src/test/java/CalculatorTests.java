import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class CalculatorTests {
    private WebDriver driver;

    private String CALC_PATH = "C:\\Windows\\System32\\calc.exe";
    private String WINIUM_PATH = "http://localhost:9999";

    @Before
    public void before() throws IOException {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(CALC_PATH);
        driver = new WiniumDriver(new URL(WINIUM_PATH), options);

    }
    @Test
    public void winiumAddtest() {
        driver.findElement(By.id("num7Button")).click();
        driver.findElement(By.id("plusButton")).click();
        driver.findElement(By.id("num3Button")).click();
        driver.findElement(By.id("equalButton")).click();
        String result = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
        Assert.assertEquals("Display is 10", result);

    }
//    @Test
//    public void winiumTest2() {
//        driver.findElement(By.id("tabControl")).findElement(By.id("supportTab")).click();
//        driver.findElement(By.id("tabControl")).findElement(By.id("datesTab")).click();
//    }
//    @Test
//    public void winiumTabTest1() {
//        tab.findElement(By.id("datesTab")).click();
//        tab.findElement(By.id("supportTab")).click();
//    }
//    @Test
//    public void winiumTabTest2() {
//        tab.findElement(By.id("supportTab")).click();
//        tab.findElement(By.id("datesTab")).click();
//    }
    @After
    public void cleanUp(){
        driver.findElement(By.id("Close")).click();
    }

    private static String resourcesFolder() {
        return new File("").getAbsolutePath() + "\\src\\main\\resources\\";
    }
}
