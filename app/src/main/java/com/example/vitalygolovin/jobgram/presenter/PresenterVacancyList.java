package com.example.vitalygolovin.jobgram.presenter;

import com.example.vitalygolovin.jobgram.model.ModelI;
import com.example.vitalygolovin.jobgram.model.ModelImpl;
import com.example.vitalygolovin.jobgram.model.classes.VacancyKeeper;
import com.example.vitalygolovin.jobgram.view.ViewVacancyListI;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public class PresenterVacancyList implements PresenterVacancyListI {

    private VacancyKeeper mVacancyKeeper = VacancyKeeper.getInstance();
    private ViewVacancyListI mViewList;

    public PresenterVacancyList(ViewVacancyListI viewList){
        mViewList = viewList;
    }

    @Override
    public void onListItemClick() {
        mViewList.toDetail();
    }

    @Override
    public void onCreateView() {
        mViewList.showVacanciesList(mVacancyKeeper.getVacancyList());
    }
}
