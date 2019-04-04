package sjl_Order;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;


import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class customer extends JFrame {
	ArrayList<Order> neworder=new ArrayList<Order>();
	private String username;
	private JButton M1;
	private JButton M2;
	private JButton M3;
	private JButton M4;
	private JButton M5;
	private JButton M6;
	private JButton M7;
	private JButton M8;
	private JButton M9;
	private JButton M10;
	private JButton xiadan;
	public customer(String username)
	{
		this.username=username;
		this.setTitle("Enjoy your meal!");
		this.setSize(750, 630);
		
		//设置背景图片
		ImageIcon background=new ImageIcon("sjl_order/bgC.jpg");
        JLabel label=new JLabel(background);
        label.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));       
        JPanel jp = (JPanel) this.getContentPane();  
        jp.setOpaque(false);  
		
        //设置窗口位置和大小
		int windowheight=this.getHeight();
		int windowwidth=this.getWidth();
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenheight=screenSize.height;
		int screenwidth=screenSize.width;
		this.setLocation(screenwidth/2-windowwidth/2, screenheight/2-windowheight/2);

		JPanel npanel=new JPanel();
		JPanel cpanel=new JPanel();
		this.add(npanel,BorderLayout.NORTH);
		this.add(cpanel,BorderLayout.CENTER);
		cpanel.setOpaque(false);
		npanel.setOpaque(false);
		
		//north panel 设置
	    ImageIcon pict1=new ImageIcon("sjl_order/clogo1.jpg");
	    ImageIcon pict3=new ImageIcon("sjl_order/clogo3.gif");
	    ImageIcon pict4=new ImageIcon("sjl_order/clogo.jpg");
	    cpanel.setLayout(new GridLayout(1,3));
	    pict4.setImage(pict4.getImage().getScaledInstance(300, 100,  
                Image.SCALE_DEFAULT));
		pict1.setImage(pict1.getImage().getScaledInstance(100, 100,  
                Image.SCALE_DEFAULT));
		pict3.setImage(pict3.getImage().getScaledInstance(100, 100,  
                Image.SCALE_DEFAULT));
		JLabel imgn4=new JLabel(pict4);
		JLabel imgn3=new JLabel(pict3);
		JLabel imgn1=new JLabel(pict1);
		npanel.add(imgn3);
		npanel.add(imgn4);
		npanel.add(imgn1);
		xiadan=new JButton("下单");
		ImageIcon cbuttonxiadan = new ImageIcon("sjl_order/menu/button.jpeg");
		cbuttonxiadan.setImage(cbuttonxiadan.getImage().getScaledInstance(50, 50,  
                Image.SCALE_DEFAULT));
		xiadan.setIcon(cbuttonxiadan);
		npanel.add(xiadan);
		xiadan.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				confirmation confirmm = new confirmation();		
				confirmm.setVisible(true);	
			}
			
		});
		
		//center panel 设置
		cpanel.setLayout(new GridLayout(2,5));
		Border netched=BorderFactory.createEtchedBorder();
		Border ntitled=BorderFactory.createTitledBorder(netched, "menu");
		cpanel.setBorder(ntitled);
		cpanel.setOpaque(false);
		
		
		cpanel.add(eachPanel(M1,"M1套餐",70,"sjl_order/menu/M1.jpg"));
		cpanel.add(eachPanel(M2,"M2套餐",40,"sjl_order/menu/M2.jpg"));
		cpanel.add(eachPanel(M3,"M3套餐",42,"sjl_order/menu/M3.jpg"));
		cpanel.add(eachPanel(M4,"M4套餐",47,"sjl_order/menu/M4.jpg"));
		cpanel.add(eachPanel(M5,"M5套餐",45,"sjl_order/menu/M5.jpg"));
		cpanel.add(eachPanel(M6,"M6套餐",60,"sjl_order/menu/M6.jpg"));
		cpanel.add(eachPanel(M7,"M7套餐",63,"sjl_order/menu/M7.jpg"));
		cpanel.add(eachPanel(M8,"M8套餐",57,"sjl_order/menu/M8.jpg"));
		cpanel.add(eachPanel(M9,"M9套餐",59,"sjl_order/menu/M9.jpg"));
		cpanel.add(eachPanel(M10,"M10套餐",50,"sjl_order/menu/M10.jpg"));
		

		
	}
		public JPanel eachPanel(JButton buttonn,String name,int price,String address)
		{
			JPanel p=new JPanel();
			p.setLayout(new FlowLayout(FlowLayout.CENTER));
			buttonn=new JButton(name);
			buttonn.setToolTipText(name+" "+price+"元");
			ImageIcon imgc=new ImageIcon(address);
			imgc.setImage(imgc.getImage().getScaledInstance(130, 180,Image.SCALE_DEFAULT));
			JLabel addm=new JLabel(imgc);
			p.add(addm);
			p.add(buttonn);
			Border pb=BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white);
			p.setBorder(pb);
			
			buttonn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
				Info n=new Info(name,price,address,username,neworder);
					n.setVisible(true);
				}
			});
			
			return p;	
		}

		class confirmation extends JFrame{
			JPanel panel=new JPanel();
			ArrayList<String> order=new ArrayList<String>();
			String s;
			public confirmation()
			{
				this.setTitle("订单确认");
				this.setSize(500, 300);
				int windowheight=this.getHeight();
				int windowwidth=this.getWidth();
				ImageIcon background=new ImageIcon("sjl_order/bgconfirm.jpg");
				background.setImage(background.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT));
		        JLabel label=new JLabel(background);
		        label.setBounds(0, 0, this.getWidth(), this.getHeight());
		        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		       
		        JPanel jp = (JPanel) this.getContentPane();  
		        jp.setOpaque(false); 
				Toolkit kit=Toolkit.getDefaultToolkit();
				Dimension screenSize=kit.getScreenSize();
				int screenheight=screenSize.height;
				int screenwidth=screenSize.width;
				this.setLocation(screenwidth/2-windowwidth/2, screenheight/2-windowheight/2);


				JPanel Pane=new JPanel();
				Pane.setOpaque(false);
				this.add(Pane);
				Pane.setLayout(new GridLayout(1,2));
				this.add(Pane);
				JPanel westpanel=new JPanel();
				JPanel eastpanel=new JPanel();
				westpanel.setOpaque(false);
				eastpanel.setOpaque(false);
				Pane.add(westpanel);
				Pane.add(eastpanel);
				Border w=BorderFactory.createEtchedBorder();
				Border w1=BorderFactory.createTitledBorder(w,"订单确认");
				Border e=BorderFactory.createEtchedBorder();
				Border e1=BorderFactory.createTitledBorder(e,"谢谢惠顾");
				westpanel.setBorder(w1);
				
				eastpanel.setBorder(e1);
				ImageIcon img=new ImageIcon("sjl_order/bye.gif");
				img.setImage(img.getImage().getScaledInstance(200,250,Image.SCALE_DEFAULT));
				JLabel pic=new JLabel(img);
				eastpanel.add(pic);
				for(int i=0;i<neworder.size();i++)
					addbutt(neworder.get(i),i);
				westpanel.add(panel);
				JButton queding=new JButton("确定");
				westpanel.add(queding);
				queding.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						
						
							for(int xushu=0;xushu<neworder.size();xushu++)
							{
								Order o=neworder.get(xushu);
								
								String drink="冰水";
								String cu="要";
								String jiemo="要";
								
								if(o.getJiemo()==0)
									jiemo="不要";
								if(o.getVingar()==0)
									cu="不要";
				                if(o.getDrink()=="冰水")
				                	drink="冰水";
				                if(o.getDrink()=="可乐")
				                	drink="可乐";
				                if(o.getDrink()=="果汁")
				                	drink="果汁";				
								s=o.getType()+"  "+o.getPrice()+"元/份"+"  "+cu+"醋"+"  "+jiemo+"芥末"+" "+"饮料："+drink;								
								order.add(s);		
							}
							//Login login2=new Login();
							//login2.getNoodles().setVisible(false);
							//n.setVisible(false);
						
							File f=new File("order/order.txt");
							try
							{
								if(!f.exists())
								{
									f.createNewFile();
								}
								FileWriter out=new FileWriter(f, true);
								
								for(int dii=0;dii<order.size();dii++)
									out.write(order.get(dii)+"\r\n");	
								out.close();
							}
							catch(IOException ee)
							{
								ee.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, "食堂师傅已接单，请您稍后", "下单成功", JOptionPane.YES_OPTION,new ImageIcon("sjl_order/smile.jpg"));
							setVisible(false);
						}
					
				});
			
			}
			
			
			
			public ArrayList<Order> addbutt(Order o,int i)
			{
				System.out.print("1");
				JButton butt=new JButton();
				String drink="冰水";
				String cu="要";
				String jiemo="要";
				
				if(o.getJiemo()==0)
					jiemo="不要";
				if(o.getVingar()==0)
					cu="不要";
                if(o.getDrink()=="冰水")
                	drink="冰水";
                if(o.getDrink()=="可乐")
                	drink="可乐";
                if(o.getDrink()=="果汁")
                	drink="果汁";
				String showstring=new String(o.getType()+"  "+o.getPrice()+"元/份"+"  "+cu+"醋"+"  "+jiemo+"芥末"+" "+"饮料："+drink);
				
				butt.setText(showstring);
				butt.setFont(new Font("华文楷体",1, 8));
			    panel.setLayout(new GridLayout(neworder.size(),1));
				panel.add(butt);
				panel.setOpaque(false);
				butt.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						panel.remove(butt);
						panel.repaint();
						panel.setVisible(false);
						panel.setVisible(true);
						neworder.remove(i);
					}
				});
				
				return neworder;
			}
		}


}



