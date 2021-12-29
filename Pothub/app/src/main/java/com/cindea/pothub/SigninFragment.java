package com.cindea.pothub;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SigninFragment extends CustomFragment {

    private AuthCallbackListener authCallbackListener;
    private Button button_signup;
    private Button button_signin;
    private TextView text_forgotpwd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signin, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupComponents(view);
        customListeners();


    }

    @Override
    protected void setupComponents(View view) {

        button_signup = view.findViewById(R.id.fragmentSignin_signupbtn);
        button_signin = view.findViewById(R.id.fragmentSignin_signinbtn);
        text_forgotpwd = view.findViewById(R.id.fragmentSignin_forgotpassword);

        authCallbackListener = (AuthCallbackListener)getActivity();

        setupAnimations(getContext());

    }

    private void customListeners() {

        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                runButtonAnimation(button_signin);

                button_handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                },170);

            }
        });

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                runButtonAnimation(button_signup);

                button_handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        authCallbackListener.onSignupPress();

                    }
                },170);

            }
        });

        text_forgotpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                authCallbackListener.onResetPassword();

            }
        });


    }


}