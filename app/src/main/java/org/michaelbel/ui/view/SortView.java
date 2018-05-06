package org.michaelbel.ui.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.michaelbel.old.LayoutHelper;
import org.michaelbel.old.ScreenUtils;
import org.michaelbel.old.Theme;
import org.michaelbel.shows.R;

/**
 * Date: 28 APR 2018
 * Time: 13:36 MSK
 *
 * @author Michael Bel
 */

public class SortView extends FrameLayout {

    public static final int SORT_BY_DEFAULT = 0;
    public static final int SORT_BY_NAME = 1;
    public static final int SORT_BY_FIRST_AIR_DATE = 2;
    public static final int SORT_BY_LAST_AIR_DATE = 3;
    //public static final int SORT_BY_STATUS = 4;
    //public static final int SORT_YOUR_LAST_VIEW = 5;
    //public static final int SORT_YOUR_VIEWS_COUNT = 6;

    public static final boolean ORDER_ASCENDING = true;
    public static final boolean ORDER_DESCENDING = false;

    private String[] sorts;

    private TextView sortTypeTextView;
    private ImageView orderArrowIcon;

    public FrameLayout sortLayout;
    public FrameLayout orderLayout;

    public SortView(@NonNull Context context) {
        super(context);
        initialize(context);
    }

    public SortView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    private void initialize(@NonNull Context context) {
        sorts = getResources().getStringArray(R.array.Sorts);
        setBackgroundColor(ContextCompat.getColor(context, R.color.primary));

        View dividerView = new View(context);
        dividerView.setBackgroundColor(ContextCompat.getColor(context, R.color.background));
        dividerView.setLayoutParams(LayoutHelper.makeFrame(LayoutHelper.MATCH_PARENT, 1, Gravity.TOP));
        addView(dividerView);

//--------------------------------------------------------------------------------------------------

        sortLayout = new FrameLayout(context);
        sortLayout.setPadding(ScreenUtils.dp(24), 0, ScreenUtils.dp(24), 0);
        sortLayout.setForeground(Theme.selectableItemBackgroundBorderlessDrawable());
        sortLayout.setLayoutParams(LayoutHelper.makeFrame(LayoutHelper.WRAP_CONTENT, LayoutHelper.MATCH_PARENT, Gravity.START));
        addView(sortLayout);

        LinearLayout sortLinearLayout = new LinearLayout(context);
        sortLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        sortLinearLayout.setLayoutParams(LayoutHelper.makeFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.MATCH_PARENT));
        sortLayout.addView(sortLinearLayout);

        sortTypeTextView = new TextView(context);
        sortTypeTextView.setLines(1);
        sortTypeTextView.setMaxLines(1);
        sortTypeTextView.setSingleLine();
        sortTypeTextView.setEllipsize(TextUtils.TruncateAt.END);
        sortTypeTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        sortTypeTextView.setTextColor(ContextCompat.getColor(context, R.color.primaryText));
        sortTypeTextView.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        sortTypeTextView.setLayoutParams(LayoutHelper.makeLinear(LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER_VERTICAL));
        sortLinearLayout.addView(sortTypeTextView);

        ImageView sortArrowIcon = new ImageView(context);
        sortArrowIcon.setScaleType(ImageView.ScaleType.FIT_XY);
        sortArrowIcon.setImageResource(R.drawable.ic_arrow_drop_down);
        sortArrowIcon.setLayoutParams(LayoutHelper.makeLinear(24, 24, Gravity.CENTER_VERTICAL, 4, 0, 0, 0));
        sortLinearLayout.addView(sortArrowIcon);

//--------------------------------------------------------------------------------------------------

        orderLayout = new FrameLayout(context);
        orderLayout.setPadding(ScreenUtils.dp(24), 0, ScreenUtils.dp(24), 0);
        orderLayout.setForeground(Theme.selectableItemBackgroundBorderlessDrawable());
        orderLayout.setLayoutParams(LayoutHelper.makeFrame(LayoutHelper.WRAP_CONTENT, LayoutHelper.MATCH_PARENT, Gravity.END));
        addView(orderLayout);

        LinearLayout orderLinearLayout = new LinearLayout(context);
        orderLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        orderLinearLayout.setLayoutParams(LayoutHelper.makeFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.MATCH_PARENT));
        orderLayout.addView(orderLinearLayout);

        TextView orderTextView = new TextView(context);
        orderTextView.setLines(1);
        orderTextView.setMaxLines(1);
        orderTextView.setSingleLine();
        orderTextView.setText(R.string.SortOrder);
        orderTextView.setEllipsize(TextUtils.TruncateAt.END);
        orderTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        orderTextView.setTextColor(ContextCompat.getColor(context, R.color.primaryText));
        orderTextView.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        orderTextView.setLayoutParams(LayoutHelper.makeLinear(LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER_VERTICAL));
        orderLinearLayout.addView(orderTextView);

        orderArrowIcon = new ImageView(context);
        orderArrowIcon.setScaleType(ImageView.ScaleType.FIT_XY);
        orderArrowIcon.setLayoutParams(LayoutHelper.makeLinear(24, 24, Gravity.CENTER_VERTICAL, 8, 0, 0, 0));
        orderLinearLayout.addView(orderArrowIcon);
    }

    public void setType(int type) {
        sortTypeTextView.setText(sorts[type]);
    }

    public void setOrder(boolean order) {
        orderArrowIcon.setImageResource(order ? R.drawable.ic_expand_more : R.drawable.ic_expand_less);
        // todo add Animation
    }
}