package feature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BienDoi extends JPanel {
    public static enum TYPE {Them, ThayDoi, Chuyen};
    
    public BienDoi(TYPE type){
        if(type == TYPE.Them) {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            System.out.print(this.getSize().width + " " + this.getSize().height);
            //Panel part1
            JPanel part1 = new JPanel();
            gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 1; gbc.weighty = 0.06; gbc.anchor = GridBagConstraints.CENTER; gbc.fill = GridBagConstraints.BOTH;
            this.add(part1, gbc);
            part1.setLayout(new FlowLayout(FlowLayout.LEFT));
                //Item for part1
                JLabel tieuDeLyDoThem = new JLabel("Lý do thêm nhân khẩu:");
                part1.add(tieuDeLyDoThem);
                JComboBox<String> lyDoThem = new JComboBox<>(new String[] {"Chọn lý do", "Mới ra đời", "Chuyển tới", "Tạm trú"});
                part1.add(lyDoThem);
                lyDoThem.setForeground(Color.GRAY);
                lyDoThem.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(lyDoThem.getSelectedItem().equals("Chọn lý do"))
                            lyDoThem.setForeground(Color.GRAY);
                        else  
                            lyDoThem.setForeground(Color.BLACK);  
                    }
                });
                //End item for part1
            part1.setBackground(Color.RED);
            JPanel part2 = new JPanel();
            gbc.gridx = 0; gbc.gridy = 1; gbc.gridheight = 3; gbc.weightx = 1; gbc.weighty = 0.47; gbc.anchor = GridBagConstraints.CENTER; gbc.fill = GridBagConstraints.BOTH;
            this.add(part2, gbc);
            part2.setBackground(Color.BLUE);
            JPanel part3 = new JPanel();
            gbc.gridx = 0; gbc.gridy = 4; gbc.gridheight = 3; gbc.weightx = 1; gbc.weighty = 0.47; gbc.anchor = GridBagConstraints.CENTER; gbc.fill = GridBagConstraints.BOTH;
            this.add(part3, gbc);
            part3.setBackground(Color.GREEN);
        } 
    }
}
