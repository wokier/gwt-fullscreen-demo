package gwtfullscreen.demo.client.bindery;

import gwtfullscreen.demo.client.place.FullscreenPlace;
import gwtfullscreen.demo.client.place.InputPlace;
import gwtfullscreen.demo.client.place.ToggleFullscreenPlace;
import gwtfullscreen.demo.client.place.WelcomePlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ WelcomePlace.Tokenizer.class, FullscreenPlace.Tokenizer.class, ToggleFullscreenPlace.Tokenizer.class, InputPlace.Tokenizer.class })
public interface DemoPlaceHistoryMapper extends PlaceHistoryMapper {
}