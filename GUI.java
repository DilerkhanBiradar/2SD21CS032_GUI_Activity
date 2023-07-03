package sdmcet.cse.oop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

// Class for Exception handling
class MarksException extends Exception {

	public MarksException(String title) {
		// TODO Auto-generated constructor stub
		super(title);
	}

	public String toString() {
		return "Marks Invalid";
	}

}

class Cie extends JFrame implements ActionListener {
	
	static int marks,flag=0;
	JButton button;
	Container contentPane;
	JPanel panel,panel1,panel2,panel3;
	JLabel label, txtLbl1, txtLbl2, txtLbl3, label1,label2,label3,label4;
	JLabel txtLbl4, txtLbl5, txtLbl6, txtLbl7;
	JTextField text1, text2, text3, text4, text5, text6, text7;

	Cie(String title) {
		super(title);
		
		// Instantiating the button,Labels,TextFields and adding them on the panel
		contentPane = this.getContentPane();
		panel=new JPanel();
		panel.setBounds(0,35,400,350);
		contentPane.add(panel);
		
		button = new JButton("Calculate");
		button.addActionListener(this);

		txtLbl1 = new JLabel("Enter IA-1 marks\n");
		text1 = new JTextField(4);

		txtLbl2 = new JLabel("Enter IA-2 marks\n");
		text2 = new JTextField(4);

		txtLbl3 = new JLabel("Enter IA-3 marks\n");
		text3 = new JTextField(4);

		txtLbl4 = new JLabel("Enter CTA marks\n");
		text4 = new JTextField(4);

		txtLbl5 = new JLabel("Enter SEE marks\n");
		text5 = new JTextField(4);
		
		panel1=new JPanel();
		panel1.setBounds(0,385,400,35);
		contentPane.add(panel1);
		label1 = new JLabel();					//label for total marks
		panel1.add(label1);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 415, 400, 35);
		contentPane.add(panel2);
		label=new JLabel(); 					//label for grade
		panel2.add(label);
		panel3 = new JPanel();
		panel3.setBounds(0, 0, 400, 35);
		contentPane.add(panel3);
		label3=new JLabel("grade calculator");
		panel3.add(label3);
		
		
		panel.add(txtLbl1);
		panel.add(text1);

		panel.add(txtLbl2);
		panel.add(text2);

		panel.add(txtLbl3);
		panel.add(text3);

		panel.add(txtLbl4);
		panel.add(text4);

		panel.add(txtLbl5);
		panel.add(text5);
		panel.add(button);

		contentPane.setBackground(Color.PINK);
		contentPane.add(panel);

		panel.setLayout(new GridLayout(6, 1, 5, 5));

	}

	// Method for calculating Total Marks
	
	int result() {
		
		int cie;
		int IA1 = Integer.parseInt(text1.getText());
		int IA2 = Integer.parseInt(text2.getText());
		int IA3 = Integer.parseInt(text3.getText());
		int CTA = Integer.parseInt(text4.getText());
		int SEE = Integer.parseInt(text5.getText());
		
		if (IA1 < 0 || IA1 > 20 || IA2 < 0 || IA2 > 20 || IA3 < 0 || IA3 > 20 || CTA < 0 || CTA > 10 || SEE < 0
				|| SEE > 100) {
			flag=1;
			marks = ' ';
			return marks;
		}
		
		float SEE1 = SEE / 2;
		if (IA1 > IA2 && IA3 > IA2) {
			cie = IA1 + IA3 + CTA;
		} else if (IA2 > IA1 && IA3 > IA1) {
			cie = IA2 + IA3 + CTA;
		} else {
			cie = IA1 + IA2 + CTA;
		}
		try {
			if (cie < 20) {
				throw new MarksException("Marks Invalid");
			}
		} catch (MarksException me) {
			JOptionPane.showMessageDialog(null, "Detained for taking SEE", "INFORMATION MESSAGE",
					JOptionPane.INFORMATION_MESSAGE);
		}
		if (SEE < 38) {
			return SEE;
		}
		if (SEE1 % 1 >= 0.5) {
			SEE1++;
		}
		
		marks=(int) (cie + SEE1);
		return marks;
	}

	char grade(int marks) {
		if(marks==32 && flag==1) {
			return ' ';
		}
		if (marks >= 90 && marks <= 100) {
			return 'S';
		} else if (marks >= 80 && marks <= 89) {
			return 'A';
		} else if (marks >= 70 && marks <= 79) {
			return 'B';
		} else if (marks >= 60 && marks <= 69) {
			return 'C';
		} else if (marks >= 50 && marks <= 59) {
			return 'D';
		} else if (marks >= 40 && marks <= 49) {
			return 'E';
		} else {
			return 'F';
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		int IA1 = Integer.parseInt(text1.getText());
		int IA2 = Integer.parseInt(text2.getText());
		int IA3 = Integer.parseInt(text3.getText());
		int CTA = Integer.parseInt(text4.getText());
		int SEE = Integer.parseInt(text5.getText());
		
		// Exception is handled for all the above variables if the user enters the marks out of the range....
		try {
			if (IA1 > 20 || IA1 < 0) {
				throw new MarksException("Marks Invalid");
			}
		} catch (MarksException me) {

			JOptionPane.showMessageDialog(null, "IA-1 marks are invalid-(Range:0-20)", "ERROR MESSAGE",
					JOptionPane.ERROR_MESSAGE);

		}

		try {
			if (IA2 > 20 || IA2 < 0) {
				throw new MarksException("Marks Invalid");
			}
		} catch (MarksException me) {
			JOptionPane.showMessageDialog(null, "IA-2 marks are invalid-(Range:0-20)", "ERROR MESSAGE",
					JOptionPane.ERROR_MESSAGE);
		}
		try {
			if (IA3 > 20 || IA3 < 0) {
				throw new MarksException("Marks Invalid");

			}
		} catch (MarksException me) {
			JOptionPane.showMessageDialog(null, "IA-3 marks are invalid-(Range:0-20)", "ERROR MESSAGE",
					JOptionPane.ERROR_MESSAGE);
		}
		try {
			if (CTA > 10 || CTA < 0) {
				throw new MarksException("Marks Invalid");

			}
		} catch (MarksException me) {
			JOptionPane.showMessageDialog(null, "CTA marks are invalid-(Range:0-10)", "ERROR MESSAGE",
					JOptionPane.ERROR_MESSAGE);
		}
		try {
			if (SEE > 100 || SEE < 0) {
				throw new MarksException("Marks Invalid");
			}
		} catch (MarksException me) {
			JOptionPane.showMessageDialog(null, "SEE marks are invalid-(Range:0-100)", "ERROR MESSAGE",
					JOptionPane.ERROR_MESSAGE);
		}
		
		if(marks==32) {
			label1.setText("total marks:");
		}
		label1.setText("total marks:" + result());
		label.setText("grade :" + grade(marks));
		
	}

}

public class GUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new Cie("Students Grading System");				// Instantiating the frame
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	/* Program should stop when ever clicked 
																			on 'X' button */
		frame.setBounds(400, 220, 415, 488);
		frame.setLayout(null);
		frame.setVisible(true);											// Frame must be visible to user

	}

}