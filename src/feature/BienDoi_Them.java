package feature;

import javax.swing.*;
import java.sql.*;
import handler.*;
import storage.QuerySample;
import storage.URL;
import java.awt.*;
import java.awt.event.*;

public class BienDoi_Them extends JPanel {
    public BienDoi_Them(){
        JPanel part2 = new JPanel();
        JPanel part3 = new JPanel(); 
        JPanel part2Holder = new JPanel();
        JPanel part3Holder = new JPanel();
        JPanel part4Holder = new JPanel();

        //Panel part1
        JPanel part1 = new JPanel();
        part1.setLayout(new BoxLayout(part1, BoxLayout.X_AXIS));
            //Item for part1
            part1.add(Box.createRigidArea(new Dimension(5,22)));
            JLabel tieuDeLyDoThem = new JLabel("Lý do thêm nhân khẩu: ");
            part1.add(tieuDeLyDoThem);
            JComboBox<String> lyDoThem = new JComboBox<>(new String[] {"----------", "Mới ra đời", "Chuyển tới", "Tạm trú"});
            lyDoThem.setSelectedItem("Chọn lý do");
            lyDoThem.setMaximumSize(new Dimension(95, 22));
            lyDoThem.addItemListener(new ItemListener(){
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(!lyDoThem.getSelectedItem().equals("----------")) {
                        lyDoThem.removeItem("----------");
                        ((CardLayout) part2Holder.getLayout()).show(part2Holder, "part2");
                        ((CardLayout) part4Holder.getLayout()).show(part4Holder, "part4");
                    }  
                    if(!lyDoThem.getSelectedItem().equals("----------") && !lyDoThem.getSelectedItem().equals("Mới ra đời"))
                        ((CardLayout) part3Holder.getLayout()).show(part3Holder, "part3");
                    else
                        ((CardLayout) part3Holder.getLayout()).show(part3Holder, "blank");
                }
            });
            part1.add(lyDoThem);
            part1.add(Box.createRigidArea(new Dimension(213,22)));
            JLabel tieuDeMaSoHK = new JLabel("Mã sổ hộ khẩu: ");
            part1.add(tieuDeMaSoHK);
            JTextField maSoHK = new JTextField();
            maSoHK.setMaximumSize(new Dimension(200, 22));
            part1.add(maSoHK);
            //End item for part1
   
