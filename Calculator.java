package lab7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
	private int current;
	private int userinput;
	private JTextField output;
	private JButton[] buttonsnum;
	private JButton[] operations;
	
	public void processDigit(int digitPressed){
		String s;
		userinput = userinput*10+digitPressed;
		s = String.valueOf(userinput);
		output.setText(s);
		
	}
	
	public void operationmanager(char operation){
		switch(operation){
		case '+':current+=userinput;
		break;
		case '-':current-=userinput;
		break;
		case '*':current*=userinput;
		break;
		case '/':current/=userinput;
		break;
		}
		userinput=0;
		String s = String.valueOf(current);
		output.setText(s);
		
	}
	
	public Calculator(){
		super("Calculator");
		char[] operationsArray = {'+','-','*','/'};
		setLayout(new FlowLayout());
		output = new JTextField(10);
		add(output);
		buttonsnum = new JButton[10];
		operations = new JButton[4];
		for (int i = 0; i < 10; i++){
			buttonsnum[i] = new JButton(String.valueOf(i));
			buttonsnum[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					processDigit(Integer.parseInt(e.getActionCommand()));
				}
			}
			);
			if (i > 0){
				add(buttonsnum[i]);
			}     
		}		
		buttonsnum[0].setPreferredSize(new Dimension(130, 25)); 
		add(buttonsnum[0]);
		for (int i = 0; i < 4; i++){
			operations[i] = new JButton();
			operations[i].setPreferredSize(new Dimension(50, 25));
			operations[i].setText(String.valueOf(operationsArray[i]));
			operations[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					operationmanager(e.getActionCommand().charAt(0));
				}
			}
			);
			add(operations[i]);
		}
		
		setSize(160, 260);
		setVisible(true);
	
	}
	
	public static void main(String args[]){
		Calculator aFrame = new Calculator();
		}
	
	

}
