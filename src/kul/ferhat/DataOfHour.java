package kul.ferhat;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * @author ferhatk
 * @since Dec 5, 2014 4:35:41 PM
 *
 */

public class DataOfHour extends DataOf{
	int hourOfDay;
	int dayOfYear;
	int year;
	long keyStrokeCount;
	long mouseClickCount;
	
	public DataOfHour(){
		super();
		
		Calendar cal = Calendar.getInstance();
		hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		year = cal.get(Calendar.YEAR);
	}	

	public boolean belongsToCurrent(){
		Calendar cal = Calendar.getInstance();
		int _hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		int _dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
		int _year = cal.get(Calendar.YEAR);
		
		return (this.hourOfDay == _hourOfDay &&
				this.dayOfYear == _dayOfYear &&
				this.year == _year);
	}
	
	public String toString(){
	    String sDate = DateFormatUtils.format(new Date(), "yyyy.MM.dd:kk");
		return sDate + 
				" MouseClicked:" + getMouseClickCount() + ", KeyTyped:" + getKeyStrokeCount();
	}
	
	public String toStringAsPreviousHour(){
		long millis = System.currentTimeMillis() - 1000 * 60 * 60 ;
	    String sDate = DateFormatUtils.format(new Date(millis), "yyyy.MM.dd:kk");
		return sDate + 
				" MouseClicked:" + getMouseClickCount() + ", KeyTyped:" + getKeyStrokeCount();
	}
}