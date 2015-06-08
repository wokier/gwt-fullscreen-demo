package gwtfullscreen.demo.client.view;

import com.google.gwt.user.client.ui.IsWidget;

public interface View extends IsWidget {

	void showFullscreen(boolean fullscreen);

	void activateToggle(boolean active);

	void setPresenter(Presenter presenter);

	void showInput(boolean visible);

	interface Presenter {

		void toggleFullscreen();

	}

}
