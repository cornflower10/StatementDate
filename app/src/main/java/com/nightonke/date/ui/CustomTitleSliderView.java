package com.nightonke.date.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.nightonke.date.fragment.CoCoinFragmentManager;
import com.nightonke.saver.R;
import com.nightonke.date.util.StatementDateUtil;


public class CustomTitleSliderView extends BaseSliderView {
    private static Typeface font = null;
    private String content;
    private int type;
    private TextView title;

    public CustomTitleSliderView(String content, int type, Context context) {
        super(context);
        this.content = content;
        this.type = type;
        if (type == CoCoinFragmentManager.NUMBER_SLIDER) {
            CoCoinFragmentManager.numberCustomTitleSliderView = this;
        } else if (type == CoCoinFragmentManager.EXPENSE_SLIDER) {
            CoCoinFragmentManager.expenseCustomTitleSliderView = this;
        }
    }

    @Override
    public View getView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.custom_title_slider_view,null);

        LinearLayout description = (LinearLayout)v.findViewById(R.id.description_layout);
        description.setVisibility(View.GONE);

        title = (TextView)v.findViewById(R.id.title);
        title.setText(content);
        title.setTypeface(StatementDateUtil.typefaceLatoLight);

        ImageView target = (ImageView)v.findViewById(R.id.daimajia_slider_image);
        bindEventAndShow(v, target);
        return v;
    }

    public void setTitle(String string) {
        title.setText(string);
    }
}
