package BleBle;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InterviewApplicationTest {
    private WebDriver driver;
    private WebDriverWait wait;


//    W ogole wykomentowane, bo niepotrzebne w Selenium4 - ono ma wlasnego managera
//    Odpowiednio tez skasowalem z POMa zaleznosc
//
//    @BeforeClass
//    public static void setupChromeDriver(){
//        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
//    }

    @Before
    public void chromeDefault() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://examples.bootstrap-table.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void getNumbersOfTableHeadersTest() {
        //given
        By header = By.cssSelector(".fixed-table-header .th-inner");
        WebElement myIframe = driver.findElement(By.cssSelector("iframe"));
        //when
        driver.switchTo().frame(myIframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(header));
        int numbersOfTableHeaders = driver.findElements(header).size();
        //then
        Assert.assertEquals("Number of table headers is incorrect", 6, numbersOfTableHeaders);
    }
}