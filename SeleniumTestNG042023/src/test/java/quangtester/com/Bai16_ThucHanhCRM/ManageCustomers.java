package quangtester.com.Bai16_ThucHanhCRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.keywords.WebUI;

public class ManageCustomers extends BaseTest {
    @BeforeMethod
    public void loginCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    private String CUSTOMER_NAME = "DragonBall";
    private String WEBSITE = "https://cmcglobal.com.vn/vi/home-vi/";

    @Test
    public void addCustomer() {

        //Đợi trang Load xong mới nhấn vô
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();

        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();

        driver.findElement(By.xpath("//input[@id='company']")).sendKeys(CUSTOMER_NAME);

        driver.findElement(By.id("vat")).sendKeys("10");

        driver.findElement(By.id("phonenumber")).sendKeys("0123456789");

        driver.findElement(By.id("website")).sendKeys(WEBSITE);

        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']")).sendKeys("Gold", Keys.ENTER);
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();

        WebUI.sleep(1);
        driver.findElement(By.id("address")).sendKeys("Viet Nam");
        driver.findElement(By.id("city")).sendKeys("Can Tho");
        driver.findElement(By.id("state")).sendKeys("Can Tho");
        driver.findElement(By.id("zip")).sendKeys("92000");

        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div")).click();

        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']")).sendKeys("Vietnam", Keys.ENTER);

        WebUI.sleep(1);
        driver.findElement(By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']")).click();
        WebUI.waitForPageLoaded(driver);

        WebUI.sleep(1);

        //Lấy name trong ô input của field Company sau khi Lưu
        String getCompanyNameInDetail = driver.findElement(By.xpath("//input[@id='company']")).getAttribute("value");
        System.out.println("Name trong ô input của field Company sau khi Lưu là :" +getCompanyNameInDetail);
        //Kiểm tra xem name trong ô input của field Company sau khi Lưu có đúng với dữ liệu nhập vào không
        Assert.assertEquals(getCompanyNameInDetail,CUSTOMER_NAME,"Failed . Customer Name not match");

        //Nhấn lại vào field Customer sau đó thực hiện search
        WebUI.waitForPageLoaded(driver);
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//input[@class='form-control input-sm']")).sendKeys(CUSTOMER_NAME);
        WebUI.waitForPageLoaded(driver);
        WebUI.sleep(1);
        //Lấy dòng đầu tiên trong bảng
        String getCompanyNameOnTable = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a")).getText();
        System.out.println("Name dòng đầu tiên của Bảng là :" + getCompanyNameOnTable);
        Assert.assertEquals(getCompanyNameOnTable,CUSTOMER_NAME,"Failed . Customer Name on Table not match");

        verifyCustomerAdded();
    }

    // Thực hiện :  Open field Projects để verify lại Customer vừa Add (Projects -> New project -> Dropdown Customer)
    public void verifyCustomerAdded() {
        //Click vô field Project
        driver.findElement(By.xpath("//span[normalize-space()='Projects']")).click();
        //Nhấn vào "New Project"
        driver.findElement(By.xpath("//a[normalize-space()='New Project']")).click();
        //Nhấn vào Dropdown thuộc Customer
        WebUI.sleep(2);
        driver.findElement(By.xpath("//label[@for='clientid']/following-sibling::div")).click();
        //Nhập giá trị vào ô input để search sau đó enter
        driver.findElement(By.xpath("//label[@for='clientid']/following-sibling::div//input")).sendKeys(CUSTOMER_NAME);
        //Click vào kết quả đầu tiên sau khi được tìm kiếm
        WebUI.sleep(2);
        driver.findElement(By.xpath("//div[@id='bs-select-6']//ul[@role='presentation']")).click();
        WebUI.sleep(2);
        //Lấy title của dropdown sau khi chọn giá trị
        String getCustomerTitle = driver.findElement(By.xpath("//label[@for='clientid']/following-sibling::div//button[@data-id='clientid']")).getText();
        System.out.println("Tittle trong ô input của dropdown sau khi chọn  là :" + getCustomerTitle);
        Assert.assertEquals(getCustomerTitle,CUSTOMER_NAME,"Failed . Customer Name on Dropdown not match");


        WebUI.sleep(1);
    }
}
