package feature;

import javax.swing.*;

import handler.DatePicker;

import java.awt.*;
import java.awt.event.*;

public class BienDoi extends JPanel {
    public static enum TYPE {Them, ThayDoi, Chuyen};
    
    public BienDoi(TYPE type){
        if(type == TYPE.Them) {
            JPanel part2 = new JPanel(); 

            //Panel part1
            JPanel part1 = new JPanel();
            part1.setBackground(Color.RED);
            part1.setLayout(new FlowLayout(FlowLayout.LEFT));
                //Item for part1
                JLabel tieuDeLyDoThem = new JLabel("Lý do thêm nhân khẩu:");
                part1.add(tieuDeLyDoThem);
                JComboBox<String> lyDoThem = new JComboBox<>(new String[] {"Chọn lý do", "Mới ra đời", "Chuyển tới", "Tạm trú"});
                lyDoThem.setForeground(Color.GRAY);
                lyDoThem.setSelectedItem("Chọn lý do");
                lyDoThem.addItemListener(new ItemListener(){
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if(!lyDoThem.getSelectedItem().equals("Chọn lý do")) {
                            lyDoThem.setForeground(Color.BLACK);  
                            lyDoThem.removeItem("Chọn lý do");
                        }
                        if(e.getItem().equals("Mới ra đời"))
                            ((CardLayout) part2.getLayout()).show(part2, "moiRaDoi");   
                    }
                });
                part1.add(lyDoThem);
                //End item for part1
   
            //Panel part2
            part2.setBackground(Color.BLUE);
            part2.setLayout(new CardLayout());
            part2.add(new JPanel(), "blank");
                //Item for part2
                JPanel moiRaDoi = new JPanel();
                moiRaDoi.setLayout(new GridLayout(10, 1));
                    //Item for moiRaDoi
                    JPanel line1 = new JPanel();
                    line1.setLayout(new BoxLayout(line1, BoxLayout.X_AXIS));
                        //Item for line1
                        JLabel tieuDeHoTen = new JLabel("Họ và tên:");
                        line1.add(tieuDeHoTen);
                        JTextField hoTen = new JTextField();
                        hoTen.setMaximumSize(new Dimension(160,22));
                        line1.add(hoTen);
                        //End item for line1
                    moiRaDoi.add(line1);
                    JPanel line2 = new JPanel();
                    line2.setLayout(new BoxLayout(line2, BoxLayout.X_AXIS));
                    line2.setBackground(Color.RED);
                        //Item for line2
                        JLabel tieuDeNgaySinh = new JLabel("Ngày, tháng, năm sinh:");
                        line2.add(tieuDeNgaySinh);
                        DatePicker chonNgay = new DatePicker();
                        line2.add(chonNgay);
                        line2.add(Box.createHorizontalGlue());
                        //End item for line2
                    moiRaDoi.add(line2);
                JPanel line3 = new JPanel();
                    moiRaDoi.add(line3);
                    JPanel line4 = new JPanel();
                    moiRaDoi.add(line4);
                    JPanel line5 = new JPanel();
                    moiRaDoi.add(line5);
                    JPanel line6 = new JPanel();
                    moiRaDoi.add(line6);
                    JPanel line7 = new JPanel();
                    moiRaDoi.add(line7);
                    JPanel line8 = new JPanel();
                    moiRaDoi.add(line8);
                    JPanel line9 = new JPanel();
                    moiRaDoi.add(line9);
                    JPanel line10 = new JPanel();
                    moiRaDoi.add(line10);
                    //End item for moiRaDoi
                part2.add(moiRaDoi, "moiRaDoi");
                JPanel chuyenToi = new JPanel();
                part2.add(chuyenToi, "chuyenToi");
                JPanel tamTru = new JPanel();
                part2.add(tamTru, "tamTru");
                //End item for part2

            //Add all panels to BienDoi
            this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 1; gbc.weighty = 0; gbc.anchor = GridBagConstraints.CENTER; gbc.fill = GridBagConstraints.BOTH;
            this.add(part1, gbc);
            gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 1; gbc.weighty = 1; gbc.anchor = GridBagConstraints.CENTER; gbc.fill = GridBagConstraints.BOTH;
            this.add(part2, gbc);
        } 
    }
}
