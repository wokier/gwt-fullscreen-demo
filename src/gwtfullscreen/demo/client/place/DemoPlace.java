package gwtfullscreen.demo.client.place;

import com.google.gwt.place.shared.Place;

public abstract class DemoPlace extends Place {

	public interface Visitor<I, O> {

		O visitWelcome(WelcomePlace place, I input);

		O visitFullscreen(FullscreenPlace place, I input);

		O visitToggleFullscreen(ToggleFullscreenPlace place, I input);

		O visitInput(InputPlace place, I input);

	}

	public abstract <I, O> O accept(Visitor<I, O> visitor, I input);

	public abstract String getId();

}
