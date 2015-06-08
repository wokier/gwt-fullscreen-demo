package gwtfullscreen.demo.client.view;

import static com.google.gwt.query.client.GQuery.$;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;

public class WelcomeViewImpl extends Label implements WelcomeView {

	public WelcomeViewImpl() {
		super("Home");
		getElement().setId("welcome");
		$("#toggle").hide();
		$("#inputContainer").hide();
		getElement().getStyle().setBorderWidth(2, Unit.PX);
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
	}

	@Override
	public void showFullscreen(boolean fullscreen) {
		getElement().getStyle().setBorderColor(fullscreen ? "green" : "tomato");
	}

}
