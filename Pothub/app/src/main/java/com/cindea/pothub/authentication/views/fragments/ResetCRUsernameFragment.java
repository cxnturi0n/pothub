package com.cindea.pothub.authentication.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cindea.pothub.R;

public class ResetCRUsernameFragment extends CustomAuthFragment {

    private Button buttonContinue;
    private EditText etUsername;
    private TextView tvBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.fragment_reset_c_r_username, container, false);

        setupComponents();
        listeners();
        return fragmentView;
    }

    @Override
    protected void setupComponents() {

        buttonContinue = fragmentView.findViewById(R.id.fragmentCR1_continue);
        tvBack = fragmentView.findViewById(R.id.fragmentCR1_back);
        etUsername = fragmentView.findViewById(R.id.fragmentCR1_username);

        setupAnimations(getContext());

    }

    private void listeners() {

        buttonContinue.setOnClickListener(view -> {

            runButtonAnimation(buttonContinue);

            button_handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    //resetPwdCallbackListener.switchToResetCRPassword(etUsername.getText().toString());

                }
            }, 170);

        });

        tvBack.setOnClickListener(view -> getActivity().finish());


    }
}