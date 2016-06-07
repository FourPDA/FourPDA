package four.pda.ui.article.search;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import four.pda.EventBus;
import four.pda.EventBus_;
import four.pda.R;
import four.pda.dao.SearchArticleDao;
import four.pda.ui.ViewUtils;
import four.pda.ui.article.ShowArticleEvent;

/**
 * Created by asavinova on 08/05/16.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {

	@Bind(R.id.image_view) ImageView imageView;
	@Bind(R.id.title_view) TextView titleView;
	@Bind(R.id.date_view) TextView dateView;

	private long id;
	private Date date;
	private String title;
	private String image;

	private final EventBus eventBus;

	public ItemViewHolder(View view) {
		super(view);
		eventBus = EventBus_.getInstance_(view.getContext());

		ButterKnife.bind(this, view);

		itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (id > 0) {
					eventBus.post(new ShowArticleEvent(id, date, title, image));
				}
			}
		});
	}

	public void setCursor(Cursor cursor) {

		id = cursor.getLong(SearchArticleDao.Properties.Id.ordinal);

		title = cursor.getString(SearchArticleDao.Properties.Title.ordinal);
		titleView.setText(title);

		image = cursor.getString(SearchArticleDao.Properties.Image.ordinal);
		ViewUtils.loadImage(imageView, image);

		date = new Date(cursor.getLong(SearchArticleDao.Properties.Date.ordinal));
		String verboseDate = ViewUtils.VERBOSE_DATE_FORMAT.format(date);
		dateView.setText(verboseDate);

		TextView descriptionView = (TextView) itemView.findViewById(R.id.description_view);
		if (descriptionView != null) {
			String description = cursor.getString(SearchArticleDao.Properties.Description.ordinal);
			descriptionView.setText(Html.fromHtml(description));
		}

	}

}
