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
  	  System.setProperty("webdriver.chrome.bin","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");/*(Ĭ�ϰ�װ�����������Ҫд��δ���)*/
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
        System.out.println("he����");
        By inputBox = By.id("kw");
        By searchButton = By.id("su");

        //���ܵȴ�Ԫ�ؼ��س���
        intelligentWait(driver, 10, inputBox);
        //���ܵȴ�Ԫ�ؼ��س���
        intelligentWait(driver, 10, searchButton);
        driver.findElement(inputBox).sendKeys("�й�");
        driver.findElement(searchButton).click();

    }


    /**�������ܵȴ�Ԫ�ؼ��صķ���*/
    public void intelligentWait(WebDriver driver,int timeOut, final By by) {
        try {
            (new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    WebElement element = driver.findElement(by);
                    return element.isDisplayed();
                }
            });


        } catch (TimeoutException e) {
        Assert.fail("��ʱL !! " + timeOut + " ��֮��û�ҵ�Ԫ�� [" + by + "]", e);
        }
    }
}
