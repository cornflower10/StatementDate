package com.nightonke.date.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.nightonke.saver.R;
import com.nightonke.date.model.SettingManager;
import com.nightonke.date.util.StatementDateUtil;
import com.rey.material.widget.RadioButton;



public class PasswordChangeFragment extends Fragment {

    private int fragmentPosition;
    private RadioButton button0;
    private RadioButton button1;
    private RadioButton button2;
    private RadioButton button3;
    private LinearLayout ly;
    private TextView passwordTip;
    private Activity activity;

    static public PasswordChangeFragment newInstance(int position) {
        PasswordChangeFragment fragment = new PasswordChangeFragment();

        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.password_state_fragment, container, false);

        fragmentPosition = getArguments().getInt("position");
        CoCoinFragmentManager.passwordChangeFragment[fragmentPosition] = this ;

        button0 = (RadioButton)view.findViewById(R.id.button0);
        button1 = (RadioButton)view.findViewById(R.id.button1);
        button2 = (RadioButton)view.findViewById(R.id.button2);
        button3 = (RadioButton)view.findViewById(R.id.button3);
        ly = (LinearLayout)view.findViewById(R.id.buttonLy);
        passwordTip = (TextView)view.findViewById(R.id.password_tip);
        passwordTip.setTypeface(StatementDateUtil.GetTypeface());
        switch (fragmentPosition) {
            case 0:
                if (SettingManager.getInstance().getFirstTime()) {
                    passwordTip.setText(activity.getResources()
                            .getString(R.string.first_time_set_password));
                } else {
                    passwordTip.setText(activity.getResources()
                            .getString(R.string.password_tip_0));
                }
                break;
            case 1:
                if (SettingManager.getInstance().getFirstTime()) {
                    passwordTip.setText(activity.getResources()
                            .getString(R.string.first_time_set_password_again));
                } else {
                    passwordTip.setText(activity.getResources()
                            .getString(R.string.password_tip_1));
                }
                break;
            case 2:
                passwordTip.setText(activity.getResources()
                        .getString(R.string.password_tip_2));
                break;
            default:
                break;
        }

        return view;
    }

    public void set(int i) {
        switch (i) {
            case 0:
                button0.setChecked(true);
                YoYo.with(Techniques.Bounce).delay(0).duration(1000).playOn(button0);
                break;
            case 1:
                button1.setChecked(true);
                YoYo.with(Techniques.Bounce).delay(0).duration(1000).playOn(button1);
                break;
            case 2:
                button2.setChecked(true);
                YoYo.with(Techniques.Bounce).delay(0).duration(1000).playOn(button2);
                break;
            case 3:
                button3.setChecked(true);
                YoYo.with(Techniques.Bounce).delay(0).duration(1000).playOn(button3);
                break;
            default:
                break;
        }
    }

    public void clear(int i) {
        switch (i) {
            case 0:
                button0.setChecked(false);
                break;
            case 1:
                button1.setChecked(false);
                break;
            case 2:
                button2.setChecked(false);
                break;
            case 3:
                button3.setChecked(false);
                break;
            case 4:
                YoYo.with(Techniques.Shake).duration(700).playOn(ly);
                button0.setChecked(false);
                button1.setChecked(false);
                button2.setChecked(false);
                button3.setChecked(false);
                break;
            default:
                break;
        }
    }

    public void init() {
        button0.setChecked(false);
        button1.setChecked(false);
        button2.setChecked(false);
        button3.setChecked(false);
    }

}
