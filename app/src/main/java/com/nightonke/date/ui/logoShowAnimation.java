package com.nightonke.date.ui;

import android.view.View;

import com.daimajia.androidanimations.library.BaseViewAnimator;
import com.nineoldandroids.animation.ObjectAnimator;


public class logoShowAnimation extends BaseViewAnimator {
    @Override
    protected void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target,"translationY",target.getMeasuredHeight(), -40,20,-10,5,0),
                ObjectAnimator.ofFloat(target,"alpha",0,1,1,1)
        );
    }
}
