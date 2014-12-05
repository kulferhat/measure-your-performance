package kul.ferhat;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * @author ferhatk
 * @since Dec 5, 2014 4:35:11 PM
 *
 */

public class DataOfDay extends DataOf{
	int dayOfYear;
	int year;
	
	public DataOfDay(){
		super();
		
		Calendar cal = Calendar.getInstance();
		dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		year = cal.get(Calendar.YEAR);
	}
	
	@Override
	public boolean belongsToCurrent() {
		Calendar cal = Calendar.getInstance();
		int _dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		int _year = cal.get(Calendar.YEAR);
		
		return (this.dayOfYear == _dayOfYear &&
				this.year == _year);
	}
	
	public String toString(){
	    String sDate = DateFormatUtils.format(new Date(), "yyyy.MM.dd");
		return sDate + 
				" MouseClicked:" + getMouseClickCount() + ", KeyTyped:" + getKeyStrokeCount();
	}
	
	public String toStringAsPreviousDay(){
		long millis = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
	    String sDate = DateFormatUtils.format(new Date(millis), "yyyy.MM.dd");
		return sDate + 
				" MouseClicked:" + getMouseClickCount() + ", KeyTyped:" + getKeyStrokeCount();
	}
}