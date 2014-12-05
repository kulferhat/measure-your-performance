package kul.ferhat;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ferhatk
 * @since Dec 5, 2014 2:58:45 PM
 *
 */

public class Storage {
	private List<DataOfHour> dataOfHourList = new ArrayList<DataOfHour>();
	private List<DataOfDay> dataOfDayList = new ArrayList<DataOfDay>();

	public void storeKeyEvent(){
		DataOfHour dataOfHour = getDataOfCurrentHour();
		dataOfHour.incrementKeyTyped();
		
		DataOfDay dataOfDay = getDataOfCurrentDay();
		dataOfDay.incrementKeyTyped();
		
	}
	
	public void storeMouseEvent(int clickCount){
		DataOfHour dataOfHour = getDataOfCurrentHour();
		dataOfHour.incrementMouseClicked(clickCount);		
		
		DataOfDay dataOfDay = getDataOfCurrentDay();
		dataOfDay.incrementMouseClicked(clickCount);		
	}
	
	public DataOfHour getDataOfCurrentHour(){
		DataOfHour dataOfCurrentHour = null;
		for (DataOfHour data : dataOfHourList){
			if (data.belongsToCurrent()){
				dataOfCurrentHour = data;
				break;
			}
		}
		
		if (dataOfCurrentHour == null){
			dataOfCurrentHour = new DataOfHour();
			dataOfHourList.add(dataOfCurrentHour);
		}
		
		return dataOfCurrentHour;
	}
	
	public DataOfDay getDataOfCurrentDay(){
		DataOfDay dataOfCurrentDay = null;
		for (DataOfDay data : dataOfDayList){
			if (data.belongsToCurrent()){
				dataOfCurrentDay = data;
				break;
			}
		}
		
		if (dataOfCurrentDay == null){
			dataOfCurrentDay = new DataOfDay();
			dataOfDayList.add(dataOfCurrentDay);
		}
		
		return dataOfCurrentDay;
	}
	
	public List<DataOfHour> getDataOfHourList(){
		return dataOfHourList;
	}
	
	public List<DataOfDay> getDataOfDayList(){
		return dataOfDayList;
	}
}
