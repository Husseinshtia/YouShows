package org.michaelbel.youshows.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.michaelbel.youshows.Browser;
import org.michaelbel.material.widget.LayoutHelper;
import org.michaelbel.youshows.Theme;
import org.michaelbel.material.extensions.Extensions;
import org.michaelbel.shows.R;

/**
 * Date: 19 MAR 2018
 * Time: 17:40 MSK
 *
 * @author Michael Bel
 */

public class InfoLayout extends FrameLayout {

    private LinearLayout linearLayout;

    private TextView genresTitle;
    private TextView genresText;

    private TextView originalNameText;

    private TextView originalCountryText;

    private TextView statusText;
    private TextView typeText;

    private TextView firstAirDate;
    private TextView lastAirDate;

    private TextView companiesTitle;
    private TextView companiesText;

    private TextView homepageTitle;
    private TextView homepageText;

    public InfoLayout(@NonNull Context context) {
        super(context);

        setElevation(Extensions.dp(context, 1));
        setBackgroundColor(ContextCompat.getColor(context, Theme.foregroundColor()));

        linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(LayoutHelper.makeFrame(context, LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT, 16, 0, 16, 16));
        addView(linearLayout);

        TextView detailsTitle = new TextView(context);
        detailsTitle.setLines(1);
        detailsTitle.setMaxLines(1);
        detailsTitle.setSingleLine();
        detailsTitle.setText(R.string.Details);
        detailsTitle.setGravity(Gravity.CENTER_VERTICAL);
        detailsTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        detailsTitle.setTextColor(ContextCompat.getColor(context, Theme.changelogVersionText()));
        detailsTitle.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        detailsTitle.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.MATCH_PARENT, 42, Gravity.START | Gravity.CENTER_VERTICAL));
        linearLayout.addView(detailsTitle);

//------Genres--------------------------------------------------------------------------------------

        genresTitle = new TextView(context);
        genresTitle.setText(context.getString(R.string.GenresTitle));
        genresTitle.setTextColor(ContextCompat.getColor(context, Theme.primaryTextColor()));
        genresTitle.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        genresTitle.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT));
        linearLayout.addView(genresTitle);

        genresText = new TextView(context);
        genresText.setText(R.string.Loading);
        genresText.setTextIsSelectable(true);
        genresText.setTextColor(ContextCompat.getColor(context, Theme.secondaryTextColor()));
        genresText.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        linearLayout.addView(genresText);

//------OriginalName--------------------------------------------------------------------------------

        TextView originalName = new TextView(context);
        originalName.setText(context.getString(R.string.OriginalName));
        originalName.setTextColor(ContextCompat.getColor(context, Theme.primaryTextColor()));
        originalName.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        originalName.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, 0, 16, 0, 0));
        linearLayout.addView(originalName);

        originalNameText = new TextView(context);
        originalNameText.setText(R.string.Loading);
        originalNameText.setTextIsSelectable(true);
        originalNameText.setTextColor(ContextCompat.getColor(context, Theme.secondaryTextColor()));
        originalNameText.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        linearLayout.addView(originalNameText);

//------OriginalCountry-----------------------------------------------------------------------------

        TextView originalCountry = new TextView(context);
        originalCountry.setText(context.getString(R.string.OriginalCountry));
        originalCountry.setTextColor(ContextCompat.getColor(context, Theme.primaryTextColor()));
        originalCountry.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        originalCountry.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, 0, 16, 0, 0));
        linearLayout.addView(originalCountry);

        originalCountryText = new TextView(context);
        originalCountryText.setText(R.string.Loading);
        originalCountryText.setTextIsSelectable(true);
        originalCountryText.setTextColor(ContextCompat.getColor(context, Theme.secondaryTextColor()));
        originalCountryText.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT));
        linearLayout.addView(originalCountryText);

//------Status, ShowType, FirstAirDate, LastAirDate-------------------------------------------------

        LinearLayout spansLayout = new LinearLayout(context);
        spansLayout.setOrientation(LinearLayout.HORIZONTAL);
        spansLayout.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT, 0, 16, 0, 0));
        linearLayout.addView(spansLayout);

//------OriginalName, Status, FirstAirDate----------------------------------------------------------

        LinearLayout layoutSpan1 = new LinearLayout(context);
        layoutSpan1.setOrientation(LinearLayout.VERTICAL);
        layoutSpan1.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, Gravity.START, 1.0F));
        spansLayout.addView(layoutSpan1);

        TextView statusTitle = new TextView(context);
        statusTitle.setText(context.getString(R.string.Status));
        statusTitle.setTextColor(ContextCompat.getColor(context, Theme.primaryTextColor()));
        statusTitle.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        statusTitle.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT));
        layoutSpan1.addView(statusTitle);

        statusText = new TextView(context);
        statusText.setText(R.string.Loading);
        statusText.setTextIsSelectable(true);
        statusText.setTextColor(ContextCompat.getColor(context, Theme.secondaryTextColor()));
        statusText.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        layoutSpan1.addView(statusText);

        TextView firstDateTitle = new TextView(context);
        firstDateTitle.setText(context.getString(R.string.FirstAirDate));
        firstDateTitle.setTextColor(ContextCompat.getColor(context, Theme.primaryTextColor()));
        firstDateTitle.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        firstDateTitle.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, 0, 16, 0, 0));
        layoutSpan1.addView(firstDateTitle);

        firstAirDate = new TextView(context);
        firstAirDate.setText(R.string.Loading);
        firstAirDate.setTextIsSelectable(true);
        firstAirDate.setTextColor(ContextCompat.getColor(context, Theme.secondaryTextColor()));
        firstAirDate.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        layoutSpan1.addView(firstAirDate);

