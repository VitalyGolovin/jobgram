package com.example.vitalygolovin.jobgram.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.vitalygolovin.jobgram.view.fragments.VacancyListFragment;

public class ResultActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context){
        Intent intent = new Intent(context, ResultActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return VacancyListFragment.newInstance();
    }
}
