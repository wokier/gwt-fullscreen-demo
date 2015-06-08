package gwtfullscreen.demo.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;

public class InputPlace extends DemoPlace {

	@Override
	public <I, O> O accept(Visitor<I, O> visitor, I input) {
		return visitor.visitInput(this, input);
	}

	public static class Tokenizer implements PlaceTokenizer<InputPlace> {
		@Override
		public String getToken(InputPlace place) {
			return "";
		}

		@Override
		public InputPlace getPlace(String token) {
			return new InputPlace();
		}
	}

	@Override
	public String getId() {
		return "inputLink";
	}

}
