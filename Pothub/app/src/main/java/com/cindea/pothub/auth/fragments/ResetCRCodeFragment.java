package com.cindea.pothub.auth.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chaos.view.PinView;
import com.cindea.pothub.R;
import com.cindea.pothub.auth.ResetPwdCallbackListener;

public class ResetCRCodeFragment extends CustomAuthFragment {

    private ResetPwdCallbackListener resetPwdCallbackListener;
    private Button buttonContinue;
    private PinView pinView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.fragment_reset_c_r_code, container, false);

        setupComponents();
        listeners();

        return fragmentView;
    }

    @Override
    protected void setupComponents() {

        buttonContinue = fragmentView.findViewById(R.id.fragmentCR2_continue);
        resetPwdCallbackListener = (ResetPwdCallbackListener) getActivity();
        pinView = fragmentView.findViewById(R.id.fragmentCR2_code);

        setupAnimations(getContext());

    }

    private void listeners() {

        buttonContinue.setOnClickListener(view -> {

            runButtonAnimation(buttonContinue);

            button_handler.postDelayed(() -> resetPwdCallbackListener.switchToSignin(pinView.getText().toString()),170);

        });


    }

}