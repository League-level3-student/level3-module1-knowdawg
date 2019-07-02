package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	int guesses = 13;
	String strLives = String.valueOf(guesses);
	
	String l1 = "_ ";
	String l2 = "_ ";
	String l3 = "_ ";
	String l4 = "_ ";
	
	String l1g = "c";
	String l2g = "o";
	String l3g = "o";
	String l4g = "l";
	
	Stack<String> guess = new Stack<String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	public static void main(String[] args) {
		HangMan hangman = new HangMan();
		hangman.run();
	}
	
	public void run() {
		frame.add(panel);
		panel.add(label);
		
		label.setText(l1 + l2 + l3 + l4 + " guesses: " + guesses);
		
		frame.addKeyListener(this);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		Character c = e.getKeyChar();
		String sc = String.valueOf(c);
		if(sc.equals(l1g)) {
			l1 = l1g;
			label.setText(l1 + l2 + l3 + l4 + " Lives: " + guesses);
		}
		if (sc.equals(l2g)) {
			l2 = l2g;
			label.setText(l1 + l2 + l3 + l4 + " Lives: " + guesses);
		}
		if (sc.equals(l3g)) {
			l3 = l3g;
			label.setText(l1 + l2 + l3 + l4 + " Lives: " + guesses);
		}
		if (sc.equals(l4g)) {
			l4 = l4g;
			label.setText(l1 + l2 + l3 + l4 + " Lives: " + guesses);
		}
		guesses -= 1;
		strLives = String.valueOf(guesses);
		label.setText(l1 + l2 + l3 + l4 + " Lives: " + guesses);
		if (guesses == 0) {
			System.exit(0);
		}
		

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
