package gwtfullscreen.demo.client.activity;

import gwtfullscreen.Fullscreen;
import gwtfullscreen.FullscreenChangeEvent;
import gwtfullscreen.FullscreenChangeEventBindery;
import gwtfullscreen.demo.client.view.View;
import gwtfullscreen.demo.client.view.ViewImpl;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class FullscreenActivity implements Activity, FullscreenChangeEvent.Handler {

	private boolean fullscreen;

	private HandlerRegistration registration;

	private View view;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		fullscreen = Fullscreen.isFullscreen();
		view = new ViewImpl();
		view.activateToggle(false);
		view.showInput(false);
		view.showFullscreen(fullscreen);
		panel.setWidget(view);
		FullscreenChangeEventBindery.initFullscreenChangeEvent(eventBus);
		registration = eventBus.addHandler(FullscreenChangeEvent.TYPE, this);
	}

	@Override
	public String mayStop() {
		return null;
	}

	@Override
	public void onCancel() {

	}

	@Override
	public void onStop() {
		FullscreenChangeEventBindery.unbindFullscreenChangeEvent();
		registration.removeHandler();
	}

	@Override
	public void onFullscreenChange(FullscreenChangeEvent event) {
		fullscreen = event.isFullscreen();
		view.showFullscreen(fullscreen);
	}

}
