package OXTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener
{

	
	private static final long serialVersionUID = 1L;
	char[] symboltable = new char[9];
	char nextSymbol = 'O';
	boolean isEnded = false;
	JFrame w;
	JDialog d;
	JButton end;
	JButton[] table = new JButton[9];
	
	public Board(int x, int y, int width, int height, JFrame window)
	{
		this.w = window;
		this.setVisible(true);
		this.setBounds(x, y, width, height);
		this.setBackground(Color.blue);
		Font myFont = new Font("Arial", Font.BOLD, 48);
		for (int i=0; i<9; i++)
		{
			this.table[i] = new JButton();
			table[i].addActionListener(this);
			symboltable[i]=' ';
			this.table[i].setText(" ");
			this.table[i].setFont(myFont);
			this.add(table[i]);
		}
		
		GridLayout layout = new GridLayout(3,3,5,5);
		this.setLayout(layout);
		
		
		
	}
	
	void switchSymbol()
	{
		if (this.nextSymbol =='O')
			this.nextSymbol = 'X';
		else
			this.nextSymbol = 'O';
	}
	
	void clearTable()
	{
		for (int i=0; i<9; i++)
		{
			table[i].setText(" ");
			symboltable[i]=' ';
		}
		this.nextSymbol = 'O';
		this.isEnded = false;
	}
	
	boolean checkIfEnded()
	{
		if ((symboltable[ 0 ] == symboltable [ 1 ] &&  symboltable [ 1 ] ==  symboltable [ 2 ])
				&& (symboltable[ 0 ]=='X'||symboltable[ 0 ]=='O'))
		{ this.isEnded = true; return true;}
		
		if ((symboltable[ 3 ] == symboltable [ 4 ] &&  symboltable [ 4 ] ==  symboltable [ 5 ])
			&& (symboltable[ 3 ]=='X'||symboltable[ 3 ]=='O')) 
		{ this.isEnded = true; return true;}
		
		if((symboltable[ 6 ] == symboltable [ 7 ] &&  symboltable [ 7 ] ==  symboltable [ 8 ])
			&& (symboltable[ 6 ]=='X'||symboltable[ 6 ]=='O'))
		{ this.isEnded = true; return true;}
		
		///////////////////////////////////////////////////////////////////////
		
		if ((symboltable[ 0 ] == symboltable [ 3] &&  symboltable [ 3 ] ==  symboltable [ 6 ])
			&& (symboltable[ 0 ]=='X'||symboltable[ 0 ]=='O'))
		{ this.isEnded = true; return true;}
		
		if ((symboltable[ 1 ] == symboltable [ 4 ] &&  symboltable [ 4 ] ==  symboltable [ 7 ])
			&& (symboltable[ 1 ]=='X'||symboltable[ 1 ]=='O'))
		{ this.isEnded = true; return true;}
		
		if ((symboltable[ 2] == symboltable [ 5 ] &&  symboltable [ 5 ] ==  symboltable [ 8 ])
			&& (symboltable[ 2 ]=='X'||symboltable[ 2 ]=='O'))
		{ this.isEnded = true; return true;}
		
		//////////////////////////////////////////////////////////////////////
		
		if ((symboltable[ 0 ] == symboltable [ 4] &&  symboltable [ 4] ==  symboltable [ 8 ])
			&& (symboltable[ 0 ]=='X'||symboltable[ 0 ]=='O'))
		{ this.isEnded = true; return true;}
		
		if ((symboltable[ 2 ] == symboltable [ 4 ] &&  symboltable [ 4 ] ==  symboltable [ 6 ])
			&& (symboltable[ 2 ]=='X'||symboltable[ 2 ]=='O'))
		{ this.isEnded = true; return true;}
		
		
		
		return false;
	}
	
	void notifyVictory()
	{
		Font myFont = new Font("Arial", Font.ITALIC, 24);
		d = new JDialog(w,"Koniec gry", true);
		d.setSize(300, 200);
		
		
		end = new JButton("Wygrywa : "+this.nextSymbol+" !!!");
		end.setFont(myFont);
		end.setVisible(true);
		end.addActionListener(this);
		
		d.add(end);
		d.setVisible(true);
	
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object aaa = e.getSource();
		if (aaa==end)
		{
			d.dispose();
			this.clearTable();
			this.switchSymbol();//nie mam pojecie czemu tak musi byc, ale jak tak jest to jest dobrze
			return;
		}
		
		int i = 0;
	
		for (; i<9; i++ )
		{
			if (aaa == table[i])
				break;
		}
		
		if (table[i].getText()==" " && !isEnded)
		{
			table[i].setText(this.nextSymbol+"");
			symboltable[i] = this.nextSymbol;
			
			if ( checkIfEnded() )
			notifyVictory();
			
			this.switchSymbol();
			
			
		}
	}
}
