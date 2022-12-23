package feature;

import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;

import handler.*;
import handler.Page.PageType;

public class TraCuu extends JPanel {
	public static enum TYPE {TheoMaSo};
	private JButton lookUpButton;
	private JTextField householdNoTF;
	private JLabel titleLabel, textFieldTitle;
	private JPanel textFieldPanel, inputPanel, lookupPanel;
	
	public TraCuu() {
		super();
	}
	
	public TraCuu(TYPE type) {
	if(type == TYPE.TheoMaSo) {
		//Thiết lập nút tra cứu
		lookUpButton = new JButton("Tra Cứu");
		lookUpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Khi ấn nút tra cứu, lấy mã số từ ô nhập mã số, sau đó tìm trong cơ sở dữ liệu
				String str = householdNoTF.getText();
				ResultSet rs = null;
				try {
					//Lấy thông tin về cửa sổ tra cứu để chuyển từ thẻ nhập liệu sang thẻ tính năng qua CardLayout
					TraCuu traCuu = (TraCuu)((JPanel)((JButton)(e.getSource())).getParent()).getParent();
					
					Connection conn = new JDBCConnection().getConnection(storage.URL.DB_URL, storage.URL.DB_USER, storage.URL.DB_PASS);
					PreparedStatement pstatement = conn.prepareStatement("SELECT * FROM SoHoKhau WHERE MaSoHK = ?;");
					pstatement.setString(1, str);
					rs = pstatement.executeQuery();
					if(rs.next()) {
						//Nếu đúng sẽ trả ra kết quả, đồng thời chuyển vào màn hình tính năng tra cứu
						((CardLayout) traCuu.getLayout()).show(traCuu, "lookUp");
					}
					else
						//Nếu không sẽ báo mã số sai
						JOptionPane.showMessageDialog(null, "Mã số sai!", null, JOptionPane.ERROR_MESSAGE);		
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		});
		
		//Thiết lập ô nhập mã số
		householdNoTF = new JTextField();
		householdNoTF.setPreferredSize(new Dimension(200, 40));
		//Thiết lập nhãn của ô nhập mã số
		textFieldTitle = new JLabel("Mã số:");
		//Thêm ô nhập và nhãn vào 1 panel, dùng FlowLayout để sắp xếp
		textFieldPanel = new JPanel();
		textFieldPanel.setLayout(new FlowLayout());
		textFieldPanel.add(textFieldTitle);
		textFieldPanel.add(householdNoTF);
		//Thiết lập nhãn tiêu đề cho trang
		titleLabel = new JLabel("Tra Cứu Hộ Khẩu");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
		//Cho tất cả các yếu tố gồm nhãn tiêu đề, textFieldPanel và nút tra cứu vào inputPanel, dùng GridBagLayout sắp xếp
		inputPanel = new JPanel();
		inputPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		gbc.gridx = 0; gbc.gridy = 0;
		inputPanel.add(titleLabel, gbc);
		gbc.gridx = 0; gbc.gridy = 1;
		inputPanel.add(textFieldPanel, gbc);
		gbc.gridx = 0; gbc.gridy = 2;
		inputPanel.add(lookUpButton, gbc);

		
		//Thiết lập sổ hộ khẩu
		Book book = new Book();
		book.setOpaque(true);
		Page title = new Page(PageType.COVER, null);
		book.addPage(title);
		Page page1 = new Page(PageType.HOUSEHOLDER, null);
		book.addPage(page1);
		//Thiết lập 2 phím mũi tên chuyển trang
		BasicArrowButton leftButton = new BasicArrowButton(BasicArrowButton.WEST);
		leftButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(1 < book.getCurrentPageNum() && book.getCurrentPageNum() <= book.getNumberOfPages())
					book.showPage(book.getCurrentPageNum()-1);	
			}
		});
		BasicArrowButton rightButton = new BasicArrowButton(BasicArrowButton.EAST);
		rightButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(1 <= book.getCurrentPageNum() && book.getCurrentPageNum() < book.getNumberOfPages())
					book.showPage(book.getCurrentPageNum()+1);	
			}
		});
		//Thiết lập màn hình sau tra cứu, hiển thị sổ
		lookupPanel = new JPanel();
		lookupPanel.setLayout(new BorderLayout());
		lookupPanel.add(leftButton, BorderLayout.WEST);
		lookupPanel.add(book, BorderLayout.CENTER);
		lookupPanel.add(rightButton, BorderLayout.EAST);
		//Thêm các thẻ của panel nhập liệu và panel tính năng vào panel tổng TraCuu
		this.setLayout(new CardLayout());
		this.add("input", inputPanel);
		this.add("lookUp", lookupPanel);
	}
	}
}
