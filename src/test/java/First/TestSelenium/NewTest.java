package First.TestSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	private WebDriver driver;



    @BeforeTest
    public void beforeTest(){
  	  System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");/*(默认安装的浏览器不需要写这段代码)*/
  	  System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe");
  	driver=new ChromeDriver();
  	driver.get("http://www.baidu.com/");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void f()
    {
        System.out.println("he您好");
        By inputBox = By.id("kw");
        By searchButton = By.id("su");

        //智能等待元素加载出来
        intelligentWait(driver, 10, inputBox);
        //智能等待元素加载出来
        intelligentWait(driver, 10, searchButton);
        driver.findElement(inputBox).sendKeys("中国");
        driver.findElement(searchButton).click();

    }


    /**这是智能等待元素加载的方法*/
    public void intelligentWait(WebDriver driver,int timeOut, final By by) {
        try {
            (new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    WebElement element = driver.findElement(by);
                    return element.isDisplayed();
                }
            });


        } catch (TimeoutException e) {
        Assert.fail("超时L !! " + timeOut + " 秒之后还没找到元素 [" + by + "]", e);
        }
    }
}
