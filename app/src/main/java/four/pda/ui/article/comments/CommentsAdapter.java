package four.pda.ui.article.comments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import four.pda.R;
import four.pda.client.model.AbstractComment;

/**
 * Created by asavinova on 05/12/15.
 */
public class CommentsAdapter extends RecyclerView.Adapter<ViewHolder> {

	private final LayoutInflater inflater;
	private List<AbstractComment> comments = new ArrayList<>();

	public CommentsAdapter(Context context) {
		inflater = LayoutInflater.from(context);
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = inflater.inflate(R.layout.comment_item, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.setComment(comments.get(position));
	}

	@Override
	public int getItemCount() {
		return comments.size();
	}

	public void setComments(List<AbstractComment> tree) {
		this.comments = new ArrayList<>();

		addComments(tree);
	}

	private void addComments(List<AbstractComment> tree) {

		if (tree == null) return;

		for (AbstractComment comment : tree) {
			comments.add(comment);
			addComments(comment.getChildren());
		}
	}
}