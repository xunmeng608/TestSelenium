package First.TestSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest1 {
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
    public void f1() throws Exception
    {
        System.out.println("备注66666666666666666666666666");
        System.out.println("9999999999999999999999999999999999990000000000000000000");
       WebElement element= driver.findElement(By.id("kw"));
       element.sendKeys("selenium");
       driver.findElement(By.id("su")).click();
       
       Thread.sleep(5000);
       driver.close();
    }

}
