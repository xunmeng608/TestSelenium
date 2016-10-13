package First.TestSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
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
    public void f() throws Exception
    {
        System.out.println("备注9998888888888");
       WebElement element= driver.findElement(By.id("kw"));
       element.sendKeys("����");
       driver.findElement(By.id("su")).click();
       
       Thread.sleep(5000);
       driver.close();
    }


 

}
