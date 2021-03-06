package org.michaelbel.youshows.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.michaelbel.youshows.AndroidExtensions;
import org.michaelbel.material.widget.LayoutHelper;
import org.michaelbel.youshows.Theme;
import org.michaelbel.youshows.realm.RealmDb;
import org.michaelbel.youshows.rest.model.Season;
import org.michaelbel.material.extensions.Extensions;
import org.michaelbel.material.widget.Holder;
import org.michaelbel.material.widget.RecyclerListView;
import org.michaelbel.shows.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 19 MAR 2018
 * Time: 17:40 MSK
 *
 * @author Michael Bel
 */

@SuppressLint("ClickableViewAccessibility")
public class SeasonsLayout extends FrameLayout {

    private int showId;

    private SeasonsAdapter adapter;
    private List<Season> seasons = new ArrayList<>();

    private TextView seasonsTitle;
    private ProgressBar progressBar;
    public RecyclerListView recyclerView;

    public SeasonsLayout(@NonNull Context context) {
        super(context);

        setElevation(Extensions.dp(context, 1));
        setBackgroundColor(ContextCompat.getColor(context, Theme.foregroundColor()));

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        addView(linearLayout);

        seasonsTitle = new TextView(context);
        seasonsTitle.setLines(1);
        seasonsTitle.setMaxLines(1);
        seasonsTitle.setSingleLine();
        seasonsTitle.setText(R.string.Seasons);
        seasonsTitle.setGravity(Gravity.CENTER_VERTICAL);
        seasonsTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        seasonsTitle.setTextColor(ContextCompat.getColor(context, Theme.changelogVersionText()));
        seasonsTitle.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        seasonsTitle.setOnLongClickListener(view -> {
            SharedPreferences prefs = getContext().getSharedPreferences("mainconfig", Context.MODE_PRIVATE);
            boolean seasonCountVisible = prefs.getBoolean("seasons_count_visible", false);
            prefs.edit().putBoolean("seasons_count_visible", !seasonCountVisible).apply();
            setSeasonsTitleCount();
            AndroidExtensions.vibrate(20);
            return true;
        });
        seasonsTitle.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.MATCH_PARENT, 42, Gravity.START | Gravity.CENTER_VERTICAL, 16, 0, 16, 0));
        linearLayout.addView(seasonsTitle);

        adapter = new SeasonsAdapter();

        recyclerView = new RecyclerListView(context);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setVisibility(INVISIBLE);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT, 0, 8, 0, 6));
        linearLayout.addView(recyclerView);

        progressBar = new ProgressBar(context);
        progressBar.setVisibility(VISIBLE);
        progressBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(context, Theme.accentColor()), PorterDuff.Mode.MULTIPLY);
        progressBar.setLayoutParams(LayoutHelper.makeFrame(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 16 + 40, 0, 16));
        addView(progressBar);
    }

    public void setSeasonsTitleCount() {
        SharedPreferences prefs = getContext().getSharedPreferences("mainconfig", Context.MODE_PRIVATE);
        boolean seasonCountVisible = prefs.getBoolean("seasons_count_visible", false);
        seasonsTitle.setText(seasonCountVisible ? getContext().getString(R.string.SeasonsCount, RealmDb.getSeasonsInShow(showId)) : getContext().getString(R.string.Seasons));
    }

    public void setSeasons(int showId, List<Season> seasons) {
        this.showId = showId;

        this.seasons.addAll(seasons);
        adapter.notifyDataSetChanged();
        recyclerView.setVisibility(VISIBLE);
        removeView(progressBar);
    }

    public void updateAdapter(List<Season> seasons) {
        this.seasons.clear();
        this.seasons.addAll(seasons);
        adapter.notifyDataSetChanged();
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    private class SeasonsAdapter extends RecyclerView.Adapter {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Holder(new SeasonView(parent.getContext()));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
            Season season = seasons.get(position);

            int allEpisodes = season.episodeCount;
            int watchedEpisodes = RealmDb.getWatchedEpisodesInSeason(showId, season.seasonId);

            SeasonView view = (SeasonView) holder.itemView;
            view.setName(season.name);
            view.setAirDate(season.airDate);
            view.setEpisodeCount(watchedEpisodes, allEpisodes);
            view.setSelected(allEpisodes != 0 && watchedEpisodes == allEpisodes);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        }

        @Override
        public int getItemCount() {
            return seasons != null ? seasons.size() : 0;
        }
    }
}