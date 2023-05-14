package quangtester.com.Bai16_ThucHanhCRM;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import quangtester.com.common.BaseTest;
import quangtester.com.keywords.WebUI;

public class LoginTest extends BaseTest {
    /*
        Đề bài :
            - Dùng SoftAssert
            - Viết hàm kiểm tra Visible (vừa tồn tại trong DOM vừa tồn trại trên UI)
            - Viết hàm kiểm tra Text cả Message
            - Verify 2 message Email và Password required hiển thị
            - Verify 2 message hiển thị đúng câu từ
    */


    @Test
    public void loginWithoutEmailAndPassword() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Khai báo SoftAssert
        SoftAssert softAssert = new SoftAssert();

        //Viết hàm kiểm tra Element tồn tại trong DOM
        boolean emailRequired = WebUI.checkElementExist_UseXpath(driver,"//form/div[1]");//Message Email required
        boolean passwordRequired = WebUI.checkElementExist_UseXpath(driver,"//form/div[2]");//Message Password required
        //In kết quả sau khi check, nếu có tồn tại sẽ trả về true
        System.out.println("Kết quả sau khi check Email tồn tại trong DOM là :" + emailRequired);
        System.out.println("Kết quả sau khi check Password tồn tại trong DOM là :" + passwordRequired);
        //Dùng Asserts kiểm tra có chứa dòng Message được require không
        softAssert.assertTrue(WebUI.checkElementExist_UseXpath(driver,"//form/div[1]"),"Message Email require is not exist");
        softAssert.assertTrue(WebUI.checkElementExist_UseXpath(driver,"//form/div[2]"), "Message Password require is not exist");
        System.out.println("-----------------------------------------");


        //Viết hàm kiểm tra Element hiển thị trên UI
        boolean messageEmailVisible = driver.findElement(By.xpath("//form/div[1]")).isEnabled();//Message Email enable
        boolean messagePasswordVisible = driver.findElement(By.xpath("//form/div[2]")).isEnabled();//Message Password enable
        //In kết quả sau khi check, nếu có tồn tại sẽ trả về true
        System.out.println("Kết quả sau khi check Email hiển thị trên UI là :" + messageEmailVisible);
        System.out.println("Kết quả sau khi check Password hiển thị trên UI là :" + messagePasswordVisible);
        //Dùng Asserts kiểm tra dòng Message có hiển thị không
        softAssert.assertTrue(messageEmailVisible,"Message Email no displays");
        softAssert.assertTrue(messagePasswordVisible,"Message Password no displays");
        System.out.println("-----------------------------------------");


        //Viết hàm kiểm tra Text cả Message
        String textForMessageEmailRequired = driver.findElement(By.xpath("//form/div[1]")).getText();
        String textForMessagePasswordRequired = driver.findElement(By.xpath("//form/div[2]")).getText();
        //In kết quả sau khi check, nếu có tồn tại sẽ trả về true
        System.out.println("Kết quả sau khi check text Email là :" + messageEmailVisible);
        System.out.println("Kết quả sau khi check text Password  là :" + messagePasswordVisible);
        //Dùng Asserts kiểm tra dòng Message có đúng với giá trị truyền vào không
        softAssert.assertEquals(textForMessageEmailRequired,"The Password field is required.","The text on message Email not match");
        softAssert.assertEquals(textForMessagePasswordRequired,"The Email Address field is required.","The text on message Password not match");

        //Dùng hàm assertAll() để hiển thị danh sách lỗi xác nhận các soft assert bên trên (nếu có lỗi)
        softAssert.assertAll();
    }
}
