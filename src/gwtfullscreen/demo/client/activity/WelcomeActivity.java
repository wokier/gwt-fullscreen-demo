package gwtfullscreen.demo.client.activity;

import gwtfullscreen.Fullscreen;
import gwtfullscreen.demo.client.view.WelcomeView;
import gwtfullscreen.demo.client.view.WelcomeViewImpl;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class WelcomeActivity implements Activity {

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		WelcomeView view = new WelcomeViewImpl();
		view.showFullscreen(Fullscreen.isFullscreen());
		panel.setWidget(view);
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

	}

}
