package tw.waynee.prac;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.logging.ConsoleHandler;

import tw.waynee.prac.DietClass;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Diet extends JFrame implements ActionListener{
	private JTextField age, InputH, InputW;
	private JButton calTD, recordW, nutrition;
	private JLabel label1, label2, label3, label4, label5, label6, label7, label8, j1;
	private ButtonGroup checkBoxGroup;
	private ImageIcon image;
	private JPanel jp;


		public Diet() {
			super("肥宅減重計畫(˶‾᷄ ⁻̫ ‾᷅˵)");
			setLayout(new GridBagLayout());
	        image = new ImageIcon("dir1/cat.png");
	        jp=new JPanel();  
	        jp.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
	        j1=new JLabel(image);   
			
		
			age = new JTextField(5);
			InputH = new JTextField(5);
			InputW = new JTextField(5);
			new JTextField(5);
			label1 = new JLabel("一週活動量：");
			label2 = new JLabel("身高：");
			label3 = new JLabel("體重：");
			label4 = new JLabel("");
			label5 = new JLabel("性別：");
			label6 = new JLabel("年齡：");
			label7 = new JLabel("");
			label8 = new JLabel("目標：");
			age.addFocusListener(new DietClass(age, "(歲)"));
			InputH.addFocusListener(new DietClass(InputH, "(公分)"));
			InputW.addFocusListener(new DietClass(InputW, "(公斤)"));
			
			
		      // 男女選項只能選一個
			checkBoxGroup = new ButtonGroup();
		      

			
			String s1 = "低活動量(幾乎沒有運動或只運動1天)";
			String s2 = "中活動量(一週運動2~3天)";
			String s3 = "高活動量(幾乎每天運動)";
			String[] choices = {s1, s2, s3};
			final JComboBox<String> list = new JComboBox<String>(choices);
			String t1 = "減重";
			String t2 = "維持";
			String t3 = "增重";
			String[] targetsel = {t1, t2, t3};
			final JComboBox<String> list2 = new JComboBox<String>(targetsel);
			calTD = new JButton("計算TDEE");
			recordW = new JButton("記錄體重/TDEE");
			nutrition = new JButton("營養素攝取建議");
			
			
		 //1st section
			JPanel pane = new JPanel();			
			GridBagConstraints gbc = new GridBagConstraints();
			pane.setLayout(new GridBagLayout());
			
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 0;
			pane.add(label5, gbc);	
			JCheckBox Male = new JCheckBox("男");
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 0;
			pane.add(Male, gbc);	
			JCheckBox Female = new JCheckBox("女");
			checkBoxGroup.add(Male);
		    checkBoxGroup.add(Female);
		    
			
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
			gbc.gridy = 0;
			pane.add(Female, gbc);	
			
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 1;
			pane.add(label6, gbc);	
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 1;
			pane.add(age, gbc);	

		
		// 2nd section
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 2;
			pane.add(label2, gbc);		
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 2;
			pane.add(InputH, gbc);
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 3;
			pane.add(label3, gbc);
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 3;
			pane.add(InputW, gbc);
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 4;
			pane.add(label1, gbc);
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 4;
			pane.add(list, gbc);		
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
			gbc.gridy = 1;
			pane.add(calTD, gbc);
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 5;
			pane.add(label4, gbc);	
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
			gbc.gridy = 3;
			pane.add(recordW, gbc);	
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
			gbc.gridy = 2;
			pane.add(nutrition, gbc);	
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 9;
			pane.add(label7, gbc);
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 7;
			pane.add(label8, gbc);
			gbc = new GridBagConstraints();
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 7;
			pane.add(list2, gbc);
			
			
			calTD.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					double weight = Integer.parseInt(InputW.getText());
					double height = Integer.parseInt(InputH.getText());
					double Age = Integer.parseInt(age.getText());
					String selection = (String) list.getSelectedItem();
					 
					
					if(Male.isSelected() && selection.equals(s1)) {
						double BMR = (10 * weight) + (6.25 * height) - (5 * Age) + 5;
						double op = 1.375;
						double TDEE = BMR * op;
						label4.setText("您的TDEE為：  "+TDEE);
					}else if(Male.isSelected() && selection.equals(s2)) {
						double BMR = (10 * weight) + (6.25 * height) - (5 * Age) + 5;
						double op = 1.55;
						double TDEE = BMR * op;
						label4.setText("您的TDEE為：  "+TDEE);
					}else if(Male.isSelected() && selection.equals(s3)) {
						double BMR = (10 * weight) + (6.25 * height) - (5 * Age) + 5;
						double op =1.725;
						double TDEE = BMR * op;
						label4.setText("您的TDEE為：  "+TDEE);
					}else if(Female.isSelected() && selection.equals(s1)) {
						double BMR = (10 * weight) + (6.25 * height) - (5 * Age) - 161;
						double op = 1.375;
						double TDEE = BMR * op;
						label4.setText("您的TDEE為：  "+TDEE);
					}else if(Female.isSelected() && selection.equals(s2)) {
						double BMR = (10 * weight) + (6.25 * height) - (5 * Age) - 161;
						double op = 1.55;
						double TDEE = BMR * op;
						label4.setText("您的TDEE為：  "+TDEE);
					}else if(Female.isSelected() && selection.equals(s3)) {
						double BMR = (10 * weight) + (6.25 * height) - (5 * Age) - 161;
						double op =1.725;
						double TDEE = BMR * op;
						label4.setText("您的TDEE為：  "+ TDEE);
					}else {
						label4.setText("請勾選性別！");
								}
					
					nutrition.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							double weight = Integer.parseInt(InputW.getText());
							double height = Integer.parseInt(InputH.getText());
							double Age = Integer.parseInt(age.getText());
							String selection = (String) list.getSelectedItem();
							String Target = (String) list2.getSelectedItem();
							 
							
							if(Male.isSelected() && selection.equals(s1) && Target.equals(t1)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) + 5;
								double op = 1.375;
								double TDEE = BMR * op - 500;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Male.isSelected() && selection.equals(s2) && Target.equals(t1)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) + 5;
								double op = 1.55;
								double TDEE = BMR * op - 500;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Male.isSelected() && selection.equals(s3)&& Target.equals(t1)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) + 5;
								double op =1.725;
								double TDEE = BMR * op - 500;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Female.isSelected() && selection.equals(s1)&& Target.equals(t1)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) - 161;
								double op = 1.375;
								double TDEE = BMR * op - 500;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Female.isSelected() && selection.equals(s2)&& Target.equals(t1)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) - 161;
								double op = 1.55;
								double TDEE = BMR * op - 500;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Female.isSelected() && selection.equals(s3)&& Target.equals(t1)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) - 161;
								double op =1.725;
								double TDEE = BMR * op - 500;
								double protein = Math.floor(Math.floor(TDEE * 0.55/4));
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+ "碳水化合物："+carbs+"克"+ "脂肪："+fat+"克");
								
								
							}else if (Male.isSelected() && selection.equals(s1) && Target.equals(t2)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) + 5;
								double op = 1.375;
								double TDEE = BMR * op;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Male.isSelected() && selection.equals(s2) && Target.equals(t2)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) + 5;
								double op = 1.55;
								double TDEE = BMR * op;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Male.isSelected() && selection.equals(s3)&& Target.equals(t2)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) + 5;
								double op =1.725;
								double TDEE = BMR * op;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Female.isSelected() && selection.equals(s1)&& Target.equals(t2)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) - 161;
								double op = 1.375;
								double TDEE = BMR * op;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Female.isSelected() && selection.equals(s2)&& Target.equals(t2)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) - 161;
								double op = 1.55;
								double TDEE = BMR * op;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Female.isSelected() && selection.equals(s3)&& Target.equals(t2)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) - 161;
								double op =1.725;
								double TDEE = BMR * op;
								double protein = Math.floor(Math.floor(TDEE * 0.55/4));
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+ "碳水化合物："+carbs+"克"+ "脂肪："+fat+"克");
								
								
							}else if (Male.isSelected() && selection.equals(s1) && Target.equals(t3)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) + 5;
								double op = 1.375;
								double TDEE = BMR * op + 500;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Male.isSelected() && selection.equals(s2) && Target.equals(t3)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) + 5;
								double op = 1.55;
								double TDEE = BMR * op + 500;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Male.isSelected() && selection.equals(s3)&& Target.equals(t3)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) + 5;
								double op =1.725;
								double TDEE = BMR * op + 500;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Female.isSelected() && selection.equals(s1)&& Target.equals(t3)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) - 161;
								double op = 1.375;
								double TDEE = BMR * op + 500;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Female.isSelected() && selection.equals(s2)&& Target.equals(t3)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) - 161;
								double op = 1.55;
								double TDEE = BMR * op + 500;
								double protein = Math.floor(TDEE * 0.55/4);
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}else if(Female.isSelected() && selection.equals(s3)&& Target.equals(t3)) {
								double BMR = (10 * weight) + (6.25 * height) - (5 * Age) - 161;
								double op =1.725;
								double TDEE = BMR * op + 500;
								double protein = Math.floor(Math.floor(TDEE * 0.55/4));
								double carbs = Math.floor(TDEE * 0.30/4);
								double fat = Math.floor(TDEE * 0.15/9);
								label7.setText("蛋白質："+ protein+"克"+" "+ "碳水化合物："+carbs+"克"+" "+ "脂肪："+fat+"克");
							}
						}
					});
					
				}
		});
			recordW.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						BufferedWriter bfw = new BufferedWriter(new FileWriter("dir1/體重紀錄.txt"));
						bfw.write(LocalDate.now()+"體重："+InputW.getText() + label4.getText());
						bfw.close();
					} catch (Exception e2) {
						System.out.println(e2.toString());
					}
				}
			});
			
		add(j1);  
        pane.add(jp); 
		pane.setBackground(Color.pink);
		getContentPane().setBackground(Color.black);
		add(pane);
		setSize(790,300);
		setResizable(false);
		setLocation(image.getIconWidth(),image.getIconHeight());  
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

}
		
		
	public static void main(String[] args) {
			new Diet();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
	}
}


