package kul.ferhat;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

/**
 * @author ferhatk
 * @since Dec 5, 2014 2:07:14 PM
 *
 */

public class SystemListener implements NativeKeyListener, NativeMouseInputListener	{
	
	private Storage storage;
	public SystemListener(Storage storage){
		this.storage = storage;
	}

	@Override
	public void nativeMouseClicked(NativeMouseEvent arg0) {
		storage.storeMouseEvent(arg0.getClickCount());
	}

	@Override
	public void nativeMousePressed(NativeMouseEvent arg0) {
	}

	@Override
	public void nativeMouseReleased(NativeMouseEvent arg0) {
	}

	@Override
	public void nativeMouseDragged(NativeMouseEvent arg0) {
	}

	@Override
	public void nativeMouseMoved(NativeMouseEvent arg0) {
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		storage.storeKeyEvent();
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
	}
}
