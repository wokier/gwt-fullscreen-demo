package gwtfullscreen.demo.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class ToggleFullscreenPlace extends DemoPlace {

	@Override
	public <I, O> O accept(Visitor<I, O> visitor, I input) {
		return visitor.visitToggleFullscreen(this, input);
	}

	public static class Tokenizer implements PlaceTokenizer<ToggleFullscreenPlace> {
		@Override
		public String getToken(ToggleFullscreenPlace place) {
			return "";
		}

		@Override
		public ToggleFullscreenPlace getPlace(String token) {
			return new ToggleFullscreenPlace();
		}
	}

	@Override
	public String getId() {
		return "toggleFullscreenLink";
	}

}