        //Panel part2
        part2.setVisible(false);
        part2.setLayout(new GridLayout(4, 1));
            //Item for part2
            JPanel line1p2 = new JPanel();
            line1p2.setLayout(new BoxLayout(line1p2, BoxLayout.X_AXIS));
                //Item for line1p2
                line1p2.add(Box.createRigidArea(new Dimension(5,22)));
                JLabel tieuDeHoTen = new JLabel("Họ và tên: ");
                line1p2.add(tieuDeHoTen);
                JTextField hoTen = new JTextField();
                hoTen.setMaximumSize(new Dimension(215,22));
                line1p2.add(hoTen);
                line1p2.add(Box.createRigidArea(new Dimension(195,22)));
                JLabel tieuDeBiDanh = new JLabel("Bí danh: ");
                line1p2.add(tieuDeBiDanh);
                JTextField biDanh = new JTextField();
                biDanh.setMaximumSize(new Dimension(200,22));
                line1p2.add(biDanh);
                //End item for line1p2
            part2.add(line1p2);
            JPanel line2p2 = new JPanel();
            line2p2.setLayout(new BoxLayout(line2p2, BoxLayout.X_AXIS));
                //Item for line2p2
                line2p2.add(Box.createRigidArea(new Dimension(5,22)));
                JLabel tieuDeNgaySinh = new JLabel("Ngày sinh: ");
                line2p2.add(tieuDeNgaySinh);
                DatePicker ngaySinh = new DatePicker();
                line2p2.add(ngaySinh);
                line2p2.add(Box.createRigidArea(new Dimension(191,22)));
                JLabel tieuDeGioiTinh = new JLabel("Giới tính: ");
                line2p2.add(tieuDeGioiTinh);
                JComboBox<String> gioiTinh = new JComboBox<String>(new String[]{"---", "Nam", "Nữ"});
                gioiTinh.setMaximumSize(new Dimension(60,22));
                gioiTinh.addItemListener(new ItemListener(){
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(!e.getItem().equals("Giới tính"))
                            gioiTinh.removeItem("Giới tính");
                    }
                });
                line2p2.add(gioiTinh);
                //End item for line2p2
            part2.add(line2p2);
            JPanel line3p2 = new JPanel();
            line3p2.setLayout(new BoxLayout(line3p2, BoxLayout.X_AXIS));
                //Item for line3p2
                line3p2.add(Box.createRigidArea(new Dimension(5,22)));
                JLabel tieuDeNoiSinh = new JLabel("Nơi sinh: ");
                line3p2.add(tieuDeNoiSinh);
                JTextField noiSinh = new JTextField();
                noiSinh.setMaximumSize(new Dimension(220,22));
                line3p2.add(noiSinh);
                line3p2.add(Box.createRigidArea(new Dimension(166,22)));
                JLabel tieuDeNguyenQuan = new JLabel("Nguyên quán: ");
                line3p2.add(tieuDeNguyenQuan);
                JTextField nguyenQuan = new JTextField();
                nguyenQuan.setMaximumSize(new Dimension(200,22));
                line3p2.add(nguyenQuan);
                //End item for line3p2
            part2.add(line3p2);
            JPanel line4p2 = new JPanel();
            line4p2.setLayout(new BoxLayout(line4p2, BoxLayout.X_AXIS));
                //Item for line 4
                line4p2.add(Box.createRigidArea(new Dimension(5,22)));
                JLabel tieuDeDanToc = new JLabel("Dân tộc: ");
                line4p2.add(tieuDeDanToc);
                JTextField danToc = new JTextField();
                danToc.setMaximumSize(new Dimension(50,22));
                line4p2.add(danToc);
                line4p2.add(Box.createRigidArea(new Dimension(15,22)));
                JLabel tieuDeQuanHe = new JLabel("Quan hệ với chủ hộ: ");
                line4p2.add(tieuDeQuanHe);
                JTextField quanHe = new JTextField();
                quanHe.setMaximumSize(new Dimension(50,22));
                line4p2.add(quanHe);
                line4p2.add(Box.createRigidArea(new Dimension(104,22)));
                JLabel tieuDeNgayDangKy = new JLabel("Ngày đăng ký thường trú: ");
                line4p2.add(tieuDeNgayDangKy);
                DatePicker ngayDangKy = new DatePicker();
                line4p2.add(ngayDangKy);
                //End item for line 4
            part2.add(line4p2);
            //End item for part2 
        part2Holder.setLayout(new CardLayout());
        part2Holder.add(new JPanel(), "blank");
        part2Holder.add(part2, "part2");

        //Panel part3
        part3.setVisible(false);
        part3.setLayout(new GridLayout(3,1));
            //Item for part3
            JPanel line1p3 = new JPanel();
            line1p3.setLayout((new BoxLayout(line1p3, BoxLayout.X_AXIS)));
                //Item for line1
                line1p3.add(Box.createRigidArea(new Dimension(5,22)));
                JLabel tieuDeNgheNghiep = new JLabel("Nghề nghiệp: ");
                line1p3.add(tieuDeNgheNghiep);
                JTextField ngheNghiep = new JTextField();
                ngheNghiep.setMaximumSize(new Dimension(194, 22));
                line1p3.add(ngheNghiep);
                line1p3.add(Box.createRigidArea(new Dimension(172,22)));
                JLabel tieuDeNoiLamViec = new JLabel("Nơi làm việc: ");
                line1p3.add(tieuDeNoiLamViec);
                JTextField noiLamViec = new JTextField();
                noiLamViec.setMaximumSize(new Dimension(200, 22));
                line1p3.add(noiLamViec);
                //End item for line1
            part3.add(line1p3);
            JPanel line2p3 = new JPanel();
            line2p3.setLayout((new BoxLayout(line2p3, BoxLayout.X_AXIS)));
                //Item for line2
                line2p3.add(Box.createRigidArea(new Dimension(5,22)));
                JLabel tieuDeCCCD = new JLabel("Số CMND/CCCD: ");
                line2p3.add(tieuDeCCCD);
                JTextField cccd = new JTextField();
                cccd.setMaximumSize(new Dimension(174, 22));
                line2p3.add(cccd);
                line2p3.add(Box.createRigidArea(new Dimension(188, 22)));
                JLabel tieuDeNgayCap = new JLabel("Ngày cấp: ");
                line2p3.add(tieuDeNgayCap);
                DatePicker ngayCap = new DatePicker();
                line2p3.add(ngayCap);
                //End item for line2
            part3.add(line2p3);
            JPanel line3p3 = new JPanel();
            line3p3.setLayout((new BoxLayout(line3p3, BoxLayout.X_AXIS)));
                //Item for line3
                line3p3.add(Box.createRigidArea(new Dimension(5,22)));
                JLabel tieuDeNoiCap = new JLabel("Nơi cấp: ");
                line3p3.add(tieuDeNoiCap);
                JTextField noiCap = new JTextField();
                noiCap.setMaximumSize(new Dimension(220, 22));
                line3p3.add(noiCap);
                line3p3.add(Box.createRigidArea(new Dimension(102,22)));
                JLabel tieuDeDiaChiDangKyTruocDay = new JLabel("Địa chỉ đăng ký trước đây: ");
                line3p3.add(tieuDeDiaChiDangKyTruocDay);
                JTextField diaChiDangKyTruocDay = new JTextField();
                diaChiDangKyTruocDay.setMaximumSize(new Dimension(200, 22));
                line3p3.add(diaChiDangKyTruocDay);
                //End item for line3
            part3.add(line3p3);
            //End item for part3
        part3Holder.setLayout(new CardLayout());
        part3Holder.add(new JPanel(), "blank");
        part3Holder.add(part3, "part3");
            
        JPanel part4 = new JPanel();
        part4.setLayout(new GridBagLayout());
            //Item for part4
            JButton nutThem = new JButton("Thêm nhân khẩu");
            nutThem.setMinimumSize(new Dimension(80, 20));
            part4.add(nutThem);
            nutThem.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    addToDB(lyDoThem, maSoHK, hoTen, biDanh, ngaySinh, gioiTinh, noiSinh, nguyenQuan, danToc, quanHe, 
                    ngayDangKy, ngheNghiep, noiLamViec, cccd, ngayCap, noiCap, diaChiDangKyTruocDay);
                }
            });
            //End item for part4
        part4Holder.setLayout(new CardLayout());
        part4Holder.add(new JPanel(), "blank");
        part4Holder.add(part4, "part4");
            
        //Add all panels to BienDoi
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 1; gbc.weighty = 0.1; gbc.anchor = GridBagConstraints.CENTER; gbc.fill = GridBagConstraints.BOTH;
        this.add(part1, gbc);
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 1; gbc.weighty = 0.4; gbc.anchor = GridBagConstraints.CENTER; gbc.fill = GridBagConstraints.BOTH;
        this.add(part2Holder, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 1; gbc.weighty = 0.3; gbc.anchor = GridBagConstraints.CENTER; gbc.fill = GridBagConstraints.BOTH;
        this.add(part3Holder, gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.weightx = 1; gbc.weighty = 0.2; gbc.anchor = GridBagConstraints.CENTER; gbc.fill = GridBagConstraints.BOTH;
        this.add(part4Holder, gbc);  
    }

    /**
     * Hàm nhận tất cả thông tin nhập vào để đẩy vào csdl
     * @return -1 nếu có lỗi nhập thiếu dữ liệu, 0 nếu thành công, 1 nếu có lỗi khác
     */
    private int addToDB(JComboBox<String> lyDoThem, JTextField maSoHK, JTextField hoTen, JTextField biDanh, DatePicker ngaySinh, 
                    JComboBox<String> gioiTinh, JTextField noiSinh, JTextField nguyenQuan, JTextField danToc, JTextField quanHe, 
                    DatePicker ngayDangKy, JTextField ngheNghiep, JTextField noiLamViec, JTextField cccd, DatePicker ngayCap,
                    JTextField noiCap, JTextField diaChiDangKyTruocDay) {
        Connection conn = JDBCConnection.getConnection(URL.DB_URL, URL.DB_USER, URL.DB_PASS);
        String maSoHKInput = maSoHK.getText();
        if(maSoHKInput.equals("")) {
            JOptionPane.showMessageDialog(null, "Phải nhập mã sổ hộ khẩu!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        String hoTenInput = hoTen.getText();
        if(hoTenInput.equals("")) {
        JOptionPane.showMessageDialog(null, "Phải nhập họ tên!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        String biDanhInput = biDanh.getText();
        Date ngaySinhInput = Date.valueOf(ngaySinh.getYear() + "-" + ngaySinh.getMonth() + "-" + ngaySinh.getDay());   
        if(!ngaySinh.isValid()) {
            JOptionPane.showMessageDialog(null, "Phải nhập đủ ngày, tháng, năm sinh!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        String gioiTinhInput = (String) gioiTinh.getSelectedItem();
        if(gioiTinh.getSelectedItem().equals("---")) {
            JOptionPane.showMessageDialog(null, "Phải nhập giới tính!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        String noiSinhInput = noiSinh.getText();
        if(noiSinhInput.equals("")) {
            JOptionPane.showMessageDialog(null, "Phải nhập nơi sinh!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        String nguyenQuanInput = nguyenQuan.getText();
        if(nguyenQuanInput.equals("")) {
            JOptionPane.showMessageDialog(null, "Phải nhập nguyên quán!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        String danTocInput = danToc.getText();
        if(danTocInput.equals("")) {
            JOptionPane.showMessageDialog(null, "Phải nhập dân tộc!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        String quanHeInput = quanHe.getText();
        if(quanHeInput.equals("")) {
            JOptionPane.showMessageDialog(null, "Phải nhập quan hệ với chủ hộ!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        Date ngayDangKyInput = Date.valueOf(ngayDangKy.getYear() + "-" + ngayDangKy.getMonth() + "-" + ngayDangKy.getDay());
        if(!ngayDangKy.isValid()) {
            JOptionPane.showMessageDialog(null, "Phải nhập đủ ngày, tháng, năm đăng ký thường trú!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        String ngheNghiepInput = ngheNghiep.getText();
        String noiLamViecInput = noiLamViec.getText();
        String cccdInput = cccd.getText();
        Date ngayCapInput = null;
        if(ngayCap.isValid() && !lyDoThem.getSelectedItem().equals("Mới ra đời")) Date.valueOf(ngayCap.getYear() + "-" + ngayCap.getMonth() + "-" + ngayCap.getDay());
        String noiCapInput = noiCap.getText();
        String diaChiDangKyTruocDayInput = diaChiDangKyTruocDay.getText();
        try {
            PreparedStatement checkSo = conn.prepareStatement(QuerySample.queryTim_SoHK);
            checkSo.setString(1, maSoHKInput);
            if(!checkSo.executeQuery().next()) {
                JOptionPane.showMessageDialog(null, "Sổ không tồn tại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                return 1;
            }
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            e1.printStackTrace();
        }
        switch((String)lyDoThem.getSelectedItem()){
            case "Mới ra đời":
            try {
                PreparedStatement pstatement = conn.prepareStatement(QuerySample.queryThem_MoiRaDoi);
                pstatement.setString(1,maSoHKInput);
                pstatement.setString(2, hoTenInput);
                pstatement.setString(3, biDanhInput);
                pstatement.setDate(4, ngaySinhInput);
                pstatement.setString(5, gioiTinhInput);
                pstatement.setString(6, noiSinhInput);
                pstatement.setString(7, nguyenQuanInput);
                pstatement.setString(8, danTocInput);
                pstatement.setDate(9, ngayDangKyInput);
                pstatement.setString(10, quanHeInput);
                pstatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
            break;
            case "Chuyển tới":
            try {
                PreparedStatement pstatement = conn.prepareStatement(QuerySample.queryThem_ChuyenToi);
                pstatement.setString(1,maSoHKInput);
                pstatement.setString(2, hoTenInput);
                pstatement.setString(3, biDanhInput);
                pstatement.setDate(4, ngaySinhInput);
                pstatement.setString(5, gioiTinhInput);
                pstatement.setString(6, noiSinhInput);
                pstatement.setString(7, nguyenQuanInput);
                pstatement.setString(8, danTocInput);
                pstatement.setString(9, ngheNghiepInput);
                pstatement.setString(10, noiLamViecInput);
                pstatement.setString(11, cccdInput);
                pstatement.setDate(12, ngayCapInput);
                pstatement.setString(13, noiCapInput);
                pstatement.setDate(14, ngayDangKyInput);
                pstatement.setString(15, diaChiDangKyTruocDayInput);           
                pstatement.setString(16, quanHeInput);
                pstatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
            break;
            case "Tạm trú":
            try {
                PreparedStatement pstatement = conn.prepareStatement(QuerySample.queryThem_TamTru);
                pstatement.setString(1,maSoHKInput);
                pstatement.setString(2, hoTenInput);
                pstatement.setString(3, biDanhInput);
                pstatement.setDate(4, ngaySinhInput);
                pstatement.setString(5, gioiTinhInput);
                pstatement.setString(6, noiSinhInput);
                pstatement.setString(7, nguyenQuanInput);
                pstatement.setString(8, danTocInput);
                pstatement.setString(9, ngheNghiepInput);
                pstatement.setString(10, noiLamViecInput);
                pstatement.setString(11, cccdInput);
                pstatement.setDate(12, ngayCapInput);
                pstatement.setString(13, noiCapInput);
                pstatement.setDate(14, ngayDangKyInput);
                pstatement.setString(15, diaChiDangKyTruocDayInput);           
                pstatement.setString(16, quanHeInput);
                pstatement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Có lỗi xảy ra!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
        return 1;
                    
    }
}

