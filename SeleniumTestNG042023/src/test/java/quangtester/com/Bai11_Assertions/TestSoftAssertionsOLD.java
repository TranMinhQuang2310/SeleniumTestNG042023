package quangtester.com.Bai11_Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import quangtester.com.common.BaseTest_OLD;

public class TestSoftAssertionsOLD extends BaseTest_OLD {

    /*
        VD1 : Tạo testcase so sánh giữa kết quả thực tế và mong đợi có bằng với nhau hay không
           => Nếu BẰNG nhau , in dòng "VD1 Thành công"
           => Nếu KHÔNG BẰNG nhau , vẫn cho chạy tiếp đến hết sau đó mới báo lỗi
          *** Ban đầu điền đại giá trị vô biến expectedTitle , Run xong thấy đoạn Actual thì copy đè vô giá trị vừa điền
    */

    @Test
    public void testSoftAssert() throws InterruptedException {
        driver.get("https://rise.fairsketch.com/signin");

        // Bắt xpath tiêu đề ở trang Đăng Nhập
        String headerSignInPage = driver.findElement(By.xpath
                ("//div[@class='card-header text-center']//h2[normalize-space() = 'Sign in']")).getText();

        SoftAssert softAssert = new SoftAssert();
        //Thực hiện so sánh bằng
        softAssert.assertEquals(headerSignInPage, "Sign in 123","Header Sign In Page chưa đúng");

        // click vào nút Sign in
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();

        //Bắt xpath tab menu "Client" trên thanh left menu
        WebElement menuClient  = driver.findElement(By.xpath("//span[normalize-space()='Clients']"));

        //Thực hiện kiểm tra xem menu Clients có hiển thị hay không
        softAssert.assertTrue(menuClient.isDisplayed(),"Menu Client không hiển thị");

        //Click vào nút menu Clients nếu có hiển thị
        menuClient.click();

        //Bắt xpath của mục Total clients
        WebElement headerTotalClient = driver.findElement(By.xpath("//a[normalize-space()='Overview']"));

        //Thực hiện kiểm tra xem Header Total Client có được bật hay không
        softAssert.assertTrue(headerTotalClient.isEnabled(),"Header Total Client không được bật");

        //Thực hiện so sánh bằng
        softAssert.assertEquals(headerTotalClient.getText(),"Sele", "Content của header Total Client không giống nhau");

        //Cuối cùng của SoftAssert là PHẢI DÙNG hàm assertAll() để hiển thị danh sách lỗi xác nhận các soft assert bên trên (nếu có lỗi)
        softAssert.assertAll();

    }
}
