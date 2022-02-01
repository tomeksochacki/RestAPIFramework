import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tests {

    final String URL = "https://trello.com/";
    protected static WebDriver driver;
    protected WebDriverWait webDriverWait;
    //protected MainPange mainPange;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //mainPange = new MainPage(driver);
        driver.navigate().to(URL);
    }

    @Test
    public void wikiTest() {
        setUp();
        webDriverWait = new WebDriverWait(driver, 10);
        driver.get(URL);
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "Trello");
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log in")));
        driver.findElement(By.partialLinkText("Log in")).click();
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='user']")));
        webDriverWait.until(ExpectedConditions.visibilityOf((WebElement) By.cssSelector("[class=form-field]")));

    }

    public static boolean veryfiElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
            return false;
        }
    }

    @After
    public void tearDown() {
        //driver.quit();
        System.out.println("Test ended");
    }
}
