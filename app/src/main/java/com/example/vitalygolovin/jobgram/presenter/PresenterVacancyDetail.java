package com.example.vitalygolovin.jobgram.presenter;

import com.example.vitalygolovin.jobgram.model.classes.VacancyKeeper;
import com.example.vitalygolovin.jobgram.view.ViewVacancyDetailI;

/**
 * Created by vitalygolovin on 23.10.17.
 */

public class PresenterVacancyDetail implements PresenterVacancyDetailI{

    private VacancyKeeper mVacancyKeeper = VacancyKeeper.getInstance();
    private ViewVacancyDetailI mViewDetail;

    public PresenterVacancyDetail(ViewVacancyDetailI viewDetail){
        mViewDetail = viewDetail;
    }

    @Override
    public void onCreateView(int position) {
        mViewDetail.showDetail(mVacancyKeeper.getVacancy(position));
    }
}
