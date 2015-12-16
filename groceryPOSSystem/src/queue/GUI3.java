package queue;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Heap.PriQOverflowException;
import Heap.heap;

public class GUI3<T> extends JPanel
{
	static String recieptFile="food.txt", changeRecieptFile="changeFile.txt",line="", Input, message;
	public static int count=0, custNumber=0, appleCount=10, bananasCount=10, brocolliCount=10,flourCount=10, sugarCount=10
			, oilCount=10, cheeseCount=10,waterMelonCount=10, lettuceCount=10, carrotsCount=10;
	double cash;
	static PrintWriter textStream= textfile.createTextWrite(recieptFile);
	JFrame frame, notEnoughFrame;
	JTextField textbox;
	JButton done, apple, bananas, brocolli, delete, ok, back, flour, sugar, oil, cheese,
	waterMelon, forward, lettuce, carrots, Return;
	JPanel buttonPanel;
	public double amountToSpend;
	private ImageIcon image;
	private JLabel lbl;
	public Customer  customer3;
	heap<String> Heap;
	public void paint(Graphics g)
	{	
		int fontSize = 20;
		g.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
		g.setColor(Color.BLACK);
		g.drawString(message, 300, 450);//first number moves string right second moves it up
	}
	public void GUI( Customer car3, heap<String> heap)
	{
		Heap=heap;
		customer3=car3;		
		numberOfCustomers();
		return;
	}
	public void numberOfCustomers()
	{
		{
			System.out.println("customer"+customer3.customerNumber);
			cash=customer3.cash;
			Search();
		}
	}
	public void Search()
	{
		message="Please select your food";
		frame = new JFrame("(3) Please select your food");
		JPanel textPanel= new JPanel();
		buttonPanel= new JPanel();
		ImageIcon applePicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("apple.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon brocolliPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("Broccoli.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon bananaPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("Banana.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon carrotPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("carrots.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon lettucePicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("lettuce.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		frame.getContentPane().setBackground(Color.gray.brighter());//(new Color(colorNumber.nextInt()));
		frame.setLayout(new FlowLayout(2,2,2));

		JLabel lbl= new JLabel(applePicture);
		frame.add(lbl, BorderLayout.BEFORE_FIRST_LINE);
		lbl.setVisible(true);
		JLabel space= new JLabel("       ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl2= new JLabel(brocolliPicture);
		frame.add(lbl2, BorderLayout.BEFORE_FIRST_LINE);
		lbl2.setVisible(true);
		space= new JLabel("        ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl3= new JLabel(bananaPicture);
		frame.add(lbl3, BorderLayout.BEFORE_FIRST_LINE);
		lbl3.setVisible(true);
		space= new JLabel("        ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl4= new JLabel(carrotPicture);
		frame.add(lbl4, BorderLayout.BEFORE_FIRST_LINE);
		lbl4.setVisible(true);
		space= new JLabel("       ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl5= new JLabel(lettucePicture);
		frame.add(lbl5, BorderLayout.BEFORE_FIRST_LINE);
		lbl5.setVisible(true);
		space= new JLabel("    ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		buttonPanel.setLayout(new GridLayout(2,1));	
		apple= new JButton("apple (3.40)");	
		apple.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( appleCount!=0)
				{
					appleCount--;
					System.out.println(" apples left "+appleCount);
					count++;
					amountToSpend=amountToSpend+3.40;
					System.out.println("amount to Spend="+amountToSpend);
					line+="apple  $3.40";
					textStream.println(count+" "+line);
				}
				else
				{
					System.out.println("no more apples "+appleCount);
				}
			}
		});
		apple.setBackground(Color.gray.brighter());
		apple.setOpaque(true);
		buttonPanel.add(apple);

		brocolli= new JButton("brocolli (7.70)");		
		brocolli.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( brocolliCount!=0)
				{
					brocolliCount--;
					count++;
					amountToSpend=amountToSpend+7.70;
					System.out.println("amount to Spend="+amountToSpend);
					line="brocolli  $7.70";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel.setBackground(Color.gray.brighter());

		buttonPanel.add(brocolli);

		bananas= new JButton("bananas (5.50)");		
		bananas.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( bananasCount!=0)
				{
					bananasCount--;
					count++;
					amountToSpend=amountToSpend+5.50;
					System.out.println("amount to Spend="+amountToSpend);
					line="bananas  $5.50";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel.add(bananas);

		carrots= new JButton("carrots (4.00)");		
		carrots.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( carrotsCount!=0)
				{
					carrotsCount--;
					count++;
					amountToSpend=amountToSpend+4.00;
					System.out.println("amount to Spend="+amountToSpend);
					line="carrots  $4.00";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel.add(carrots);


		lettuce= new JButton("lettuce (9.00)");		
		lettuce.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( lettuceCount!=0)
				{
					lettuceCount--;
					count++;
					amountToSpend=amountToSpend+9.00;
					System.out.println("amount to Spend="+amountToSpend);
					line="lettuce  $9.00";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel.add(lettuce);

		forward= new JButton("forward >");		
		forward.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				Search2nd();
			}
		});
		buttonPanel.add(forward);//*/


		Return= new JButton("Return");		
		Return.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count=0;
				amountToSpend=0;
				textStream.close();
				//numberOfCustomers();
			}
		});
		buttonPanel.add(Return);

		new done();
		new deleteAction();
		textbox= new JTextField(50);
		textbox.setPreferredSize(new Dimension(300,100));
		JTextArea textArea = new JTextArea(5, 20);
		textbox.add(textArea);

		textPanel.add(textbox);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(buttonPanel, BorderLayout.AFTER_LINE_ENDS);
		//frame.add(textPanel, BorderLayout.SOUTH);

		frame.setSize(new Dimension(700,600));
		frame.setVisible(true);	
		return;
	 }

	public void Search2nd()
	{
		message="Please select your food";
		frame = new JFrame(" Please select your food");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().add(new GUI3());
		JPanel textPanel= new JPanel();
		buttonPanel= new JPanel();
		setLayout(new FlowLayout(2,2,2));

		ImageIcon watermelonPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("watermelon2.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon cheesePicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("cheese.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon oilPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("oil.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon sugarPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("sugar.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon flourPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("flour.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		frame.getContentPane().setBackground(Color.gray.brighter());
		frame.setLayout(new FlowLayout(2,2,2));

		JLabel lbl= new JLabel(watermelonPicture);
		frame.add(lbl, BorderLayout.BEFORE_FIRST_LINE);
		lbl.setVisible(true);
		JLabel space= new JLabel("           ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl2= new JLabel(cheesePicture);
		frame.add(lbl2, BorderLayout.BEFORE_FIRST_LINE);
		lbl2.setVisible(true);
		space= new JLabel("            ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl3= new JLabel(oilPicture);
		frame.add(lbl3, BorderLayout.BEFORE_FIRST_LINE);
		lbl3.setVisible(true);
		space= new JLabel("            ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl4= new JLabel(sugarPicture);
		frame.add(lbl4, BorderLayout.BEFORE_FIRST_LINE);
		lbl4.setVisible(true);
		space= new JLabel("               ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl5= new JLabel(flourPicture);
		frame.add(lbl5, BorderLayout.BEFORE_FIRST_LINE);
		lbl5.setVisible(true);
		space= new JLabel("    ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);

		buttonPanel.setLayout(new GridLayout(2,1));	
		waterMelon= new JButton("waterMelon (9.30)");	
		waterMelon.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(waterMelonCount!=0)
				{
					waterMelonCount--;
					count++;
					amountToSpend=amountToSpend+9.30;
					System.out.println("amount to Spend="+amountToSpend);
					line="waterMelon  $9.30";
					textStream.println(count+" "+line);
				}
			}
		});
		waterMelon.setBackground(Color.gray.brighter());
		buttonPanel.setBackground(Color.gray.brighter());
		buttonPanel.add(waterMelon);

		cheese= new JButton("cheese (4.04)");		
		cheese.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(cheeseCount!=0)
				{
					cheeseCount--;
					count++;
					amountToSpend=amountToSpend+4.04;
					System.out.println("amount to Spend="+amountToSpend);
					line="cheese  $4.04";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel.add(cheese);

		oil= new JButton("oil (10.50)");		
		oil.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(oilCount!=0)
				{
					oilCount--;
					count++;
					amountToSpend=amountToSpend+10.50;
					System.out.println("amount to Spend="+amountToSpend);
					line="oil  $10.50";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel.add(oil);

		sugar= new JButton("sugar (14.00)");		
		sugar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(sugarCount!=0)
				{
					sugarCount--;
					count++;
					amountToSpend=amountToSpend+14.00;
					System.out.println("amount to Spend="+amountToSpend);
					line="sugar  $14.00";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel.add(sugar);

		flour= new JButton("flour (15.00)");		
		flour.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(flourCount!=0)
				{
					flourCount--;
					count++;
					amountToSpend=amountToSpend+15.00;
					System.out.println("amount to Spend="+amountToSpend);
					line="flour  $15.00";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel.add(flour);

		back= new JButton("< back");		
		back.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				Search();
			}
		});
		buttonPanel.add(back);

		Return= new JButton("Return");		
		Return.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count=0;
				amountToSpend=0;
				textStream.close();
				//numberOfCustomers();
			}
		});
		buttonPanel.add(Return);

		new done();
		new deleteAction();
		textbox= new JTextField(50);
		textbox.setPreferredSize(new Dimension(300,50));
		textPanel.add(textbox);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		Random number= new Random();
		frame.setBackground(new Color(number.nextInt()));
		frame.setSize(new Dimension(800,600));
		frame.setVisible(true);		
	}


	public void notEnough()
	{
		message=" You don't have enough money";
		notEnoughFrame = new JFrame("not enough money, hit x to close");
		notEnoughFrame.getContentPane().add(new GUI3());
		buttonPanel= new JPanel();
		buttonPanel.setLayout(new GridLayout(2,1));	


		ok= new JButton("ok");	
		ok.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count=0;
				amountToSpend=0;
				line=null;
				notEnoughFrame.dispose();
				//numberOfCustomers();
			}
		});
		buttonPanel.add(ok);

		notEnoughFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		notEnoughFrame.add(buttonPanel, BorderLayout.SOUTH);
		notEnoughFrame.setSize(new Dimension(800,600));
		notEnoughFrame.setVisible(true);		
	}
	public void clearReciept()
	{
		textStream = textfile.createTextWrite(changeRecieptFile);

		System.out.println("about to clear Reciept");
		JFrame frame = new JFrame("about to clearReciept");
		int maxCount=count;
		System.out.println("maxco"+maxCount);
		for(count=1; count<=maxCount; count++)
		{
			line=" ";
			textStream.println(line);
		}
		textStream.close();


		buttonPanel= new JPanel();
		buttonPanel.setLayout(new GridLayout(2,1));	
		ok= new JButton("ok");	
		ok.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				Scanner scanFile = createNewTextRead(changeRecieptFile);

				for(count=1; count<=maxCount; count++)
				{
					line= scanFile.nextLine();
				}
				scanFile.close();

				textStream = createTextWrite(recieptFile);
				for(count=1; count<=maxCount; count++)
				{
					line=" ";
					textStream.println(line);
				}
				textStream.close();

			}

			private Scanner createNewTextRead(String changeRecieptFile)
			{
				Scanner textFile=null;
				try 
				{
					textFile= new Scanner(new FileInputStream(new File(changeRecieptFile)));
				}
				catch(FileNotFoundException e)
				{
					System.out.println("file not found "+changeRecieptFile.toString());
					System.out.println("or could not be opened. "+changeRecieptFile.toString());
				}
				return textFile;
			}

			private PrintWriter createTextWrite(String recieptFile)
			{
				PrintWriter TStream=null;
				try
				{
					TStream= new PrintWriter(new FileOutputStream(recieptFile));
				}
				catch(FileNotFoundException e)
				{
					System.out.println("Error opening the file in createTextWrite "+recieptFile.toString());
				}
				return TStream;
			}
		});

		buttonPanel.add(ok);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.setSize(new Dimension(200,200));
		frame.setVisible(true);		
	}//*/
	public class done implements ActionListener
	{
		public done()
		{
			done= new JButton("done");		
			buttonPanel.add(done);
			done.addActionListener(this);
			done.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("cust.cash="+customer3.cash);
					System.out.println("amounttospeed="+amountToSpend);
					customer3.cash=(int) amountToSpend;
					if(cash>=amountToSpend)
					{
						System.out.println("ENOUGH MONEY $"+cash);
						count++;
						line=(count+" you are paying "+cash);
						textStream.println(line);

						count++;
						line=(count+" total   "+amountToSpend);
						textStream.println(line);

						count++;
						System.out.println("highest count=="+count);
						line=(count+" your change "+(cash-amountToSpend));

						customer3.cash= amountToSpend;
						T adding= (T) Double.toString(customer3.cash);


						try 
						{
							System.out.println();
							Heap.enqueue((String) adding);

							System.out.println();

						} catch (PriQOverflowException e1) {
							e1.printStackTrace();
						}



						amountToSpend=0;
						textStream.println(line);
						textfile t= new textfile( recieptFile);	
					}
					else if(cash<amountToSpend)
					{
						count=0;
						amountToSpend=0;
						System.out.println("NOT ENOUGH MONEY $"+cash);
						textStream.close();
						notEnough();
					}
				}
			});
		}		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==done)
			{
				frame.dispose();
			}
		}
	}
	public static class textfile
	{
		textfile(String recieptFile)
		{//build food
			String w =recieptFile;
			textStream.close();
			int maxCount=count;
			System.out.println("textfile method");
			Scanner scanFile= textfile.createTextRead(w);
			for(count=1;count<=maxCount;count++)//fix limit
			{
				System.out.println("count= "+count);
				count=scanFile.nextInt();
				line = scanFile.nextLine();
				System.out.println("line"+line);

				System.out.println(count + line);
			}scanFile.close();
		}
		public static PrintWriter createTextWrite(String S)
		{
			PrintWriter TStream=null;
			try
			{
				TStream= new PrintWriter(new FileOutputStream(S));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("Error opening the file in createTextWrite "+S.toString());
			}
			return TStream;
		}
		public static Scanner createTextRead(String S)
		{
			Scanner textFile=null;
			try 
			{
				textFile= new Scanner(new FileInputStream(new File(S)));
			}
			catch(FileNotFoundException e)
			{
				System.out.println("file not found "+S.toString());
				System.out.println("or could not be opened. "+S.toString());
			}
			return textFile;
		}
	}
	public class deleteAction implements ActionListener
	{
		public deleteAction()
		{
			delete= new JButton("delete option");		
			buttonPanel.add(delete);
			delete.addActionListener(this);
			delete.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
				}
			});
		}		
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==delete)
			{
				Delete();
			}
		}
	}
	public void Delete()
	{
		message=" Delete what ever food you want";
		frame = new JFrame(" Delete what ever food you want.");
		frame.getContentPane().add(new GUI3());
		Random colorNumber= new Random(396475909);
		frame.setForeground(new Color(colorNumber.nextInt()));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel textPanel= new JPanel();
		buttonPanel= new JPanel();
		JPanel buttonPanel2nd= new JPanel();
		ImageIcon applePicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("apple.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon brocolliPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("Broccoli.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon bananaPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("Banana.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon carrotPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("carrots.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon lettucePicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("lettuce.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		frame.getContentPane().setBackground(Color.gray.brighter());
		frame.setLayout(new FlowLayout(2,2,2));

		JLabel lbl= new JLabel(applePicture);
		frame.add(lbl, BorderLayout.BEFORE_FIRST_LINE);
		lbl.setVisible(true);
		JLabel space= new JLabel("           ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl2= new JLabel(brocolliPicture);
		frame.add(lbl2, BorderLayout.BEFORE_FIRST_LINE);
		lbl2.setVisible(true);
		space= new JLabel("            ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl3= new JLabel(bananaPicture);
		frame.add(lbl3, BorderLayout.BEFORE_FIRST_LINE);
		lbl3.setVisible(true);
		space= new JLabel("        ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl4= new JLabel(carrotPicture);
		frame.add(lbl4, BorderLayout.BEFORE_FIRST_LINE);
		lbl4.setVisible(true);
		space= new JLabel("       ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl5= new JLabel(lettucePicture);
		frame.add(lbl5, BorderLayout.BEFORE_FIRST_LINE);
		lbl5.setVisible(true);
		space= new JLabel("                        ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		buttonPanel.setLayout(new FlowLayout(2,2,2));		
		buttonPanel.setBackground(Color.gray.brighter());
		buttonPanel2nd.setBackground(Color.gray.brighter());


		apple= new JButton("apple (-3.40)");	
		apple.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( appleCount<10)
				{
					appleCount++;
					System.out.println("apple left "+appleCount);
					count++;
					amountToSpend=amountToSpend-3.40;
					System.out.println("amount to Spend="+amountToSpend);
					line+="apple  -$3.40";
					textStream.println(count+" "+line);
				}
			}
		});
		apple.setBackground(Color.red);
		buttonPanel.add(apple);

		brocolli= new JButton("brocolli (-7.70)");		
		brocolli.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( brocolliCount<10)
				{
					brocolliCount++;
					count++;
					amountToSpend=amountToSpend-7.70;
					System.out.println("amount to Spend="+amountToSpend);
					line="brocolli  -$7.70";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel.add(brocolli);

		bananas= new JButton("bananas (-5.50)");		
		bananas.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( bananasCount<10)
				{
					bananasCount++;
					count++;
					amountToSpend=amountToSpend-5.50;
					System.out.println("amount to Spend="+amountToSpend);
					line="bananas -$5.50";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel.add(bananas);

		carrots= new JButton("carrots (-4.00)");		
		carrots.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( carrotsCount<10)
				{
					carrotsCount++;
					count++;
					amountToSpend=amountToSpend-4.00;
					System.out.println("amount to Spend="+amountToSpend);
					line="carrots  -$4.00";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel.add(carrots);		

		lettuce= new JButton("lettuce (-9.00)");		
		lettuce.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend-9.00;
				System.out.println("amount to Spend="+amountToSpend);
				line="lettuce  -$9.00";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(lettuce);


		forward= new JButton("forward >");		
		forward.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				Delete2nd();
			}
		});
		buttonPanel2nd.add(forward);

		Return= new JButton("Return");		
		Return.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count=0;
				amountToSpend=0;
				textStream.close();
			}
		});
		buttonPanel2nd.add(Return);

		new done();
		textbox= new JTextField(50);
		textbox.setPreferredSize(new Dimension(300,100));
		textPanel.add(textbox);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(buttonPanel, BorderLayout.AFTER_LINE_ENDS);
		frame.add(buttonPanel2nd, BorderLayout.AFTER_LINE_ENDS);

		frame.setSize(new Dimension(800,600));
		frame.setVisible(true);	
	}
	public void Delete2nd()
	{
		message=" Delete what ever food you want";
		frame = new JFrame(" Other Food deduction");
		frame.getContentPane().add(new GUI3());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel textPanel= new JPanel();
		buttonPanel= new JPanel();
		JPanel buttonPanel2nd= new JPanel();

		setLayout(new FlowLayout(2,2,2));

		ImageIcon watermelonPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("watermelon2.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon cheesePicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("cheese.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon oilPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("oil.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon sugarPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("sugar.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		ImageIcon flourPicture = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource ("flour.jpg"))
		.getImage().getScaledInstance(100, 90, Image.SCALE_DEFAULT));

		frame.getContentPane().setBackground(Color.gray.brighter());
		frame.setLayout(new FlowLayout(2,2,2));

		JLabel lbl= new JLabel(watermelonPicture);
		frame.add(lbl, BorderLayout.BEFORE_FIRST_LINE);
		lbl.setVisible(true);
		JLabel space= new JLabel("             ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl2= new JLabel(cheesePicture);
		frame.add(lbl2, BorderLayout.BEFORE_FIRST_LINE);
		lbl2.setVisible(true);
		space= new JLabel("            ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl3= new JLabel(oilPicture);
		frame.add(lbl3, BorderLayout.BEFORE_FIRST_LINE);
		lbl3.setVisible(true);
		space= new JLabel("                  ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl4= new JLabel(sugarPicture);
		frame.add(lbl4, BorderLayout.BEFORE_FIRST_LINE);
		lbl4.setVisible(true);
		space= new JLabel("                  ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);
		JLabel lbl5= new JLabel(flourPicture);
		frame.add(lbl5, BorderLayout.BEFORE_FIRST_LINE);
		lbl5.setVisible(true);
		space= new JLabel("    ");
		frame.add(space, BorderLayout.BEFORE_FIRST_LINE);
		space.setVisible(true);


		buttonPanel2nd.setLayout(new GridLayout(1,2));	
		buttonPanel2nd.setBackground(Color.gray.brighter());
		buttonPanel.setBackground(Color.gray.brighter());


		waterMelon= new JButton("waterMelon (-9.30)");	
		waterMelon.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( waterMelonCount<10)
				{
					waterMelonCount++;
					count++;
					amountToSpend=amountToSpend-9.30;
					System.out.println("amount to Spend="+amountToSpend);
					line="waterMelon  -$9.30";
					textStream.println(count+" "+line);
				}
			}
		});
		waterMelon.setBackground(Color.red);

		buttonPanel2nd.add(waterMelon);

		cheese= new JButton("cheese (-4.04)");		
		cheese.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( cheeseCount<10)
				{
					cheeseCount++;
					count++;
					amountToSpend=amountToSpend-4.04;
					System.out.println("amount to Spend="+amountToSpend);
					line="cheese  -$4.04";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel2nd.add(cheese);

		oil= new JButton("oil (-10.50)");		
		oil.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( oilCount<10)
				{
					oilCount++;
					count++;
					amountToSpend=amountToSpend-10.50;
					System.out.println("amount to Spend="+amountToSpend);
					line="oil  -$10.50";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel2nd.add(oil);

		sugar= new JButton("sugar (-14.00)");		
		sugar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( sugarCount<10)
				{
					sugarCount++;
					count++;
					amountToSpend=amountToSpend-14.00;
					System.out.println("amount to Spend="+amountToSpend);
					line="sugar  -$14.00";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel2nd.add(sugar);

		flour= new JButton("flour (-15.00)");		
		flour.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if( flourCount<10)
				{
					flourCount++;
					count++;
					amountToSpend=amountToSpend-15.00;
					System.out.println("amount to Spend="+amountToSpend);
					line="flour  -$15.00";
					textStream.println(count+" "+line);
				}
			}
		});
		buttonPanel2nd.add(flour);

		back= new JButton("< back");		
		back.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				Delete();
			}
		});
		buttonPanel.add(back);

		Return= new JButton("Return");		
		Return.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count=0;
				amountToSpend=0;
				textStream.close();
			}
		});
		buttonPanel.add(Return);

		new done();
		

		textbox= new JTextField(50);
		textbox.setPreferredSize(new Dimension(300,50));
		textPanel.add(textbox);

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(buttonPanel2nd, BorderLayout.SOUTH);
		frame.add(buttonPanel, BorderLayout.CENTER);
		Random number= new Random();
		frame.setBackground(new Color(number.nextInt()));
		frame.setSize(new Dimension(830,600));
		frame.setVisible(true);		
	}
}
