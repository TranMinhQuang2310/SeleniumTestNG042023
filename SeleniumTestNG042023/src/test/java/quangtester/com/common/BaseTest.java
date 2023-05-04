package quangtester.com.common;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    @BeforeMethod
    public void createBrowser() {
        System.out.println("Start Chrome browser from BaseTest ... ");
        //Khởi dộng với Chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //chờ đợi ngầm để tìm kiếm element , nếu không tìm ra thì báo lỗi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void closeBrowser() {
        System.out.println("Close Chrome browser from BaseTest ... ");
        driver.quit();
    }

    //Cách khai báo hàm sleep để không bị gạch đỏ
    public void sleep(double seconds) {
        try{
            Thread.sleep((long) (1000 * seconds));
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
