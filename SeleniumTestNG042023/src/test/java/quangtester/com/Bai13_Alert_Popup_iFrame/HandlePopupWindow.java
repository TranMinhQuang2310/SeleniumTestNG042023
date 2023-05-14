package quangtester.com.Bai13_Alert_Popup_iFrame;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import quangtester.com.common.BaseTest_OLD;

import java.util.Set;

public class HandlePopupWindow extends BaseTest_OLD {
    //VD1 : Chuyển sang tab window mới sau đó nhập giá trị vào ô textbox
    @Test
    public void TestPopup02() {
        driver.get("https://demo.guru99.com/popup.php");
        sleep(2);

        //Nhấn vào nút Click here
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        //Khai báo biến để lưu ID của cửa sổ hiện tại => Lưu lại lớp window đầu tiên (mã ID hơi dài, in ra sẽ thấy)
        String MainWindow = driver.getWindowHandle();
        //In ra mã ID
        System.out.println("Mã ID cửa sổ hiện tại là :" + MainWindow);

        //Lấy toàn bộ tab Window đã mở
        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp => Để lưu ID của tất cả các tab Window đang mỏ
        Set<String> windows = driver.getWindowHandles();
        System.out.println("Mã ID cửa sổ toàn bộ tab đang mở là :" +windows);

        ///Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for(String Duyetwindow : windows) {
            System.out.println("Mã ID của 2 cửa sổ Chính và Phụ là :" + Duyetwindow);
            /*
                Kiểm tra Mainwindow (window đầu tiên) có BẰNG với windows(toàn bộ Window đã mở) hay không
                    => Nếu KHÁC thì sẽ lấy ,nếu BẰNG thì bỏ qua
            */
            if(!MainWindow.equals(Duyetwindow)) {
                /*
                    Lấy từng giá trị(ID) trong Set đem đi so sánh nếu thằng nào KHÔNG BẰNG thằng Chính (là thằng Mainwindow)
                thì chuyển hướng qua nó mới thao tác được
                */
                //Thực hiện switch tới các tab Window phụ
                driver.switchTo().window(Duyetwindow);
                sleep(2);
                System.out.println("Đã chuyển đến lớp Window con");

                //Một số hàm hỗ trợ
                    //Hàm lấy title của tab Window Phụ
                System.out.println(driver.switchTo().window(Duyetwindow).getTitle());
                    //Hàm lấy link url của tab Window Phụ
                System.out.println(driver.switchTo().window(Duyetwindow).getCurrentUrl());

                //Sau khi chuyển hướng xong bắt đầu cho nhập vào field text
                driver.findElement(By.name("emailid")).sendKeys("abc@gmnail.com");
                //Nhấn button submit
                driver.findElement(By.name("btnLogin")).click();
                sleep(2);

                //Get text trang sau khi Submit
                System.out.println("Lấy và Xuất đoạn Text :" + driver.findElement(By.xpath("//table//td//h2")).getText());

                //Close tab Window phụ
                sleep(2);
                driver.close();
            }
        }

        //Switch lại về Tab chính (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính :" + driver.getCurrentUrl());
        sleep(2);
    }

}
