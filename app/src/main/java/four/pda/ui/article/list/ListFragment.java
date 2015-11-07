package four.pda.ui.article.list;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;
import java.util.List;

import four.pda.Dao;
import four.pda.FourPdaClient;
import four.pda.R;
import four.pda.analytics.Analytics;
import four.pda.client.model.ListArticle;
import four.pda.ui.BaseFragment;
import four.pda.ui.CategoryType;
import four.pda.ui.DrawerFragment;

/**
 * Created by asavinova on 10/04/15.
 */
@EFragment(R.layout.article_list)
public class ListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

	private static final int LOADER_ID = 0;
	private static final String FORCE = "force";

	@FragmentArg CategoryType category;

	@ViewById LinearLayout layout;
	@ViewById Toolbar toolbar;
	@ViewById SwipeRefreshLayout refresh;
	@ViewById RecyclerView recyclerView;
	@ViewById View upButton;

	@Bean Dao dao;
	@Bean Analytics analytics;
	@Bean FourPdaClient client;

	private int page = 1;

	private ArticlesAdapter adapter;
	private GridLayoutManager layoutManager;

	@AfterViews
	void afterViews() {

		toolbar.setTitle(category.getTitle());
		showMenuIcon();
		selectedCategoryInDrawer();

		layout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				int spanCount = (int) (layout.getWidth() / layout.getResources().getDimension(R.dimen.list_item_width));
				if (spanCount > 1) {
					layoutManager.setSpanCount(spanCount);
				}
			}
		});

		layoutManager = new GridLayoutManager(getActivity(), 1, LinearLayoutManager.VERTICAL, false);
		recyclerView.setLayoutManager(layoutManager);
		adapter = new ArticlesAdapter(getActivity(), null);
		recyclerView.setAdapter(adapter);

		recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

				int visibleItemCount = layoutManager.getChildCount();
				int totalItemCount = layoutManager.getItemCount();
				int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

				if (!refresh.isRefreshing()
						&& (totalItemCount - visibleItemCount) <= firstVisibleItemPosition) {

					loadData(false);
				}
			}
		});

		refresh.setOnRefreshListener(this);
		refresh.setColorSchemeResources(R.color.primary);
		refresh.setProgressViewOffset(false, 0,
				(int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));

		loadData(false);
	}

	@Click
	void upButton() {
		analytics.articlesList().scrollUp(layoutManager.findFirstVisibleItemPosition());
		layoutManager.scrollToPosition(0);
	}

	private void selectedCategoryInDrawer() {
		Fragment fragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.drawer);
		if (fragment == null) return;

		if (fragment instanceof DrawerFragment) {
			((DrawerFragment) fragment).setCategorySelected(category);
		}
	}

	private void loadData(boolean force) {
		refresh.setRefreshing(true);

		Bundle bundle = new Bundle();
		bundle.putBoolean(FORCE, force);
		getLoaderManager().restartLoader(LOADER_ID, bundle, new Callbacks());
	}

	@Override
	public void onRefresh() {
		loadData(true);
	}

	private void showMenuIcon() {
		final View view = getActivity().findViewById(R.id.drawer_layout);
		if (view == null) return;

		if (view instanceof DrawerLayout) {
			toolbar.setNavigationIcon(R.mipmap.ic_menu_white_24dp);
			toolbar.setNavigationOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					((DrawerLayout) view).openDrawer(GravityCompat.START);
				}
			});
		}
	}

	class Callbacks implements LoaderManager.LoaderCallbacks<Cursor> {

		@Override
		public Loader<Cursor> onCreateLoader(int id, final Bundle args) {
			return new CursorLoader(getActivity()) {
				@Override
				public Cursor loadInBackground() {
					boolean force = args.getBoolean(FORCE);
					if (force) {
						page = 1;
					}

					try {
						List<ListArticle> articles = client.getArticles(category, page);

						boolean needClearData = page == 1;
						page++;
						dao.setArticles(articles, category, needClearData);

						return dao.getArticleCursor(category);
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;
				}
			};
		}

		@Override
		public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
			adapter.swapCursor(cursor);
			adapter.notifyDataSetChanged();
			refresh.setRefreshing(false);
		}

		@Override
		public void onLoaderReset(Loader<Cursor> loader) {
		}
	}
}