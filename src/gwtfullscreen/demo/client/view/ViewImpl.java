package gwtfullscreen.demo.client.view;

import static com.google.gwt.query.client.GQuery.$;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;

public class ViewImpl extends SimpleLayoutPanel implements View, ClickHandler {

	Presenter presenter;

	private Image image;

	private HandlerRegistration registration;

	private GQuery button;

	public ViewImpl() {
		image = new Image(buildUrl(800, 600));
		setWidget(image);
		getElement().getStyle().setBorderWidth(2, Unit.PX);
		getElement().getStyle().setBorderStyle(BorderStyle.SOLID);
	}

	private String buildUrl(int width, int height) {
		return "http://fakeimg.pl/" + width + "x" + height + "/";
	}

	@Override
	public void showFullscreen(boolean fullscreen) {
		getElement().getStyle().setBorderColor(fullscreen ? "green" : "tomato");
		$("#toggle").text(fullscreen ? "✘" : "➚");
		$("#toggle").attr("title", fullscreen ? "Exit Fulllscreen" : "Go fullscreen");
	}

	@Override
	public void showInput(boolean visible) {
		if (visible) {
			$("#inputContainer").show();
		} else {
			$("#inputContainer").hide();
		}
	}

	@Override
	public void onResize() {
		super.onResize();
		Scheduler.get().scheduleDeferred(new Command() {
			@Override
			public void execute() {
				image.setUrl(buildUrl(getElement().getOffsetWidth(), getElement().getOffsetHeight()));
			}
		});
	}

	@Override
	public void activateToggle(boolean active) {
		if (active) {
			$("#toggle").show().click(new Function() {
				@Override
				public boolean f(Event e) {
					presenter.toggleFullscreen();
					return true;
				}
			});
		} else {
			$("#toggle").hide().unbind("click");
		}
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void onClick(ClickEvent event) {
		presenter.toggleFullscreen();
	}

}
