package feature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import handler.DatePicker;


public class TamTru extends JPanel{
    private JLabel titleLabel,titleLabel2, nameLabel, CCCDLabel, dateLabel, birthLabel, CALabel;
    private JTextField nameText,CAtextField;

    public TamTru(){
        JPanel part0 = new JPanel();
        part0.setLayout(new GridLayout(2,1));
            JLabel CHXH1 = new JLabel("Cộng hòa xã hội chủ nghĩa Việt Nam");
            CHXH1.setHorizontalAlignment(JLabel.CENTER);
            //CHXH1.setVerticalAlignment(JLabel.CENTER);
            CHXH1.setFont(new Font("Arial",Font.BOLD,15));
            JLabel CHXH2 = new JLabel("Độc lập - Tự do - Hạnh phúc");
            CHXH2.setHorizontalAlignment(JLabel.CENTER);
            //CHXH2.setVerticalAlignment(JLabel.CENTER);
            CHXH2.setFont(new Font("Arial",Font.BOLD,15));
        part0.add(CHXH1);
        part0.add(CHXH2);

        JLabel nayLabel2 = new JLabel();
        //phần tiêu đề
        
        JPanel part1 = new JPanel();
        //part1.setLayout(new GridLayout(3,1));
        part1.setBackground(Color.GRAY);
            titleLabel = new JLabel("Đơn xin xác nhận tạm trú");
            titleLabel.setHorizontalAlignment(JLabel.CENTER);
            titleLabel.setVerticalAlignment(JLabel.CENTER);
		    titleLabel.setFont(new Font("Arial",Font.BOLD,30));
            
        part1.add(titleLabel);
        
        //phần thân
        JPanel part2 = new JPanel();
        part2.setLayout(new GridLayout(7,1));
            //item for part 2
                //line 1 (item for part 2)
                 JPanel line1 = new JPanel();
                line1.setLayout(new BoxLayout(line1, BoxLayout.X_AXIS));
                line1.setBackground(Color.ORANGE);
                //line1.setSize(250,0);;
                     //item for line 1
                    CALabel = new JLabel("kính gửi: Công an ");
		            CALabel.setFont(new Font("Arial",Font.BOLD,15));
                    CAtextField = new JTextField();
                    CAtextField.setMaximumSize(new Dimension(250,20));
                    CAtextField.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            nayLabel2.setText(CAtextField.getText());
                            nayLabel2.setFont(new Font("Arial",Font.BOLD,15));
                            repaint();
                        }
                    });
                    //end item line 1
                line1.add(Box.createHorizontalGlue());
                line1.add(CALabel);
                line1.add(CAtextField);
                line1.add(Box.createHorizontalGlue());
            part2.add(line1);

                //line 2
                JPanel line2 = new JPanel();
                line2.setLayout(new BoxLayout(line2, BoxLayout.X_AXIS));
                    //item for line 2 
                    nameLabel = new JLabel("tên tôi là: ");
                    nameLabel.setFont(new Font("Arial",Font.BOLD,15));
                    nameText = new JTextField();
                    nameText.setMaximumSize(new Dimension(250,20));
                    //end item line 2
                line2.add(nameLabel);
                line2.add(nameText);
            part2.add(line2);

                //line 3
                JPanel line3 = new JPanel();
                line3.setLayout(new BoxLayout(line3, BoxLayout.X_AXIS));
                    //item for line 3
                    dateLabel = new JLabel("ngày sinh: ");
                    dateLabel.setFont(new Font("Arial",Font.BOLD,15));
                    DatePicker chonNgay = new DatePicker();
                    //end item line 3
                line3.add(dateLabel);
                line3.add(chonNgay);
            part2.add(line3);

                //line 4
                JPanel line4 = new JPanel();
                line4.setLayout(new BoxLayout(line4, BoxLayout.X_AXIS));
                    //item for line 4
                    CCCDLabel = new JLabel("CCCD");
                    CCCDLabel.setFont(new Font("Arial",Font.BOLD,15));
                    JTextField CCCDtext = new JTextField();
                    CCCDtext.setMaximumSize(new Dimension(250,20));
                    //end item line 4
                line4.add(CCCDLabel);
                line4.add(CCCDtext);
            part2.add(line4);

                //line 5
                JPanel line5 = new JPanel();
                line5.setLayout(new BoxLayout(line5, BoxLayout.X_AXIS));
                    //item for line 5
                    JLabel DCTTLabel = new JLabel("Hộ khẩu thường trú tại: ");
                    DCTTLabel.setFont(new Font("Arial",Font.BOLD,15));
                    JTextField DCTTtext = new JTextField();
                    DCTTtext.setMaximumSize(new Dimension(250,20));
                    //end item line 5
                line5.add(DCTTLabel);
                line5.add(DCTTtext);
            part2.add(line5);

                //line 6
                JPanel line6 = new JPanel();
                line6.setLayout(new BoxLayout(line6, BoxLayout.X_AXIS));
                    //item for line 6
                    JLabel diachiLabel = new JLabel("Chỗ ở hiện tại: ");
                    diachiLabel.setFont(new Font("Arial",Font.BOLD,15));
                    JTextField diachitext = new JTextField();
                    diachitext.setMaximumSize(new Dimension(250,20));
                    //end item line 6
                line6.add(diachiLabel);
                line6.add(diachitext);
            part2.add(line6);
                
                //line 7
                JPanel line7 = new JPanel();
                line7.setLayout(new BoxLayout(line7, BoxLayout.X_AXIS));
                    //item for line 7
                    JLabel nayLabel1 = new JLabel("    Nay tôi làm đơn này kính xin ban công an ");
                    nayLabel1.setFont(new Font("Arial",Font.BOLD,15));
                    JLabel nayLabel3 = new JLabel(" xác nhận cho tôi tạm trú từ ngày ");
                    nayLabel3.setFont(new Font("Arial",Font.BOLD,15));
                    DatePicker nay4 = new DatePicker();
                //end item line 7
                line7.add(nayLabel1);
                line7.add(nayLabel2);
                line7.add(nayLabel3);
                line7.add(nay4);
            part2.add(line7);
                //line 8
                JPanel line8 = new JPanel();
                line8.setLayout(new BoxLayout(line8, BoxLayout.X_AXIS));
                    //item for line 8
                    JLabel lydoLabel = new JLabel("    Lý do:  ");
                    lydoLabel.setFont(new Font("Arial",Font.BOLD,15));
                    JTextField lydoText = new JTextField();
                    lydoText.setMaximumSize(new Dimension(250,20));
                //end item line 8
                line8.add(lydoLabel);
                line8.add(lydoText);   
            //part2.add(line8);     
        //nhét các panel vào screen
        this.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 1; gbc.weighty = 0; gbc.anchor = GridBagConstraints.CENTER; gbc.fill = GridBagConstraints.BOTH;
            this.add(part0, gbc);
            gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 1; gbc.weighty = 0; gbc.anchor = GridBagConstraints.CENTER; gbc.fill = GridBagConstraints.BOTH;
            this.add(part1, gbc);
            gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 1; gbc.weighty = 1; gbc.anchor = GridBagConstraints.CENTER; gbc.fill = GridBagConstraints.BOTH;
            this.add(part2, gbc);
        
    }
}

