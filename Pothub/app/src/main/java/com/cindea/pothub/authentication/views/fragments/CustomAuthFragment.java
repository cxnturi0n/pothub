package com.cindea.pothub.authentication.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.cindea.pothub.R;

public abstract class CustomAuthFragment extends Fragment {

    protected View fragmentView;

    protected Animation anim_scale_up;
    protected Animation anim_scale_down;
    protected Handler button_handler = new Handler();

    protected void setupAnimations(Context context) {

        anim_scale_up = AnimationUtils.loadAnimation(context, R.anim.scale_up);
        anim_scale_down = AnimationUtils.loadAnimation(context, R.anim.scale_down);

    }

    protected void runButtonAnimation(Button button) {

        button.startAnimation(anim_scale_up);
        button.startAnimation(anim_scale_down);

    }

    protected abstract void setupComponents();

    protected void runHandledIntent(Intent intent) {

        button_handler.postDelayed(() -> startActivity(intent), 170);

    }


    protected void runHandledIntent(Intent intent, int enter_animation, int exit_animation) {

        button_handler.postDelayed(() -> {

            startActivity(intent);
            getActivity().overridePendingTransition(enter_animation, exit_animation);

        }, 170);

    }

}