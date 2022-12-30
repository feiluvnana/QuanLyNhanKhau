package handler;

import javax.swing.*;
import java.sql.*;

public class Page extends JLabel{
    public enum PageType {COVER, HOUSEHOLDER, MEMBER};
    public Page(PageType type, ResultSet rs) {
        if(type == PageType.COVER) {
            String text = new String();
            text += "<html>";
            text += "<div style=\"width:590px;\">";
            text += "<p style=\"font-size:20px;text-align:center;margin-top:5px;margin-bottom:5px\">SỔ HỘ KHẨU GIA ĐÌNH</p>";
            text += "<p style=\"font-size:14px;text-align:center;\">Số: 973453203</p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Họ tên chủ hộ: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Số nhà/xóm: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Đường phố/thôn/ấp: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Xã/Phường/Thị Trấn: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Quận/Huyện: </p>";
            text += "</div>";
            text += "</html>";
            this.setText(text);
            this.setVerticalAlignment(JLabel.TOP);
        }
        else if(type == PageType.HOUSEHOLDER) {
            String text = new String();
            text += "<html>";
            text += "<div style=\"width:590px;\">";
            text += "<p style=\"font-size:20px;text-align:center;margin-top:5px;margin-bottom:5px\">Chủ Hộ</p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Họ tên: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Bí danh: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Ngày/tháng/năm sinh: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Giới tính: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Nguyên quán: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Dân tộc: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Quốc tịch: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Nghề nghiệp: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Nơi làm việc: </p>";
            text += "<p style=\"font-size:12px;text-align:left;\">Nơi thường trú trước khi chuyển đến: </p>";
            text += "</div>";
            text += "</html>";
            this.setText(text);
            this.setVerticalAlignment(JLabel.TOP);
        }
    }
}
