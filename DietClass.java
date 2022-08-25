package tw.waynee.prac;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class DietClass extends JFrame implements FocusListener {
	  
		private String hintText;
		private JTextField textField;
		public DietClass(JTextField jTextField,String hintText) {
			this.textField = jTextField;
			this.hintText = hintText;
			jTextField.setText(hintText);  //預設直接顯示
			jTextField.setForeground(Color.GRAY);
		}

		@Override
		public void focusGained(FocusEvent e) {
			//獲取焦點時，清空提示內容
			String temp = textField.getText();
			if(temp.equals(hintText)) {
				textField.setText("");
				textField.setForeground(Color.BLACK);
			}
			
		}

		@Override
		public void focusLost(FocusEvent e) {	
			//提示內容
			String temp = textField.getText();
			if(temp.equals("")) {
				textField.setForeground(Color.GRAY);
				textField.setText(hintText);
			}
			
		}
	
		

}