//------OriginalCountries, ShowType, LastAirDate----------------------------------------------------

        LinearLayout layoutSpan2 = new LinearLayout(context);
        layoutSpan2.setOrientation(LinearLayout.VERTICAL);
        layoutSpan2.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, Gravity.START, 1.0F));
        spansLayout.addView(layoutSpan2);

        TextView typeTitle = new TextView(context);
        typeTitle.setText(context.getString(R.string.ShowType));
        typeTitle.setTextColor(ContextCompat.getColor(context, Theme.primaryTextColor()));
        typeTitle.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        typeTitle.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT));
        layoutSpan2.addView(typeTitle);

        typeText = new TextView(context);
        typeText.setText(R.string.Loading);
        typeText.setTextIsSelectable(true);
        typeText.setTextColor(ContextCompat.getColor(context, Theme.secondaryTextColor()));
        typeText.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        layoutSpan2.addView(typeText);

        TextView lastDateTitle = new TextView(context);
        lastDateTitle.setText(context.getString(R.string.LastAirDate));
        lastDateTitle.setTextColor(ContextCompat.getColor(context, Theme.primaryTextColor()));
        lastDateTitle.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        lastDateTitle.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, 0, 16, 0, 0));
        layoutSpan2.addView(lastDateTitle);

        lastAirDate = new TextView(context);
        lastAirDate.setText(R.string.Loading);
        lastAirDate.setTextIsSelectable(true);
        lastAirDate.setTextColor(ContextCompat.getColor(context, Theme.secondaryTextColor()));
        lastAirDate.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        layoutSpan2.addView(lastAirDate);

//------Companies-----------------------------------------------------------------------------------

        companiesTitle = new TextView(context);
        companiesTitle.setText(context.getString(R.string.CompaniesTitle));
        companiesTitle.setTextColor(ContextCompat.getColor(context, Theme.primaryTextColor()));
        companiesTitle.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        companiesTitle.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, 0, 16, 0, 0));
        linearLayout.addView(companiesTitle);

        companiesText = new TextView(context);
        companiesText.setText(R.string.Loading);
        companiesText.setTextIsSelectable(true);
        companiesText.setTextColor(ContextCompat.getColor(context, Theme.secondaryTextColor()));
        companiesText.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        linearLayout.addView(companiesText);

//------Homepage------------------------------------------------------------------------------------

        homepageTitle = new TextView(context);
        homepageTitle.setText(context.getString(R.string.HomepageTitle));
        homepageTitle.setTextColor(ContextCompat.getColor(context, Theme.primaryTextColor()));
        homepageTitle.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        homepageTitle.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, 0, 16, 0, 0));
        homepageTitle.setOnClickListener(v -> homepageText.performClick());
        linearLayout.addView(homepageTitle);

        homepageText = new TextView(context);
        homepageText.setText(R.string.Loading);
        homepageText.setTextIsSelectable(true);
        homepageText.setTextColor(ContextCompat.getColor(context, Theme.secondaryTextColor()));
        homepageText.setLayoutParams(LayoutHelper.makeLinear(context, LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT));
        homepageText.setOnClickListener(v -> Browser.openUrl(context, homepageText.getText().toString()));
        linearLayout.addView(homepageText);
    }

    public void setGenres(String genres) {
        if (TextUtils.isEmpty(genres)) {
            linearLayout.removeView(genresTitle);
            linearLayout.removeView(genresText);
        } else {
            genresText.setText(genres);
        }
    }

    public void setOriginalName(String name) {
        originalNameText.setText(TextUtils.isEmpty(name) ? "-" : name);
    }

    public void setCountries(String countries) {
        originalCountryText.setText(TextUtils.isEmpty(countries) ? "-" : countries);
    }

    public void setStatus(String status) {
        statusText.setText(TextUtils.isEmpty(status) ? "-" : status);
    }

    public void setType(String type) {
        typeText.setText(TextUtils.isEmpty(type) ? "-" : type);
    }

    public void setDates(String first, String last) {
        firstAirDate.setText(TextUtils.isEmpty(first) ? "-" : first);
        lastAirDate.setText(TextUtils.isEmpty(last) ? "-" : last);
    }

    public void setCompanies(String companies) {
        if (TextUtils.isEmpty(companies)) {
            linearLayout.removeView(companiesTitle);
            linearLayout.removeView(companiesText);
        } else {
            companiesText.setText(companies);
        }
    }

    public void setHomepage(String homepage) {
        if (TextUtils.isEmpty(homepage)) {
            linearLayout.removeView(homepageTitle);
            linearLayout.removeView(homepageText);
        } else {
            homepageText.setText(homepage);
        }
    }
}