import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GcdCalculator {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static int numb1, numb2, gcd,list1Size, list2Size;
	static ArrayList<Integer> numb1Factors = new ArrayList<Integer>();
	static ArrayList<Integer> numb2Factors = new ArrayList<Integer>();
	static ArrayList<Integer> commonFactors = new ArrayList<Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GcdCalculator window = new GcdCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GcdCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton CalcButton = new JButton("Find GCD");
		CalcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				numb1 = Integer.parseInt(textField.getText());
				numb2 = Integer.parseInt(textField_1.getText());
				factorsFinder(numb1,numb2);
				gcdFinder();
				textField_2.setText(Integer.toString(gcd));
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, "Please enter valid number");
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
							.addGap(128))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(CalcButton, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
					.addGap(90))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(CalcButton, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
					.addGap(24)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	public static void factorsFinder(int a, int b){

		// for loop iterates through and finds divisors that divide evenly for list a
		for(int i = 1; i <= a; i++){
			if((a%i) == 0){
				numb1Factors.add(i);
			}
		}
		// and for list b
		for(int i = 1; i <= b; i++){
			if((b%i) == 0){
				numb2Factors.add(i);
			}
		}
		//stores the length of each list
		list1Size = numb1Factors.size();
		list2Size = numb2Factors.size();
	}
	public static void gcdFinder(){
		for(int i = 0; i < list1Size; i++){
			for(int x = 0; x < list2Size; x++){
			if(numb1Factors.get(i) == numb2Factors.get(x)){
				commonFactors.add(numb1Factors.get(i));
				}
			}
		}
	
	
	gcd = commonFactors.get(commonFactors.size()-1);
}
}
