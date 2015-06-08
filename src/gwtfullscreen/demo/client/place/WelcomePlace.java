package gwtfullscreen.demo.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class WelcomePlace extends DemoPlace {

	@Override
	public <I, O> O accept(Visitor<I, O> visitor, I input) {
		return visitor.visitWelcome(this, input);
	}

	public static class Tokenizer implements PlaceTokenizer<WelcomePlace> {
		@Override
		public String getToken(WelcomePlace place) {
			return "";
		}

		@Override
		public WelcomePlace getPlace(String token) {
			return new WelcomePlace();
		}
	}

	@Override
	public String getId() {
		return "welcomeLink";
	}

}
