package four.pda.ui.article.one;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import four.pda.EventBus;
import four.pda.Preferences_;
import four.pda.R;

/**
 * Created by asavinova on 25/03/16.
 */
@EViewGroup(R.layout.text_zoom_view)
public class TextZoomPanel extends LinearLayout {

	@ViewById TextView textSizeView;

	@Bean EventBus eventBus;
	@Pref Preferences_ preferences;

	public TextZoomPanel(Context context) {
		super(context);
	}

	public TextZoomPanel(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TextZoomPanel(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@UiThread
	public void setZoom(int zoom) {
		textSizeView.setText(getResources().getString(R.string.zoom_text_size, zoom));
	}

	@Click(R.id.decrease_view)
	void decrease() {
		int zoom = preferences.textZoom().get();
		zoom(zoom - 10);
	}

	@Click(R.id.increase_view)
	void increase() {
		int zoom = preferences.textZoom().get();
		zoom(zoom + 10);
	}

	@Click(R.id.close_view)
	void close() {
		setVisibility(GONE);
	}

	@Click(R.id.reset_view)
	void reset() {
		zoom(100);
	}

	private void zoom(int zoom) {
		setZoom(zoom);
		preferences.textZoom().put(zoom);
		eventBus.post(new SetTextZoomEvent(zoom));
	}

}
