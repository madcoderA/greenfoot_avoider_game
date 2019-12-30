import greenfoot.*;  

public class Label extends Actor
{
	GreenfootImage msg;

	public Label(String s, int size) {
		this(s, size, Color.WHITE);
	}  
	
	public Label(String s, int size, Color c) {
		msg = new GreenfootImage(s, size, c, null);
		setImage(msg);
	}  
}