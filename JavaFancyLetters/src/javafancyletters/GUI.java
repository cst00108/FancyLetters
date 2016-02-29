package javafancyletters;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JPanel{

	public static void main(String[] args) {
		GUI gui = new GUI();
		JFrame frame = gui.getFrame();
	}
	

	private JFrame getFrame(){
		JFrame toReturn = new JFrame("Fancy Letters");
		final int FONTS = 13;

		JPanel panel =  new JPanel(new GridLayout(FONTS+1, 1));

		JTextField[] outputFields = new JTextField[FONTS];
		for(int index=0; index<outputFields.length; index++){
			outputFields[index] = getOutputField();
		}
		
		JTextField inputField = getInputField(outputFields);
		panel.add(inputField);  //user enters into this field

		for(int index=0; index<outputFields.length; index++){
			panel.add(outputFields[index]);
		}

		toReturn.getContentPane().add(panel);

		toReturn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		toReturn.setResizable(false);
		toReturn.pack();
		toReturn.setLocationRelativeTo(null);
		toReturn.setVisible(true);
		
		return toReturn;
	}
	
	
	private JTextField getInputField(final JTextField[] outputFields){
		final JTextField toReturn = new JTextField(50);		

		toReturn.setText(
				"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
		toReturn.selectAll();
		
		setFont(toReturn);
		getResults(toReturn, outputFields);

		toReturn.addKeyListener(new KeyAdapter(){
			public void keyReleased(KeyEvent e){
				getResults(toReturn, outputFields);
			}
		});
		return toReturn;
	} 
	
	
	private static void getResults(
			JTextField inputField, JTextField[] outputFields){

		for(int index=0; index<outputFields.length; index++){
			String string = 
					FancyLetters.getFancy(inputField.getText(), index);
			outputFields[index].setText(string);
		}
	}
	
	
	private static void setFont(JTextField field){
		//Font font = field.getFont().deriveFont(52);
		//field.setFont(font);
		//what the hell???????
		
		field.setFont(new Font(null, Font.PLAIN, 12));
	}
	

	private JTextField getOutputField(){
		final JTextField toReturn = new JTextField(50);
		toReturn.setEditable(false);
		setFont(toReturn);
		
		toReturn.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				//toReturn.copy();
				copy(toReturn.getText());
				toReturn.setText(
						"𝑪𝒐𝒑𝒊𝒆𝒅 𝒕𝒐 𝒄𝒍𝒊𝒑𝒃𝒐𝒂𝒓𝒅 (...𝒖𝒎, 𝒄𝒐𝒑𝒑𝒊𝒆𝒅? ..." +
						"𝒉𝒐𝒘 𝒅𝒐 𝒚𝒐𝒖 𝒔𝒑𝒆𝒍𝒍... 𝒕𝒉𝒂𝒕 𝒘𝒐𝒓𝒅???)");
			}
		});
		
		return toReturn;
	} 
	
		
	private void copy(String string){
		StringSelection selection = new StringSelection(string);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
	}
}