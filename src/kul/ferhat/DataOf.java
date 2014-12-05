package kul.ferhat;

/**
 * @author ferhatk
 * @since Dec 5, 2014 4:36:41 PM
 *
 */

public abstract class DataOf {
	long keyStrokeCount;
	long mouseClickCount;
	
	public DataOf(){
		
	}
	
	public void incrementMouseClicked(int count){
		mouseClickCount = mouseClickCount + count;
	}
	
	public void incrementKeyTyped(){
		keyStrokeCount ++;
	}
	
	public long getKeyStrokeCount() {
		return keyStrokeCount;
	}

	public long getMouseClickCount() {
		return mouseClickCount;
	}
	
	public abstract boolean belongsToCurrent();
}
