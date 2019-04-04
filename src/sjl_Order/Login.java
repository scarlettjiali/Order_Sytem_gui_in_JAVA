package sjl_Order;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Login extends JFrame
{
	private JTextField name;
	private JPasswordField password;
	private JButton log;
	private JButton exit;
	private JButton newuser;
	private String nam;
	private char[] passw;
	private String Item="顾客";
	private ArrayList<String> dba=new ArrayList<>();
	public Login()
	{
		try 
		{
			Scanner in=new Scanner(Paths.get("order/login.txt"));
			while(in.hasNext())
			{
				dba.add(in.nextLine());
			}
			in.close();
		} 
		catch (IOException ee) 
		{
			ee.printStackTrace();
		}
		this.setSize(350, 470);
		this.setTitle("秋田日料高级餐厅信息系统");
		Image img=new ImageIcon("sjl_order/logo.jpg").getImage();
		this.setIconImage(img);
		
		//设置框架背景，将图片放在JLayerpane层  
		ImageIcon background=new ImageIcon("sjl_order/bg.png");
        JLabel label=new JLabel(background);
        label.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
       
        JPanel jp = (JPanel) this.getContentPane();  
        jp.setOpaque(false);  

        
		int windowheight=this.getHeight();
		int windowwidth=this.getWidth();
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenheight=screenSize.height;
		int screenwidth=screenSize.width;
		this.setLocation(screenwidth/2-windowwidth/2, screenheight/2-windowheight/2);
		
		//3个panel－上中下
		JPanel northpanel=new JPanel();
		northpanel.setOpaque(false);
		this.add(northpanel,BorderLayout.NORTH);
		JPanel centerpanel=new JPanel();
		centerpanel.setOpaque(false);
		this.add(centerpanel,BorderLayout.CENTER);
		JPanel southpanel=new JPanel();
		southpanel.setOpaque(false);
		this.add(southpanel,BorderLayout.SOUTH);
		
		//north panel 设置
		GridLayout ng=new GridLayout(2,2);
		ng.setVgap(20);
		northpanel.setLayout(ng);
		Border netched=BorderFactory.createEtchedBorder();
		Border ntitled=BorderFactory.createTitledBorder(netched, "Welcome");
		northpanel.setBorder(ntitled);
		northpanel.add(new JLabel("用户名",SwingConstants.CENTER));
		name=new JTextField();
		name.setText(null);
		name.addCaretListener(new CaretListener()
		{
			public void caretUpdate(CaretEvent e)
			{
				nam=name.getText();
			}
		});
		northpanel.add(name);
		northpanel.add(new JLabel("密码",SwingConstants.CENTER));
		password=new JPasswordField();
		northpanel.add(password);
		password.setText(null);
		password.addCaretListener(new CaretListener()
		{
			public void caretUpdate(CaretEvent e)
			{
				passw=password.getPassword();
			}
		});
		
		//center panel 设置
		JPanel c1panel=new JPanel();
		JPanel c2panel=new JPanel();
		c1panel.setOpaque(false);
		c2panel.setOpaque(false);
		centerpanel.add(c1panel,BorderLayout.NORTH);
		centerpanel.add(c2panel,BorderLayout.SOUTH);
		GridLayout cg=new GridLayout(1,2);
		cg.setHgap(20);
		cg.setVgap(20);
		c2panel.setLayout(cg);
		JLabel cr=new JLabel("Role",SwingConstants.CENTER);
		c2panel.add(cr);
		String labels[] = { "顾客", "厨师", "收银员"};
		JComboBox<String> role = new JComboBox<String>(labels);
		role.setEditable(true);
		role.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
		        Item=((JComboBox)e.getSource()).getSelectedItem().toString();
			}
		});
		
		
		c2panel.add(role);
		ImageIcon pict=new ImageIcon("sjl_order/logo.jpg");
		JLabel pic=new JLabel(pict);
		c1panel.add(pic);
		Border cetched=BorderFactory.createEtchedBorder();
		Border ctitled=BorderFactory.createTitledBorder(cetched, "Choose your role");
		centerpanel.setBorder(ctitled);
		
		
		//south panel 设置
		GridLayout sg=new GridLayout(1,3);
		sg.setHgap(10);
		southpanel.setLayout(sg);
		Border setched=BorderFactory.createEtchedBorder();
		Border stitled=BorderFactory.createTitledBorder(setched, "go ahead");
		southpanel.setBorder(stitled);
		log=new JButton("登录");
		southpanel.add(log);
		log.addActionListener(new ActionListener()
		{
			ArrayList<String> dbaa=new ArrayList<>();
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					Scanner inn=new Scanner(Paths.get("order/login.txt"));
					while(inn.hasNext())
					{
						dbaa.add(inn.nextLine());
					}
					inn.close();
				} 
				catch (IOException eee) 
				{
					eee.printStackTrace();
				}
				
				//需要验证身份：用户名、密码、身份是否与数据库匹配
				int flagg=0;//0表示查无此人，需要提示注册（可能是身份不对应）;1可以正常登录;2密码错误
				for(int ii=0;ii<dbaa.size();ii=ii+3)
				{
					//System.out.println("运行过");
					Boolean b11=nam.equals(dbaa.get(ii));//用户名匹配
					Boolean b12=String.valueOf(passw).equals(dbaa.get(ii+1));//密码匹配
					Boolean b13=Item.equals(dbaa.get(ii+2));//身份匹配
					if(b11&&b13)
					{
						if(b12)
						{
							flagg=1;
						}
						if(!b12)
						{
							flagg=2;
						}
					}
				}
				if(flagg==0)
				{
					JOptionPane.showMessageDialog(null, "亲爱的用户，该身份下的用户名尚未注册。\r\n"+"请检查您选择的身份，或注册。");
				}
				if(flagg==2)
				{
					JOptionPane.showMessageDialog(null, "亲爱的用户，您在该身份下的密码输入错误。\r\n"+"请检查您选择的身份，或重新输入密码。");
				}
				
				if(passw!=null&&String.valueOf(passw).length()!=0&&nam!=null&&nam.length()!=0&&flagg==1)
				{
					if(Item=="顾客")
					{
						Image img=new ImageIcon("g:\\photo\\welcome.gif").getImage();
						img=img.getScaledInstance(75, 75, img.SCALE_DEFAULT);
						ImageIcon icon=new ImageIcon(img);
						JOptionPane.showMessageDialog(null, "欢迎"+name.getText()+"！请您点餐！", "顾客您好！", JOptionPane.YES_OPTION,icon);
						setVisible(false);
						customer ctm=new customer(name.getText());
						   ctm.setVisible(true);
					}
					if(Item=="厨师")
					{
						Image imgg=new ImageIcon("g:\\photo\\cook.png").getImage();
						imgg=imgg.getScaledInstance(75, 75, imgg.SCALE_DEFAULT);
						ImageIcon iconn=new ImageIcon(imgg);
						JOptionPane.showMessageDialog(null, "欢迎"+name.getText()+"大厨！", "大厨您好！", JOptionPane.YES_OPTION,iconn);
						setVisible(false);
						chef chf=new chef();
						//chf.setVisible(true);
					}
					if(Item=="收银员")
					{
						Image imgg=new ImageIcon("g:\\photo\\cook.png").getImage();
						imgg=imgg.getScaledInstance(75, 75, imgg.SCALE_DEFAULT);
						ImageIcon iconn=new ImageIcon(imgg);
						JOptionPane.showMessageDialog(null, "欢迎"+name.getText()+"大厨！", "大厨您好！", JOptionPane.YES_OPTION,iconn);
						setVisible(false);
						account act=new account();
						//act.setVisible(true);
					}
				}
				if(nam==null||nam.length()==0)
				{
					JOptionPane.showMessageDialog(null, "用户名不能为空！");
				}
				if(passw==null||String.valueOf(passw).length()==0)
				{
					JOptionPane.showMessageDialog(null, "密码不能为空！");
				}
			}
		});
		
		
		exit=new JButton("退出");
		southpanel.add(exit);
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
			}
		});
		
		
		
		newuser=new JButton("注册");
		southpanel.add(newuser);
		newuser.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int flagg=1;//1表示该用户没有被注册过，用户名可用；如果该用户名已经存在，并且身份一样的话，则将flag设为0

				try 
				{
					Scanner in=new Scanner(Paths.get("order/login.txt"));
					while(in.hasNext())
					{
						dba.add(in.nextLine());
					}
					in.close();
				} 
				catch (IOException ee) 
				{
					ee.printStackTrace();
				}
				
				for(int i=0;i<dba.size();i=i+3)
				{
					if((nam.equals(dba.get(i)))&&Item.equals(dba.get(i+2)))
					{
						flagg=0;
						break;
					}
				}
				
				if(flagg==0)
				{
					JOptionPane.showMessageDialog(null, "您已注册过改系统");
				}
				
				if(nam!=null&&nam.length()!=0&&passw!=null&&String.valueOf(passw).length()!=0&&flagg==1)
				{						
					File f=new File("order/login.txt");
					try
					{
						if(!f.exists())
						{
							f.createNewFile();
						}
						FileWriter out=new FileWriter(f,true);
						
						out.write(nam+"\r\n");
						out.write(String.valueOf(passw)+"\r\n");
						out.write(Item+"\r\n");
						
						out.close();
					}
					catch(IOException ee)
					{
						ee.printStackTrace();
					}
					Image img=new ImageIcon("sjl_order/ok.jpeg").getImage();
					Image tempimg=img.getScaledInstance(75, 75, img.SCALE_DEFAULT);
					ImageIcon icon=new ImageIcon(tempimg);
					JOptionPane.showMessageDialog(null, "注册成功！","HEY",JOptionPane.YES_OPTION,icon);
				}
				
				if(nam==null||nam.length()==0)
				{
					JOptionPane.showMessageDialog(null, "用户名不能为空！");
				}
				if(passw==null||String.valueOf(passw).length()==0)
				{
					JOptionPane.showMessageDialog(null, "密码不能为空！");
				}
			}
		});
		
		
	}
	
	public static void main(String args[])
	{
		Login login1=new Login();
		login1.setVisible(true);
		login1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
