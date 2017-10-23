package com.example.vitalygolovin.jobgram.view;

import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.vitalygolovin.jobgram.R;
import com.example.vitalygolovin.jobgram.view.fragments.VacancyDetailFragment;

public class DetailActivity extends SingleFragmentActivity {

    public static final String TAG = "DetailActivity";
    public static final String EXTRA_POSITION = "extra_position";
    private int mPosition;

    public static Intent newIntent(Context context, int position){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_POSITION, position);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPosition = getIntent().getIntExtra(EXTRA_POSITION,-1);
        Log.d(TAG,"mPosition " + String.valueOf(mPosition));

        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment createFragment() {
        return VacancyDetailFragment.newInstance(mPosition);
    }
}
