package feature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import handler.*;

public class TraCuu extends JPanel {
	private JButton nutTraCuu;
	private JTextField maSo;
	private JLabel titleLabel, textFieldTitle;
	private JPanel textFieldPanel, inputPanel, featurePanel;
	
	public TraCuu() {
		//Dòng code này có vì bước thiết lập ActionListener không dùng được từ khóa this
		TraCuu traCuu = this;
		//Thiết lập nút tra cứu
		nutTraCuu = new JButton("Tra Cứu");
		nutTraCuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Khi ấn nút tra cứu, lấy mã số từ ô nhập mã số, sau đó tìm trong cơ sở dữ liệu
				String str = maSo.getText();
				ResultSet rs = null;
				try {
					Connection conn = new JDBCConnection().getConnection(storage.URL.DB_URL, storage.URL.DB_USER, storage.URL.DB_PASS);
					PreparedStatement pstatement = conn.prepareStatement("SELECT * FROM SoHoKhau WHERE MaSoHK = ?;");
					pstatement.setString(1, str);
					rs = pstatement.executeQuery();
					if(rs.next()) {
						//Nếu đúng sẽ trả ra kết quả, đồng thời chuyển vào màn hình tính năng tra cứu
						((CardLayout) traCuu.getLayout()).show(traCuu, "feature");
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
		maSo = new JTextField();
		maSo.setPreferredSize(new Dimension(200, 40));
		//Thiết lập nhãn của ô nhập mã số
		textFieldTitle = new JLabel("Mã số:");
		//Thêm ô nhập và nhãn vào 1 panel, dùng FlowLayout để sắp xếp
		textFieldPanel = new JPanel();
		textFieldPanel.setLayout(new FlowLayout());
		textFieldPanel.add(textFieldTitle);
		textFieldPanel.add(maSo);
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
		inputPanel.add(nutTraCuu, gbc);
		
		//Thiết lập panel tính năng, tức là các tính năng sau khi tra cứu được 1 mã số
		featurePanel = new JPanel();
		//Thêm các thẻ của panel nhập liệu và panel tính năng vào panel tổng TraCuu
		this.setLayout(new CardLayout());
		this.add("input", inputPanel);
		this.add("feature", featurePanel);
	}
}
