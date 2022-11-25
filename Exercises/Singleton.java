package exerc;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Singleton {

	private static int count=0;
	private static int maxInstances=1;
	private static Singleton obj=new Singleton();
	
	private Singleton() {
	
	}
	
	
	
	
	
			//static permette di richiamare 
	public static Singleton getSingleton() {
		
		count++;
		
		if (count<maxInstances) 
			return obj;
		
		return null;
		
	}
	

	
	 
	 
	 
	 
	 
	
}