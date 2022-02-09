package com.cindea.pothub.auth.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cindea.pothub.R;
import com.cindea.pothub.auth.ResetPwdCallbackListener;
import com.cindea.pothub.auth.fragments.ResetCRCodeFragment;
import com.cindea.pothub.auth.fragments.ResetCRUsernameFragment;
import com.cindea.pothub.utilities.http.AuthenticationHTTP;
import com.cindea.pothub.utilities.http.callbacks.auth.GetCodeForPasswordResetCallback;
import com.cindea.pothub.utilities.http.callbacks.auth.ResetPasswordCallback;

public class ResetCredentialsActivity extends AppCompatActivity implements ResetPwdCallbackListener {

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_credentials);

        replaceFragment(new ResetCRUsernameFragment());
    }

    public void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.activityResetCR_framelayout, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void switchToResetCRPassword(String username) {

        this.username = username;
        new AuthenticationHTTP().getCodeForPasswordReset(username, new GetCodeForPasswordResetCallback(this, username));

    }

    @Override
    public void switchToResetCRCode(String password) {

        this.password = password;
        replaceFragment(new ResetCRCodeFragment());

    }

    @Override
    public void switchToSignin(String confirmation_code) {

        new AuthenticationHTTP().resetPassword(username, password, confirmation_code, new ResetPasswordCallback(this));

    }


}