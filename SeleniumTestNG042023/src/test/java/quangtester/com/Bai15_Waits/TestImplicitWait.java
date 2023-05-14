package quangtester.com.Bai15_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestImplicitWait {
    WebDriver driver;
    @Test
    public void ImplicitWaitDemo() {
        //Khởi dộng với Chrome driver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //chờ đợi ngầm định cho từng câu lệnh tìm kiếm driver.findElement()=> 1 case fail : nếu không tìm ra trong 10s thì báo lỗi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://app.hrsale.com/");
        driver.findElement(By.id("iusername")).sendKeys("frances.burns");
        driver.findElement(By.id("ipassword")).sendKeys("frances.burns");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu Projects
        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();

        driver.quit();
    }
}
