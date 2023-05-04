package quangtester.com.Bai10_AnnotationTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class MoBrowserMotLan {

    //@BeforeTest hoặc @BeforeClass
    WebDriver driver;
    @BeforeClass
    public void createBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //chờ đợi ngầm để tìm kiếm element , nếu không tìm ra thì báo lỗi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    //Tạo 1 testcase
    @Test(priority = 1) //priority là độ ưu tiên
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }

    //Tạo 1 testcase
    @Test(priority = 2)//priority là độ ưu tiên
    public void testAnhTesterLogin() throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='btn-login']")).click();
        Thread.sleep(1000);
        System.out.println("Tên Page là :" + driver.findElement(By.xpath("//h2[normalize-space()='Login']")).getText());
        Thread.sleep(1000);
    }

    //AfterTest hoặc AfterClass
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
