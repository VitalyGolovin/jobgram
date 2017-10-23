package com.example.vitalygolovin.jobgram.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vitalygolovin.jobgram.R;
import com.example.vitalygolovin.jobgram.model.classes.VacancyKeeper;
import com.example.vitalygolovin.jobgram.model.classes.VacancyListItem;
import com.example.vitalygolovin.jobgram.presenter.PresenterVacancyList;
import com.example.vitalygolovin.jobgram.presenter.PresenterVacancyListI;
import com.example.vitalygolovin.jobgram.view.DetailActivity;
import com.example.vitalygolovin.jobgram.view.ViewVacancyListI;
import com.example.vitalygolovin.jobgram.view.adapters.VacancyAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public class VacancyListFragment extends Fragment implements ViewVacancyListI{

    public static final String TAG = "VacancyListFragment";

    private PresenterVacancyListI mPresenterList;

    private VacancyKeeper mVacancyKeeper = VacancyKeeper.getInstance();
    private List<VacancyListItem> mVacancyList;

    @BindView(R.id.vacancy_list_rv)
    RecyclerView mRecyclerView;

    private VacancyAdapter mAdapter;
    private int mPosition;

    public static VacancyListFragment newInstance() {

        return new VacancyListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mVacancyList = mVacancyKeeper.getVacancyList();
        printList(mVacancyList);
    }

    private void printList(List<VacancyListItem> vacancyList) {
        for(VacancyListItem item : vacancyList) {
            Log.d(TAG, "vacancy list " + item.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vacancy_list_fragment, container, false);
        ButterKnife.bind(this,view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mPresenterList = new PresenterVacancyList(this);
        mPresenterList.onCreateView();
        return view;
    }

    @Override
    public int getClickPosition() {
        return mPosition;
    }

    @Override
    public void toDetail() {
        Log.d(TAG, String.valueOf(mPosition));
        Intent intent = DetailActivity.newIntent(getActivity(),mPosition);
        startActivity(intent);
    }

    @Override
    public void showVacanciesList(List<VacancyListItem> vacanciesList) {
        if(mAdapter == null){
            mAdapter = new VacancyAdapter(getActivity(),vacanciesList,this);
            mRecyclerView.setAdapter(mAdapter);
        }else{
            mAdapter.setVacancyList(vacanciesList);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onListItemClick(int position) {
        Log.d(TAG, String.valueOf(position));
        mPosition = position;
        mPresenterList.onListItemClick();
    }

}
