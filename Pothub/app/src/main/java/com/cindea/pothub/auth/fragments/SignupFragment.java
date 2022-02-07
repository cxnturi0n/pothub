package com.cindea.pothub.auth.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cindea.pothub.R;
import com.cindea.pothub.auth.AuthCallbackListener;
import com.cindea.pothub.utilities.http.callbacks.auth.SignupCallback;
import com.cindea.pothub.utilities.http.AuthenticationHTTP;

public class SignupFragment extends CustomAuthFragment {

    private AuthCallbackListener authCallbackListener;
    private Button button_signup;
    private Button button_signin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_signup, container, false);

        setupComponents();
        listeners();

        return fragmentView;
    }

    @Override
    protected void setupComponents() {

        button_signup = fragmentView.findViewById(R.id.fragmentSignup_signupbtn);
        button_signin = fragmentView.findViewById(R.id.fragmentSignup_signinbtn);

        authCallbackListener = (AuthCallbackListener)getActivity();
        setupAnimations(getContext());

    }

    private void listeners() {

        button_signin.setOnClickListener(view -> {

            runButtonAnimation(button_signin);

            button_handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    authCallbackListener.onSigninPress();

                }
            },170);

        });

        button_signup.setOnClickListener(view -> {

            String username = ((EditText)fragmentView.findViewById(R.id.fragmentSignup_username)).getText().toString();
            String email = ((EditText)fragmentView.findViewById(R.id.fragmentSignup_mail)).getText().toString();
            String password = ((EditText)fragmentView.findViewById(R.id.fragmentSignup_password)).getText().toString();

            runButtonAnimation(button_signup);

            //TODO: Signup
            new AuthenticationHTTP().signUp(username, email, password, new SignupCallback(getActivity(), username));

        });


    }

}