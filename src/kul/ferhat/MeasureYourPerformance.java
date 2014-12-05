package kul.ferhat;

import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

/**
 * @author ferhatk
 * @since Dec 5, 2014 2:04:41 PM
 *
 */

public class MeasureYourPerformance {
    private static final Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());

	public static void main(String[] args) {
		
        // Disable parent logger and set the desired level.
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);

		
		try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }
		
		final Storage storage = new Storage();

		SystemListener listener = new SystemListener(storage);

		GlobalScreen.getInstance().addNativeKeyListener(listener);
        GlobalScreen.getInstance().addNativeMouseListener(listener);
        
        LoggerTask task = new LoggerTask(storage);
        new Timer().schedule(task, 1000 * 60, 1000 * 60);
	}
}
