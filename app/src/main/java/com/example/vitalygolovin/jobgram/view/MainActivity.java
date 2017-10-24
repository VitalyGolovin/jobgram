package com.example.vitalygolovin.jobgram.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vitalygolovin.jobgram.R;
import com.example.vitalygolovin.jobgram.presenter.PresenterMain;
import com.example.vitalygolovin.jobgram.presenter.PresenterMainI;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewMainI {
    //branch simple
    @BindView(R.id.main_vacancy_name_et)
    EditText mVacancyEt;
    @BindView(R.id.main_button_search)
    Button mSearchButton;
    @BindView(R.id.main_toolbar)
    Toolbar mToolbar;

    private PresenterMainI mPresenterMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setToolbar();

        mPresenterMain = new PresenterMain(this);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenterMain.onSearchButtonClick();
            }
        });
    }

    private void setToolbar() {
        mToolbar.setTitle(getString(R.string.main_title));
        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        setSupportActionBar(mToolbar);
    }


    @Override
    public String getVacancyName() {
        return mVacancyEt.getText().toString();
    }

    @Override
    public void toVacancyList() {
        Intent intent = ResultActivity.newIntent(this);
        startActivity(intent);
    }

    @Override
    public void showError() {
        Toast.makeText(this,getString(R.string.error),Toast.LENGTH_SHORT).show();
    }
}
