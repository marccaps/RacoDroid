package com.marccaps.racodroid.project.Activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.marccaps.racodroid.R;
import com.marccaps.racodroid.project.Fragments.LoginFragment;

/**
 * Created by marc on 09/08/2016.
 */
public class CoreActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashlayout);

        LoginFragment loginFragment = new LoginFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.linear_layout_main, loginFragment)
                .commit();
    }

}
