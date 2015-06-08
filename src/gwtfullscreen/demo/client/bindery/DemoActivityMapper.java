package gwtfullscreen.demo.client.bindery;

import static com.google.gwt.query.client.GQuery.$;
import gwtfullscreen.demo.client.activity.FullscreenActivity;
import gwtfullscreen.demo.client.activity.ToggleFullscreenActivity;
import gwtfullscreen.demo.client.activity.ToggleFullscreenWithInputActivity;
import gwtfullscreen.demo.client.activity.WelcomeActivity;
import gwtfullscreen.demo.client.place.DemoPlace;
import gwtfullscreen.demo.client.place.FullscreenPlace;
import gwtfullscreen.demo.client.place.InputPlace;
import gwtfullscreen.demo.client.place.ToggleFullscreenPlace;
import gwtfullscreen.demo.client.place.WelcomePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class DemoActivityMapper implements ActivityMapper, DemoPlace.Visitor<Void, Activity> {

	public DemoActivityMapper() {
		super();
	}

	@Override
	public Activity getActivity(Place place) {
		DemoPlace demoPlace = (DemoPlace) place;
		$("a").removeClass("active");
		$("a#" + demoPlace.getId()).addClass("active");
		return demoPlace.accept(this, null);
	}

	@Override
	public Activity visitWelcome(WelcomePlace place, Void input) {
		return new WelcomeActivity();
	}

	@Override
	public Activity visitFullscreen(FullscreenPlace place, Void input) {
		return new FullscreenActivity();
	}

	@Override
	public Activity visitToggleFullscreen(ToggleFullscreenPlace place, Void input) {
		return new ToggleFullscreenActivity();
	}

	@Override
	public Activity visitInput(InputPlace place, Void input) {
		return new ToggleFullscreenWithInputActivity();
	}

}