package com.cindea.pothub.auth.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cindea.pothub.R;
import com.cindea.pothub.auth.AuthCallbackListener;
import com.cindea.pothub.home.HomeActivity;

public final class SigninFragment extends CustomAuthFragment {

    private AuthCallbackListener authCallbackListener;
    private Button button_signup;
    private Button button_signin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.fragment_signin, container, false);

        setupComponents();
        customListeners();

        return fragmentView;
    }

    @Override
    protected void setupComponents() {

        button_signin = fragmentView.findViewById(R.id.fragmentSignin_signinbtn);
        button_signup = fragmentView.findViewById(R.id.fragmentSignin_signupbtn);

        authCallbackListener = (AuthCallbackListener)getActivity();
        setupAnimations(getContext());

    }

    private void customListeners() {

        button_signin.setOnClickListener(view -> {

            runButtonAnimation(button_signin);

            button_handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    startActivity(new Intent(getActivity(), HomeActivity.class));

                }
            },170);

            //TODO: Signin
//            home_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        });

        button_signup.setOnClickListener(view -> {

            runButtonAnimation(button_signup);
            button_handler.postDelayed(() -> authCallbackListener.onSignupPress(),170);

        });

        ((TextView)fragmentView.findViewById(R.id.fragmentSignin_forgotpassword)).setOnClickListener(
                view -> authCallbackListener.onResetPassword()
        );

    }


}