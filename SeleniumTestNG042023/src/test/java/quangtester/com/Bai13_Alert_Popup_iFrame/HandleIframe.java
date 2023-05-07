package quangtester.com.Bai13_Alert_Popup_iFrame;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;

public class HandleIframe extends BaseTest {
    @Test
    public void iFrame01() {
        //Giống như driver.get("");
        driver.get("https://anhtester.com/contact");
        sleep(15);

        //Tồng iframe trong trang
        System.out.println("Tồng iframe trong trang :" + driver.findElements(By.tagName("iframe")).size());

        //Switch vào iframe thuộc messenger
            //Cách xác định thứ tự : F12 => ctrl + F => gõ //iframe => Xem thứ của messenger thứ mấy
        driver.switchTo().frame(0);
        sleep(2);

        //In textName của messenger
        System.out.println("TextName của Messenger là :" + driver.findElement(By.tagName("strong")).getText());
        sleep(2);

        //----Switch to icon of Messenger---------

        //1. Chuyển về Parent Frame (Khung chính không thuộc thẻ iframe nào cả)
        driver.switchTo().parentFrame();

        //2. Switch to iframe icon of Messenger
            //Cách xác định thứ tự : F12 => ctrl + F => gõ //iframe => Xem thứ của messenger thứ mấy
        driver.switchTo().frame(1);
        driver.findElement(By.tagName("svg")).click();//Nhấn icon để ẩn messenger chat đi
    }
}
