package gwtfullscreen.demo.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class FullscreenPlace extends DemoPlace {

	@Override
	public <I, O> O accept(Visitor<I, O> visitor, I input) {
		return visitor.visitFullscreen(this, input);
	}

	public static class Tokenizer implements PlaceTokenizer<FullscreenPlace> {
		@Override
		public String getToken(FullscreenPlace place) {
			return "";
		}

		@Override
		public FullscreenPlace getPlace(String token) {
			return new FullscreenPlace();
		}
	}

	@Override
	public String getId() {
		return "fullscreenLink";
	}

}
