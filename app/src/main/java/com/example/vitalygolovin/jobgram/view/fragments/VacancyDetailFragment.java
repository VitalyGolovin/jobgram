package com.example.vitalygolovin.jobgram.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vitalygolovin.jobgram.R;
import com.example.vitalygolovin.jobgram.model.classes.VacancyKeeper;
import com.example.vitalygolovin.jobgram.model.classes.VacancyListItem;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.Employer;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.LogoUrls;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.Salary;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.Snippet;
import com.example.vitalygolovin.jobgram.presenter.PresenterVacancyDetail;
import com.example.vitalygolovin.jobgram.presenter.PresenterVacancyDetailI;
import com.example.vitalygolovin.jobgram.view.ViewVacancyDetailI;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vitalygolovin on 23.10.17.
 */

public class VacancyDetailFragment extends Fragment implements ViewVacancyDetailI{

    public static final String TAG = "VacancyDetailFragment";
    public static final String BUNDLE_POSITION = "bundle_position";

    @BindView(R.id.detail_logo)
    ImageView mLogo;
    @BindView(R.id.detail_vacancy_name)
    TextView mVacancyName;
    @BindView(R.id.detail_company)
    TextView mCompany;
    @BindView(R.id.detail_salary)
    TextView mSalary;
    @BindView(R.id.detail_description)
    TextView mDescription;

    private PresenterVacancyDetailI mPresenterDetail;
    private int mPosition;

    public static VacancyDetailFragment newInstance(int position) {
        Log.d(TAG, String.valueOf(position));
        VacancyDetailFragment fragment = new VacancyDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_POSITION,position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = getArguments().getInt(BUNDLE_POSITION);
        Log.d(TAG, String.valueOf(mPosition));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment,container,false);
        ButterKnife.bind(this,view);

        mPresenterDetail = new PresenterVacancyDetail(this);
        mPresenterDetail.onCreateView(mPosition);
        return view;
    }

    @Override
    public int getPosition() {
        return mPosition;
    }

    @Override
    public void showDetail(VacancyListItem vacancy) {
        Log.d(TAG, "vacancy " + vacancy.toString());
        mVacancyName.setText(vacancy.getName());
        Employer company = vacancy.getEmployer();
        mCompany.setText(company.getName());
        Salary salary = vacancy.getSalary();
        if(salary != null) {
            if (salary.getFrom() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getActivity().getString(R.string.ot));
                stringBuilder.append(" ");
                stringBuilder.append(salary.getFrom());
                stringBuilder.append(" ");
                stringBuilder.append(getActivity().getString(R.string.rub));
                mSalary.setText(stringBuilder.toString());
            }
        }

        LogoUrls logo = company.getLogoUrls();
        if (logo != null) {
            String logoUrl = logo.getOriginal();
            if (logoUrl != null) {
                Picasso.with(getActivity()).load(logoUrl).into(mLogo);
            }
        }

        Snippet snippet = vacancy.getSnippet();
        String requirement = snippet.getRequirement();
        if(requirement != null){
            mDescription.setText(stripHtml(requirement));
        }
    }

    public String stripHtml(String html) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            return Html.fromHtml(html).toString();
        }
    }
}
