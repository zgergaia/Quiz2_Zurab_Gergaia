import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.List;

public class Quiz2Test {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void task1() {
        driver.get("https://demoqa.com/progress-bar");
        WebElement startBtn = driver.findElement(By.xpath("//button[text()='Start']"));
        startBtn.click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'100%')]")));
        System.out.println("100%");
    }

    @Test
    public void task2() {
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdowm-menu-1']")));
        dropdown.selectByIndex(1);
        System.out.println(dropdown.getFirstSelectedOption().getText());

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input:not(:checked)[type='checkbox']"));
        for(WebElement i : checkboxes) {
            i.click();
        }
        WebElement yellow = driver.findElement(By.xpath("//input[@value='yellow']"));
        yellow.click();

        Select dropdown2 = new Select(driver.findElement(By.xpath("//select[@id='fruit-selects']")));
        List<WebElement> options2 = dropdown2.getOptions();
        System.out.println(options2.get(1).isEnabled());

    }

    @Test
    public void task3() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(0);
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
        WebElement p = driver.findElement(By.tagName("p"));
        p.clear();
        p.sendKeys("Here Goes");

        driver.switchTo().defaultContent();
        WebElement align_center = driver.findElement(By.xpath("//button[@title='Align center']"));
        align_center.click();
    }
}