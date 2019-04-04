package sjl_Order;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Order 
{
	private String username;
	private String type;
	private int price;
	private int vingar;
	private int jiemo;
	private String drink;
	private String time;
	
	public Order(String username,String type,int price,int jiemo,int vingar,String drink)
	{
		
		this.username=username;
		this.type=type;
		this.price=price;
		this.vingar=vingar;
		this.jiemo=jiemo;
		this.drink=drink;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.time=df.format(new Date());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getDrink() {
		return drink;
	}
	
	public void setDrink(String drink) {
		this.drink = drink;
	}
    
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getJiemo() {
		return jiemo;
	}

	public void setJiemo(int jiemo) {
		this.jiemo = jiemo;
	}

	public int getVingar() {
		return vingar;
	}

	public void setVingar(int vingar) {
		this.vingar = vingar;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}

