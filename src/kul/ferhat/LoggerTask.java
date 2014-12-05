package kul.ferhat;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TimerTask;

import org.apache.commons.io.FileUtils;

/**
 * @author ferhatk
 * @since Dec 5, 2014 4:44:29 PM
 *
 */

public class LoggerTask extends TimerTask{
	private Storage storage;
	private String userHome;
	
	public LoggerTask(Storage storage){
		this.storage = storage;
		this.userHome = System.getProperty("user.home");
	}
	
	@Override
	public void run() {
		DataOfHour data = storage.getDataOfCurrentHour();
		System.out.println(data);
		
		try{
			writeDataOfPreviousHourToFile();
			writeDataOfPreviousDayToFile();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void writeDataOfPreviousHourToFile() throws IOException{
		List<DataOfHour> dataList = storage.getDataOfHourList();
		DataOfHour dataOfPreviousHour = null;
		for (DataOfHour data : dataList){
			if (! data.belongsToCurrent()){
				dataOfPreviousHour = data;
			}
		}

		if (dataOfPreviousHour != null){
			FileUtils.writeStringToFile(new File(userHome + "/myp.txt"), 
					dataOfPreviousHour.toStringAsPreviousHour() + "\n", true );
			dataList.remove(dataOfPreviousHour);
		}
	}
	
	private void writeDataOfPreviousDayToFile() throws IOException{
		List<DataOfDay> dataList = storage.getDataOfDayList();
		DataOfDay dataOfPreviousDay = null;
		for (DataOfDay data : dataList){
			if (! data.belongsToCurrent()){
				dataOfPreviousDay = data;
			}
		}

		if (dataOfPreviousDay != null){
			FileUtils.writeStringToFile(new File(userHome + "/myp.txt"), 
					dataOfPreviousDay.toStringAsPreviousDay() + "\n", true );
			dataList.remove(dataOfPreviousDay);
		}
	}
}
