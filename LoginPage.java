package tw.waynee.prac;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener{
	private JFrame jf;
	private JPanel jp, jp2;
	private JLabel jl1, jl2, jl3, jl4;
	private JButton jb1, jb2;
	
	
	ImageIcon img = new ImageIcon("dir1/login2.png");
	
	JLabel bgimg = new JLabel(img);

	JTextField account = new JTextField(15);
	JPasswordField password = new JPasswordField(15);
	LoginPage(){
		
		
		jf = new JFrame("登入");
		jb1 = new JButton("登入");
		jb2 = new JButton("註冊");
		jl1 = new JLabel("帳號： ");
		jl2 = new JLabel("密碼： ");
		jl3 = new JLabel("");
		jl4 = new JLabel(img);
		jp = new JPanel();
		jp2 = new JPanel();
		jp2.setBounds(0, 0, img.getIconHeight(), img.getIconWidth());
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		jp.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		jp.add(jl1, gbc);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		jp.add(jl2, gbc);
	    gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		jp.add(account, gbc);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		jp.add(password, gbc);		
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 2;
		jp.add(jb1, gbc);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 3;
		jp.add(jl3, gbc);
		gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 4;
		jp.add(jb2, gbc);

		jb1.setBounds(100, 160, 200, 40);
		jb1.setFocusable(false);
		jb1.addActionListener(this);
		
		
		jp.setBackground(Color.lightGray);
		jf.setBackground(Color.black);

		jf.add(jl4);
		jf.setLocation(img.getIconWidth(),img.getIconHeight());  
		jf.add(jp);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(520,290);
		jf.setResizable(false);
		jf.setLayout(new GridBagLayout());
		jf.setVisible(true);
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==jb2) {
					Register register = new Register();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		
		new LoginPage();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String username = account.getText();
		String passwrd = new String(password.getPassword());
		
		if(username.equals("abcd")&&passwrd.equals("1234")) {
			jf.dispose();
			Diet diet = new Diet();
		}else {
			jl3.setText("帳號或密碼錯誤");
		}

	}

}
