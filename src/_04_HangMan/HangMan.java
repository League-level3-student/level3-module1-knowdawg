package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	
	Utilities wordFinder = new Utilities();
	String word = wordFinder.readRandomLineFromFile("dictionary.txt");
	int letters = word.length();
	
	
	int guesses = 18;
	String strLives = String.valueOf(guesses);

	Stack<String> guess = new Stack<String>();
	Stack<String> answer = new Stack<String>();
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	public static void main(String[] args) {
		HangMan hangman = new HangMan();
		hangman.run();
	}

	
	public void run() {
		
		for (int i = 0; i < letters; i++) {
			guess.push("_ ");
		}
		
		for (int i = 0; i < letters; i++) {
			String charectar = String.valueOf(word.charAt(i));
			answer.push(charectar);
		}
		System.out.println(answer);
		
		frame.add(panel);
		panel.add(label);
		
		label.setText( guess + " guesses: " + guesses);
		
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
		for (int i = 0; i < answer.size(); i++) {
			
			if(sc.equals(answer.get(i))) {
				
				guess.set(i, answer.get(i));
			}
			
		} 
		guesses -= 1;
		label.setText( guess + " guesses: " + guesses);
		
		if(guess.equals(answer)) {
			JOptionPane.showMessageDialog(null, "YOU WIN!");
			guesses = 0;
		}
		if(guesses == 0) {
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
