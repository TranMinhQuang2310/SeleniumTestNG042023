package quangtester.com.TestRunXMLByPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RunTestNG03 {
    WebDriver driver;

    @BeforeMethod
    public void createDriver() {
        //WebDriverManager.firefoxdriver().setup();
        //=> Khi có framework testNG thì không cần dùng thư viện WebdriverManager nữa (kể từ version selenium 4.0.6)

        //Khởi dộng với Chrome driver
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        //chờ đợi ngầm để tìm kiếm element , nếu không tìm ra thì báo lỗi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    //Tạo 1 testcase
    @Test
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }

    //Tạo 1 testcase
    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("anhtester", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester Automation Testing']")).click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void closeDriver() {
       driver.quit();
    }
}
