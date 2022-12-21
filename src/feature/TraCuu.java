package feature;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class TraCuu extends JPanel {
	private JButton nutTraCuu;
	private JTextField maSo;
	private JLabel titleLabel, textFieldTitle;
	private JPanel textFieldPanel, inputPanel, featurePanel;
	
	public TraCuu() {
		TraCuu traCuu = this;
		nutTraCuu = new JButton("Tra Cứu");
		nutTraCuu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = maSo.getText();
				if(!str.equals("123456"))
					JOptionPane.showMessageDialog(null, "Mã số sai!", null, JOptionPane.ERROR_MESSAGE);
				else
					((CardLayout) traCuu.getLayout()).show(traCuu, "feature");
			}
		});
		
		maSo = new JTextField();
		maSo.setPreferredSize(new Dimension(200, 40));
		textFieldTitle = new JLabel("Mã số:");
		textFieldPanel = new JPanel();
		textFieldPanel.setLayout(new FlowLayout());
		textFieldPanel.add(textFieldTitle);
		textFieldPanel.add(maSo);
		
		titleLabel = new JLabel("Tra cứu hộ khẩu");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
		
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
		
		featurePanel = new JPanel();
		
		this.setLayout(new CardLayout());
		this.add("input", inputPanel);
		this.add("feature", featurePanel);
	}
}
