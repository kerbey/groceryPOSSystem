package test;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gui 
{
	JButton button = new JButton();
	public void Search()
	{
		System.out.println("now in search method");
		JFrame frame = new JFrame(" Food selection");
		//396475909
		//877828673 blue
		Random colorNumber= new Random();
		System.out.println("colorNumber="+colorNumber.nextInt());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout(2,2,2));
		//frame.setBackground(new Color(colorNumber.nextInt()));

		//ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource ("apple.jpg"));
		ImageIcon apple = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("apple.jpg"))
		.getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT));
		
		ImageIcon brocolli = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("Broccoli.jpg"))
		.getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT));

		JLabel lbl= new JLabel(apple);
		JLabel lbl2= new JLabel(brocolli);
		frame.add(lbl, BorderLayout.EAST);
		frame.add(lbl2, BorderLayout.AFTER_LAST_LINE);
		lbl.setVisible(true);
		lbl2.setVisible(true);
		
		JPanel buttonPanel= new JPanel();
		button= new JButton("button (5.50)");	
		button.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		buttonPanel.add(button);
		frame.add(buttonPanel);
		

		//frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(800,600));
		frame.getContentPane().setBackground(Color.gray);//(new Color(colorNumber.nextInt()));
		button.setBackground(Color.BLACK);//(new Color(colorNumber.nextInt()));
		frame.setVisible(true);		
	}
}


