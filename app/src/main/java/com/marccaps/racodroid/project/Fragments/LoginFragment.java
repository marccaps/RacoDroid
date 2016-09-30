package com.marccaps.racodroid.project.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.marccaps.racodroid.R;
import com.marccaps.racodroid.project.Connection.AndroidUtils;
import com.marccaps.racodroid.project.Connection.LoginConnectionClass;
import com.marccaps.racodroid.project.Utils.PreferenceUtil;

/**
 * Created by marc on 09/08/2016.
 */
public class LoginFragment extends Fragment {

    private TextInputLayout mUsernameWrapper;
    private Button mLoginButton;
    private TextInputLayout mPasswordWrapper;

    private void hideKeyboard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private void initializeVariables(View rootView) {
        mUsernameWrapper = (TextInputLayout) rootView.findViewById(R.id.usernameWrapper);
        mPasswordWrapper = (TextInputLayout) rootView.findViewById(R.id.passwordWrapper);
        mLoginButton = (Button) rootView.findViewById(R.id.login_button);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.loginlayout, container, false);

        initializeVariables(rootView);

        if (isConnected()) {
            connectionSuccess();
        }

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String username = mUsernameWrapper.getEditText().getText().toString();
                String password = mPasswordWrapper.getEditText().getText().toString();
                if (LoginConnectionClass.checkUser(getActivity(), username, password)) {
                    PreferenceUtil.setPreference(getActivity(), PreferenceUtil.PROPERTY_LOGIN_USER, username);
                    PreferenceUtil.setPreference(getActivity(), PreferenceUtil.PROPERTY_LOGIN_PASS, password);
                    connectionSuccess();
                }
                ;
            }
        });


        return rootView;
    }

    private boolean isConnected() {
        String loginData[] = LoginConnectionClass.getUserCredentials(getActivity());
        if (loginData != null) {
            return true;
        }
        return false;
    }

    private void connectionSuccess() {
        MainMenuFragment mainMenuFragment = new MainMenuFragment();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.linear_layout_main, mainMenuFragment)
                .commit();
    }


}
