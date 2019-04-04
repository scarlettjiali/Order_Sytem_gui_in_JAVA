package sjl_Order;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
public class Info extends JFrame{
	ArrayList<Order> neworder;
	private String username;
	private String type;
	private int price;
	

	public Info(String type,int price,String address,String username,ArrayList<Order> neworder){
		this.neworder=neworder;
		this.username=username;
		this.type=type;
		this.price=price;
		ImageIcon img=new ImageIcon(address);
		
		this.setTitle(type);
		this.setSize(500, 435);
		int windowheight=this.getHeight();
		int windowwidth=this.getWidth();
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screenheight=screenSize.height;
		int screenwidth=screenSize.width;
		this.setLocation(screenwidth/2-windowwidth/2, screenheight/2-windowheight/2);
		
		ImageIcon bginfo=new ImageIcon("sjl_order/bginf.jpg");
        JLabel label=new JLabel(bginfo);
        label.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
       
        JPanel jp = (JPanel) this.getContentPane();  
        jp.setOpaque(false);
		
        JPanel panel=new JPanel();
        panel.setOpaque(false);  
		panel.setLayout(new GridLayout(2,1));
		this.add(panel);
		JPanel npanel=new JPanel();
		JPanel spanel=new JPanel();
		npanel.setOpaque(false); 
		spanel.setOpaque(false); 
		panel.add(npanel);
		panel.add(spanel);
		Border n=BorderFactory.createEtchedBorder();
		Border n1=BorderFactory.createTitledBorder(n,"选择配料");
		npanel.setBorder(n1);
		Border s=BorderFactory.createEtchedBorder();
		Border s1=BorderFactory.createTitledBorder(s,"选择免费饮料");
		spanel.setBorder(s1);
		npanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel pic=new JLabel(img);
		npanel.add(pic);	
		JCheckBox vingar=new JCheckBox("醋",true);
		JCheckBox jiemo=new JCheckBox("芥末",true);
		vingar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			if(vingar.isSelected()){
			}
			}
			});
		jiemo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			if(jiemo.isSelected()){
			}
			}
			});
		
		//ActionLis listener=new ActionLis();	
		//vingar.addActionListener(listener);
		//jiemo.addActionListener(listener);
		npanel.add(vingar);
		npanel.add(jiemo);
		
		
		spanel.setLayout(new GridLayout(1,4));
		JButton water=new JButton ();
		JButton cola=new JButton();
		JButton juice=new JButton();
		JButton conf=new JButton();
		water.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			if(water.isSelected()){
			}
			}
			});
		cola.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			if(cola.isSelected()){
			}
			}
			});
		juice.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			if(juice.isSelected()){
			}
			}
			});
		//water.addActionListener(listener);
		//cola.addActionListener(listener);
		//juice.addActionListener(listener);
		water.setToolTipText("冰水");
		cola.setToolTipText("可乐");
		juice.setToolTipText("果汁");
		
		ImageIcon shui = new ImageIcon("sjl_order/drink/d1.jpg");
		ImageIcon kele = new ImageIcon("sjl_order/drink/d2.png");
		ImageIcon guozhi = new ImageIcon("sjl_order/drink/d3.jpg");
		ImageIcon confirm = new ImageIcon("sjl_order/drink/conf.jpg");
		
		shui.setImage(shui.getImage().getScaledInstance(100,150,Image.SCALE_DEFAULT));
		kele.setImage(kele.getImage().getScaledInstance(100,150,Image.SCALE_DEFAULT));
		guozhi.setImage(guozhi.getImage().getScaledInstance(100,150,Image.SCALE_DEFAULT));
		confirm.setImage(confirm.getImage().getScaledInstance(100,150,Image.SCALE_DEFAULT));
		water.setIcon(shui);
		cola.setIcon(kele);
		juice.setIcon(guozhi);
		conf.setIcon(confirm);
		
		spanel.add(water);
		spanel.add(cola);
		spanel.add(juice);
		spanel.add(conf);
		
		conf.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{   
				int v=1,j=1;
				if((vingar.isSelected())!=true) v=0;
				if(jiemo.isSelected()!=true) j=0;
				String drink="冰水";
				if(juice.isSelected()) drink="果汁";
				if(water.isSelected()) drink="冰水";
				if(cola.isSelected()) drink="可乐";
				neworder.add(new Order(username,type,price,v,j,drink));
				JOptionPane.showMessageDialog(panel, "已加入", "提示", JOptionPane.YES_OPTION, new ImageIcon("sjl_order/drink/conf.jpg"));
				setVisible(false);
			}
		});
	    
		/*class ActionLis implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				String v="不要";
				if(vingar.isSelected())
					v="要";
				
				String j="不要";
				if(jiemo.isSelected())
					j="要";
					
				String drink="mei";
				if(juice.isSelected())
					drink="冰水";
				if(juice.isSelected())
					drink="可乐";
				if(juice.isSelected())
					drink="果汁";
				
				//show.setText(type+"\n"+price+"元\n"+xiangc+"香菜\n"+congh+"葱花\n"+kouw+"\n"+numm+"份");
			}
		}*/
	}
	
}

