/**
 * Simple text label 
 * 
 * @author Michael Haungs
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */
import greenfoot.*;  

public class Label extends Actor
{
	public Label(String message, int fontSize) {
		this(message, fontSize, Color.WHITE);
	}  
	
	public Label(String message, int fontSize, Color color) {
		final GreenfootImage label = new GreenfootImage(message, fontSize, color, null);
		setImage(label);
	}  
}