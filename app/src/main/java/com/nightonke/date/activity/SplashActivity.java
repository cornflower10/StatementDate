package com.nightonke.date.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kuaiyou.loader.AdViewSpreadManager;
import com.kuaiyou.loader.loaderInterface.AdViewSpreadListener;
import com.nightonke.date.model.RecordManager;
import com.nightonke.date.util.StatementDateUtil;
import com.nightonke.saver.R;

import java.util.ArrayList;
import java.util.List;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import io.codetail.widget.RevealFrameLayout;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.view.LineChartView;

public class SplashActivity extends Activity {

    private Context mContext;

    private LineChartView chart;
    private LineChartData data;

    private RevealFrameLayout reveal;
    private LinearLayout ly;

    private ImageView image;
    private TextView appName;
    private TextView loadingText;

    private boolean loadDataCompleted = false;
    private boolean showAnimationCompleted = false;
    private boolean activityStarted = false;

    private final int NUMBER_OF_LINES = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mContext = this;

        chart = (LineChartView) findViewById(R.id.chart);
        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < NUMBER_OF_LINES; ++i) {

            List<PointValue> values = new ArrayList<PointValue>();
            values.add(new PointValue(0, 0));
            values.add(new PointValue(1, 15));
            values.add(new PointValue(2, 10));
            values.add(new PointValue(3, 23));
            values.add(new PointValue(3.5f, 48));
            values.add(new PointValue(5, 60));

            Line line = new Line(values);
            line.setColor(Color.WHITE);
            line.setShape(ValueShape.CIRCLE);
            line.setCubic(false);
            line.setFilled(false);
            line.setHasLabels(false);
            line.setHasLabelsOnlyForSelected(false);
            line.setHasLines(true);
            line.setHasPoints(true);
            lines.add(line);
        }
        data = new LineChartData(lines);
        data.setBaseValue(Float.NEGATIVE_INFINITY);
        chart.setLineChartData(data);

        image = (ImageView)findViewById(R.id.image);
        appName = (TextView)findViewById(R.id.app_name);
        appName.setTypeface(StatementDateUtil.getInstance().typefaceLatoLight);
        loadingText = (TextView)findViewById(R.id.loading_text);
        loadingText.setTypeface(StatementDateUtil.getInstance().typefaceLatoLight);

        reveal = (RevealFrameLayout)findViewById(R.id.reveal);
        ly = (LinearLayout)findViewById(R.id.ly);

        new InitData().execute();
    }


    private void ad(){
        AdViewSpreadManager adViewBIDSpread = new AdViewSpreadManager
                (mContext,"SDK20181104110908yifrg69psb1mqz3",ly);
// 设置顶部倒计时通知方式，默认不通知
        adViewBIDSpread.setSpreadNotifyType(AdViewSpreadManager.NOTIFY_COUNTER_NULL);
// 设置开屏广告 logo
        adViewBIDSpread.setLogo(R.mipmap.ic_launcher);
// 设置开屏广告背景颜色
        adViewBIDSpread. setBackgroundColor (R.color.my_blue);
// 设置开屏广告监听回调
        adViewBIDSpread. setOnAdViewListener (new AdViewSpreadListener() {
            @Override
            public void onAdClicked() {
                jumpMain();
            }

            @Override
            public void onAdDisplayed() {

            }

            @Override
            public void onAdReceived() {
                jumpMain();
            }

            @Override
            public void onAdFailedReceived(String s) {

            }

            @Override
            public void onAdClosed() {
                jumpMain();
            }

            @Override
            public void onAdSpreadPrepareClosed() {
                jumpMain();
            }

            @Override
            public void onAdClosedByUser() {
                jumpMain();
            }

            @Override
            public void onAdNotifyCustomCallback(int i, int i1) {

            }
        });
    }

    private void startCircularReveal() {
        // get the center for the clipping circle
        int[] location = new int[2];
        image.getLocationOnScreen(location);
        int cx = location[0] + StatementDateUtil.dpToPx(24);
        int cy = location[1] + StatementDateUtil.dpToPx(24);

        // get the final radius for the clipping circle
        int dx = Math.max(cx, ly.getWidth() - cx);
        int dy = Math.max(cy, ly.getHeight() - cy);
        float finalRadius = (float) Math.hypot(dx, dy);

        SupportAnimator animator =
                ViewAnimationUtils.createCircularReveal(ly, cx, cy, 0, finalRadius);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(3000);
        animator.start();
        animator.addListener(new SupportAnimator.AnimatorListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {
                Log.d("CoCoin", "Showing animation completed");
                showAnimationCompleted = true;
                if (loadDataCompleted && showAnimationCompleted && !activityStarted) {
                    activityStarted = true;
                    jumpMain();
                }
            }

            @Override
            public void onAnimationCancel() {

            }

            @Override
            public void onAnimationRepeat() {

            }
        });
        hasAnimationStarted = true;
    }

    private void jumpMain() {
        startActivity(new Intent(mContext, MainActivity.class));
        finish();
    }

    private boolean hasAnimationStarted;
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && !hasAnimationStarted) {
            startCircularReveal();
        }
    }

    public class InitData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            Looper.prepare();
//            Bmob.initialize(mContext, CoCoin.APPLICATION_ID);
//            CrashReport.initCrashReport(mContext, "900018935", false);
            RecordManager.getInstance(mContext);
            StatementDateUtil.init(mContext);
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            Log.d("CoCoin", "Loading Data completed");
            loadingText.setText(mContext.getResources().getString(R.string.loaded));
            loadDataCompleted = true;
            if (loadDataCompleted && showAnimationCompleted && !activityStarted) {
                activityStarted = true;
                jumpMain();
            }
        }
    }
}
