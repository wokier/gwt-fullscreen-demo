package gwtfullscreen.demo.client;

import static com.google.gwt.query.client.GQuery.$;
import gwtfullscreen.Fullscreen;
import gwtfullscreen.demo.client.bindery.DemoActivityMapper;
import gwtfullscreen.demo.client.bindery.DemoPlaceHistoryMapper;
import gwtfullscreen.demo.client.place.WelcomePlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.query.client.Function;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class DemoEntryPoint implements EntryPoint, UncaughtExceptionHandler {

	public static PlaceController placeController;

	@Override
	public void onModuleLoad() {

		GWT.setUncaughtExceptionHandler(this);

		SimpleLayoutPanel display = new SimpleLayoutPanel();

		EventBus eventBus = new SimpleEventBus();
		placeController = new PlaceController(eventBus);

		ActivityMapper activityMapper = new DemoActivityMapper();
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(display);

		DemoPlaceHistoryMapper historyMapper = GWT.create(DemoPlaceHistoryMapper.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, new WelcomePlace());

		display.getElement().getStyle().setBackgroundColor("lightgray");
		RootLayoutPanel.get().getElement().getStyle().setMarginTop(26, Unit.PX);
		RootLayoutPanel.get().add(display);
		historyHandler.handleCurrentHistory();

		$("#fullscreenLink").click(new Function() {
			@Override
			public boolean f(Event e) {
				Fullscreen.requestFullscreen();
				return true;
			}
		});

	}

	@Override
	public void onUncaughtException(Throwable e) {
		Window.alert(e.getClass() + " " + e.getMessage());
	}
}
