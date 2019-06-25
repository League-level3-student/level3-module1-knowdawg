package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.crypto.dsig.keyinfo.KeyValue;

public class _02_TextUndoRedo implements KeyListener{
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	
	Stack<String> list = new Stack<String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	public static void main(String[] args) {
		_02_TextUndoRedo TUR = new _02_TextUndoRedo();
		TUR.run();
	}
	
	public void run() {
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
			if (list.size() > 0) {
				list.pop();
				label.setText(String.valueOf(list));
				frame.pack();
			} else {
				label.setText("Congrats, you cleared the Stack. I hope your happy.");
				frame.pack();
			}
		} else {
			Character c = e.getKeyChar();
			String sc = String.valueOf(c);
			list.push(sc); 
			label.setText(String.valueOf(list));
			frame.pack();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

