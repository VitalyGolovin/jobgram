package com.example.vitalygolovin.jobgram.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vitalygolovin.jobgram.model.classes.VacancyKeeper;
import com.example.vitalygolovin.jobgram.model.classes.VacancyListItem;

import java.util.List;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public class VacancyListFragment extends Fragment {

    public static final String TAG = "VacancyListFragment";

    private VacancyKeeper mVacancyKeeper = VacancyKeeper.getInstance();
    private List<VacancyListItem> mVacancyList;

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
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
