//package groceryPOSSystem;
package queue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import javax.swing.JTextField;

public class GUI extends JFrame
{
	static String recieptFile="food.txt", changeRecieptFile="changeFile.txt",line="", Input;
	public static int count=0, custNumber=0, appleCount=10, bananasCount=10, brocolliCount=10,flourCount=10, sugarCount=10
			, oilCount=10, cheeseCount=10,waterMelonCount=10, lettuceCount=10, carrotsCount=10;
	double cash;
	static PrintWriter textStream= textfile.createTextWrite(recieptFile);
	JFrame frame;
	JTextField textbox;
	JButton done, apple, bananas, brocolli, delete, ok, back, flour, sugar, oil, cheese,
	waterMelon, forward, lettuce, carrots, Return;
	JPanel buttonPanel;//, buttonPanel2nd;
	public double amountToSpend;
	private ImageIcon image;
	private JLabel lbl;
	public Customer customer,  customer2,  customer3,  customer4,  customer5;
	public  GUI(Customer car, Customer car2, Customer car3, Customer car4, Customer car5)
	{
		System.out.println("customer 1");
		customer= car;
		customer2=car2;
		customer3=car3;
		customer4=car4;
		customer5=car5;
		custNumber++;
		numberOfCustomers();
	}
	public void numberOfCustomers()
	{
		if(custNumber==1)
		{
			System.out.println("customer1");
			cash=customer.cash;
			System.out.println("customer cash "+customer.cash);
			Search();
		}
		else if(custNumber==2)
		{
			System.out.println("customer2");
			cash=customer2.cash;
			Search();
		}
		else if(custNumber==3)
		{
			System.out.println("customer3");
			cash=customer3.cash;
			Search();
		}
		else if(custNumber==4)
		{
			System.out.println("customer4");
			cash=customer4.cash;
			Search();
		}
		else if(custNumber==5)
		{
			System.out.println("customer5");
			cash=customer5.cash;
			Search();
		}
	}
	public void Search()
	{
		custNumber=custNumber+1;
		JFrame frame = new JFrame(" Food selection");
		Random colorNumber= new Random(396475909);
		frame.setForeground(new Color(colorNumber.nextInt()));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel textPanel= new JPanel();
		buttonPanel= new JPanel();
		//buttonPanel2nd= new JPanel();
		setLayout(new FlowLayout());
		//image = new ImageIcon(getClass().getResource("apple.jpeg"));

		//lbl= new JLabel(image);
		//frame.add(lbl, BorderLayout.NORTH);

		//imageLabel.setBounds(10, 10, 400, 400);
		//imageLabel.setVisible(true);
		//Game.f.setLayout(new FlowLayout);


		buttonPanel.setLayout(new GridLayout(2,1));	

		apple= new JButton("apple (3.40)");	
		//apple.setBackground();
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
					//textbox.setText(line+" ");
					//textbox.setText("\n ");
					textStream.println(count+" "+line);
				}
				else
				{
					System.out.println("no more apples "+appleCount);
				}
			}
		});
		apple.setBackground(Color.red);
		buttonPanel.add(apple);

		brocolli= new JButton("brocolli (7.70)");		
		brocolli.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend+7.70;
				System.out.println("amount to Spend="+amountToSpend);
				line="brocolli  $7.70";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(brocolli);

		bananas= new JButton("bananas (5.50)");		
		bananas.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend+5.50;
				System.out.println("amount to Spend="+amountToSpend);
				line="bananas  $5.50";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(bananas);

		forward= new JButton("forward >");		
		forward.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//count--;
				Search2nd();
			}
		});
		buttonPanel.add(forward);//*/

		lettuce= new JButton("lettuce (9.00)");		
		lettuce.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend+9.00;
				System.out.println("amount to Spend="+amountToSpend);
				line="lettuce  $9.00";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(lettuce);

		carrots= new JButton("carrots (4.00)");		
		carrots.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend+4.00;
				System.out.println("amount to Spend="+amountToSpend);
				line="carrots  $4.00";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(carrots);

		Return= new JButton("Return");		
		Return.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count=0;
				amountToSpend=0;
				textStream.close();
				numberOfCustomers();
			}
		});
		buttonPanel.add(Return);

		new done();
		new deleteAction();
		textbox= new JTextField(50);
		textbox.setPreferredSize(new Dimension(300,100));
		//buttonPanel.add(lbl);
		textPanel.add(textbox);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(textPanel, BorderLayout.NORTH);
		//frame.add(buttonPanel2nd, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.setSize(new Dimension(800,600));
		frame.setVisible(true);		
	}

	public void Search2nd()
	{
		JFrame frame = new JFrame(" Other Food selection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel textPanel= new JPanel();
		buttonPanel= new JPanel();
		setLayout(new FlowLayout());
		//image = new ImageIcon(getClass().getResource("apple.JPEG"));

		//lbl= new JLabel(image);
		//frame.add(lbl, BorderLayout.NORTH);

		buttonPanel.setLayout(new GridLayout(2,1));	
		waterMelon= new JButton("waterMelon (9.30)");	
		//apple.setBackground();
		waterMelon.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend+9.30;
				System.out.println("amount to Spend="+amountToSpend);
				line="waterMelon  $9.30";
				textStream.println(count+" "+line);
			}
		});
		waterMelon.setBackground(Color.red);
		buttonPanel.add(waterMelon);

		cheese= new JButton("cheese (4.04)");		
		cheese.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend+4.04;
				System.out.println("amount to Spend="+amountToSpend);
				line="cheese  $4.04";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(cheese);

		oil= new JButton("oil (10.50)");		
		oil.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend+10.50;
				System.out.println("amount to Spend="+amountToSpend);
				line="oil  $10.50";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(oil);

		sugar= new JButton("sugar (14.00)");		
		sugar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend+14.00;
				System.out.println("amount to Spend="+amountToSpend);
				line="sugar  $14.00";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(sugar);

		flour= new JButton("flour (15.00)");		
		flour.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend+15.00;
				System.out.println("amount to Spend="+amountToSpend);
				line="flour  $15.00";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(flour);

		back= new JButton("< back");		
		back.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//count--;
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
				numberOfCustomers();
			}
		});
		buttonPanel.add(Return);

		new done();
		new deleteAction();
		textbox= new JTextField(50);
		textbox.setPreferredSize(new Dimension(300,50));
		//buttonPanel.add(lbl);
		textPanel.add(textbox);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(textPanel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		Random number= new Random();
		frame.setBackground(new Color(number.nextInt()));
		frame.setSize(new Dimension(800,600));
		frame.setVisible(true);		
	}

	public void notEnough()
	{
		JFrame frame = new JFrame();
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
				//numberOfCustomers();
			}
		});
		buttonPanel.add(ok);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.setSize(new Dimension(800,600));
		frame.setVisible(true);		
	}
	public void clearReciept()
	{
		textStream = textfile.createTextWrite(changeRecieptFile);

		//changeRecieptFile
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
				
				count=0;
				numberOfCustomers();
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
						amountToSpend=0;
						textStream.println(line);
						textfile t= new textfile( recieptFile);	
						//count=0;
					}
					else if(cash<amountToSpend)
					{//not enought money
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
				clearReciept();
				//numberOfCustomers();
				//				if(custNumber<=5)
				//				{
				//					numberOfCustomers();
				//				}
				//				else
				//				{
				//					System.exit(0);
				//				}
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
		JFrame frame = new JFrame(" Food deduction");
		Random colorNumber= new Random(396475909);
		frame.setForeground(new Color(colorNumber.nextInt()));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel textPanel= new JPanel();
		buttonPanel= new JPanel();
		//buttonPanel2nd= new JPanel();
		setLayout(new FlowLayout());
		//image = new ImageIcon(getClass().getResource("apple.jpeg"));

		//lbl= new JLabel(image);
		//frame.add(lbl, BorderLayout.NORTH);

		//imageLabel.setBounds(10, 10, 400, 400);
		//imageLabel.setVisible(true);
		//Game.f.setLayout(new FlowLayout);


		buttonPanel.setLayout(new GridLayout(2,1));	

		apple= new JButton("apple (-3.40)");	
		//apple.setBackground();
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
					textbox.setText(line);
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
				count++;
				amountToSpend=amountToSpend-7.70;
				System.out.println("amount to Spend="+amountToSpend);
				line="brocolli  -$7.70";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(brocolli);

		bananas= new JButton("bananas (-5.50)");		
		bananas.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend-5.50;
				System.out.println("amount to Spend="+amountToSpend);
				line="bananas -$5.50";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(bananas);

		forward= new JButton("forward >");		
		forward.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//count--;
				Delete2nd();
			}
		});
		buttonPanel.add(forward);//*/

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

		carrots= new JButton("carrots (-4.00)");		
		carrots.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend-4.00;
				System.out.println("amount to Spend="+amountToSpend);
				line="carrots  -$4.00";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(carrots);

		Return= new JButton("Return");		
		Return.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count=0;
				amountToSpend=0;
				textStream.close();
				numberOfCustomers();
			}
		});
		buttonPanel.add(Return);

		new done();
		textbox= new JTextField(50);
		textbox.setPreferredSize(new Dimension(300,100));
		//buttonPanel.add(lbl);
		textPanel.add(textbox);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(textPanel, BorderLayout.NORTH);
		//frame.add(buttonPanel2nd, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.setSize(new Dimension(800,600));
		frame.setVisible(true);	
	}
	public void Delete2nd()
	{
		JFrame frame = new JFrame(" Other Food deduction");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel textPanel= new JPanel();
		buttonPanel= new JPanel();
		setLayout(new FlowLayout());
		//image = new ImageIcon(getClass().getResource("apple.JPEG"));

		//lbl= new JLabel(image);
		//frame.add(lbl, BorderLayout.NORTH);

		buttonPanel.setLayout(new GridLayout(2,1));	
		waterMelon= new JButton("waterMelon (-9.30)");	
		//apple.setBackground();
		waterMelon.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend-9.30;
				System.out.println("amount to Spend="+amountToSpend);
				line="waterMelon  -$9.30";
				textStream.println(count+" "+line);
			}
		});
		waterMelon.setBackground(Color.red);
		buttonPanel.add(waterMelon);

		cheese= new JButton("cheese (-4.04)");		
		cheese.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend-4.04;
				System.out.println("amount to Spend="+amountToSpend);
				line="cheese  -$4.04";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(cheese);

		oil= new JButton("oil (-10.50)");		
		oil.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend-10.50;
				System.out.println("amount to Spend="+amountToSpend);
				line="oil  -$10.50";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(oil);

		sugar= new JButton("sugar (-14.00)");		
		sugar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend-14.00;
				System.out.println("amount to Spend="+amountToSpend);
				line="sugar  -$14.00";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(sugar);

		flour= new JButton("flour (-15.00)");		
		flour.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				count++;
				amountToSpend=amountToSpend-15.00;
				System.out.println("amount to Spend="+amountToSpend);
				line="flour  -$15.00";
				textStream.println(count+" "+line);
			}
		});
		buttonPanel.add(flour);

		back= new JButton("< back");		
		back.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//count--;
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
				numberOfCustomers();
			}
		});
		buttonPanel.add(Return);

		new done();
		textbox= new JTextField(50);
		textbox.setPreferredSize(new Dimension(300,50));
		//buttonPanel.add(lbl);
		textPanel.add(textbox);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(textPanel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.SOUTH);
		Random number= new Random();
		frame.setBackground(new Color(number.nextInt()));
		frame.setSize(new Dimension(800,600));
		frame.setVisible(true);		
	}
}
