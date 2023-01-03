package handler;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class DatePicker extends JPanel{
    private JComboBox<String> day, month, year;
    
    public DatePicker() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setMinimumSize(new Dimension(68*3+4*2, 22));
        this.setMaximumSize(new Dimension(68*3+4*2, 22));
        this.setPreferredSize(new Dimension(68*3+4*2, 22));
        
        String[] d = new String[32];
        d[0] = "Ngày";
        for(int i = 1; i <= 31; i++)
            d[i] = Integer.toString(i);
        day = new JComboBox<String>(d);
        day.setMaximumRowCount(15);
        day.setMaximumSize(new Dimension(68,22));
        day.setMinimumSize(new Dimension(68,22));
        day.setPreferredSize(new Dimension(68,22));
        day.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(!e.getItem().equals("Ngày")) {
                    day.setForeground(Color.BLACK);
                    day.removeItem("Ngày");
                    month.setEnabled(true);
                    dateRevalidate();
                }
            }    
        });
        this.add(day);
        this.add(Box.createRigidArea(new Dimension(4,22)));

        String[] m = new String[13];
        m[0] = "Tháng";
        for(int i = 1; i <= 12; i++)
            m[i] = Integer.toString(i);
        month = new JComboBox<String>(m);
        month.setEnabled(false);
        month.setMinimumSize(new Dimension(68,22));
        month.setMaximumSize(new Dimension(68,22));
        month.setPreferredSize(new Dimension(68,22));
        month.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(!e.getItem().equals("Tháng")) {
                    month.setForeground(Color.BLACK);
                    month.removeItem("Tháng");
                    year.setEnabled(true);
                    dateRevalidate();
                }
            }     
        });
        this.add(month);
        this.add(Box.createRigidArea(new Dimension(4,22)));

        String[] y = new String[202];
        y[0] = "Năm";
        for(int i = 1900; i <= 2100; i++)
            y[i-1899] = Integer.toString(i);
        year = new JComboBox<String>(y);
        year.setEnabled(false);
        year.setMaximumRowCount(15);
        year.setMaximumSize(new Dimension(68,22));
        year.setMinimumSize(new Dimension(68,22));
        year.setPreferredSize(new Dimension(68,22));
        year.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(!e.getItem().equals("Năm")) {
                    year.setForeground(Color.BLACK);
                    year.removeItem("Năm");
                    dateRevalidate();
                }
            }     
        });
        this.add(year);
    }

    /**
     * Hàm trả về ngày, nếu chưa chọn trả về 0
     * @return ngày
     */
    public int getDay() {
        if(day.getSelectedItem().equals("Ngày"))
            return 0;
        return Integer.parseInt((String) day.getSelectedItem());
    }

    /**
     * Hàm trả về tháng, nếu chưa chọn trả về 0
     * @return tháng
     */
    public int getMonth() {
        if(month.getSelectedItem().equals("Tháng"))
            return 0;
        return Integer.parseInt((String) month.getSelectedItem());
    }

    /**
     * Hàm trả về năm, nếu chưa chọn trả về 0
     * @return năm
     */
    public int getYear() {
        if(year.getSelectedItem().equals("Năm"))
            return 0;
        return Integer.parseInt((String) year.getSelectedItem());
    }
    
    /**
     * Hàm kiểm tra xem ngày trong DatePicker có hợp lệ không
     * @return
     */
    public boolean isDateValid(){
        if(day.getSelectedItem().equals("Ngày") || month.getSelectedItem().equals("Tháng") || year.getSelectedItem().equals("Năm"))
            return false;
        return true;
    }

        /**
         * Hàm đặt lại giá trị sao cho ngày được chọn là hợp lệ
         */
    public void dateRevalidate() {
        int dd = 0, mm = 0, yy = 0;
        if(!day.getSelectedItem().equals("Ngày"))
            dd = Integer.parseInt((String) day.getSelectedItem());
        if(!year.getSelectedItem().equals("Năm"))
            yy = Integer.parseInt((String) year.getSelectedItem());
        if(!month.getSelectedItem().equals("Tháng"))
            mm = Integer.parseInt((String) month.getSelectedItem());
        
        boolean leaf = false;
        if(yy % 400 == 0 || (yy % 100 != 0 && yy % 4 == 0))
            leaf = true;
        switch (mm) {
            case 4, 6, 9, 11:
            if(dd > 30) day.setSelectedItem("30");
            break;
            case 2:
            if(leaf && dd > 29) day.setSelectedItem("29");
            if((!leaf) && dd > 28) day.setSelectedItem("28");
        }
    }
}