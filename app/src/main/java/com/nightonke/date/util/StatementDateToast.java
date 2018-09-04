package com.nightonke.date.util;

import android.graphics.Color;

import com.github.johnpersano.supertoasts.SuperToast;
import com.nightonke.date.activity.CoCoinApplication;


public class StatementDateToast {
    private static StatementDateToast ourInstance = new StatementDateToast();

    public static StatementDateToast getInstance() {
        return ourInstance;
    }

    private StatementDateToast() {
    }

    public void showToast(int text, int color) {
        SuperToast.cancelAllSuperToasts();
        SuperToast superToast = new SuperToast(CoCoinApplication.getAppContext());
        superToast.setAnimations(StatementDateUtil.TOAST_ANIMATION);
        superToast.setDuration(SuperToast.Duration.SHORT);
        superToast.setTextColor(Color.parseColor("#ffffff"));
        superToast.setTextSize(SuperToast.TextSize.SMALL);
        superToast.setText(CoCoinApplication.getAppContext().getResources().getString(text));
        superToast.setBackground(color);
        superToast.getTextView().setTypeface(StatementDateUtil.typefaceLatoLight);
        superToast.show();
    }

    public void showToast(String text, int color) {
        SuperToast.cancelAllSuperToasts();
        SuperToast superToast = new SuperToast(CoCoinApplication.getAppContext());
        superToast.setAnimations(StatementDateUtil.TOAST_ANIMATION);
        superToast.setDuration(SuperToast.Duration.SHORT);
        superToast.setTextColor(Color.parseColor("#ffffff"));
        superToast.setTextSize(SuperToast.TextSize.SMALL);
        superToast.setText(text);
        superToast.setBackground(color);
        superToast.getTextView().setTypeface(StatementDateUtil.typefaceLatoLight);
        superToast.show();
    }
}
