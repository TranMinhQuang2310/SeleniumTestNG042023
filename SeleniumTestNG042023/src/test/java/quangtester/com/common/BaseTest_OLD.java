package quangtester.com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest_OLD {
    public WebDriver driver;
    @BeforeMethod
    public void createBrowser() {
        System.out.println("Start Chrome browser from BaseTest_OLD ... ");
        //Khởi dộng với Chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //chờ đợi ngầm định cho từng câu lệnh tìm kiếm driver.findElement()=> 1 case fail : nếu không tìm ra trong 10s thì báo lỗi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //chờ đợi cả Trang load xong (bao gồm load cả HTML,CSS,JS,...) => Set thời gian nhiều hơn implicitlyWait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void closeBrowser() {
        // Reset Implicit Wait (thay đổi thời gian chờ đợi về 0) trong trường hợp muốn 1 đoạn nào trong source không cần chờ đợi
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        System.out.println("Close Chrome browser from BaseTest_OLD ... ");
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
