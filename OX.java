package OXTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;

import javax.swing.JFrame;


public class OX  implements ActionListener
{
	
	JFrame window = new JFrame();
	Board board = new Board(250, 50, 450, 450, window);
	JButton newGame, Exit;
	
	public OX() 
	{
		window.setLayout(null);
		window.setSize (800,600); // szerokoœæ , wysokoœæ
		window.setTitle ("Kó³ko i Krzy¿yk");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	
	
		
		window.add(board);
		

		newGame = new JButton ("Nowa gra");
		newGame.setBounds(50, 50, 100, 50);
		newGame.setBackground(Color.cyan);
		newGame.setVisible(true);
		newGame.addActionListener(this);
		
		window.add(newGame);
		
		Exit = new JButton ("Wyjœcie");
		Exit.setBounds(50, 150, 100, 50);
		Exit.setBackground(Color.cyan);
		Exit.setVisible(true);
		Exit.addActionListener(this);
		
		window.add(Exit);
	}	
	
	public void whatever()
	{
	
		System.out.println("cokolwiek");
	}
	
public void actionPerformed(ActionEvent e) {
		
		Object what = e.getSource();
	
		if(what==Exit) 
			window.dispose();
		
		if(what==newGame)
		{
			board.clearTable();
			
			
		}
			
	}
	
}//class OX
