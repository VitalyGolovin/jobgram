package com.example.vitalygolovin.jobgram.presenter;

import com.example.vitalygolovin.jobgram.model.ModelI;
import com.example.vitalygolovin.jobgram.model.ModelImpl;
import com.example.vitalygolovin.jobgram.model.classes.VacancyKeeper;
import com.example.vitalygolovin.jobgram.model.classes.VacancyListItem;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.listener.OnVacancyListResponseListenerI;
import com.example.vitalygolovin.jobgram.view.ViewMainI;

import java.util.List;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public class PresenterMain implements PresenterMainI, OnVacancyListResponseListenerI {

    private ModelI mModel = new ModelImpl();
    private ViewMainI mView;
    private VacancyKeeper mVacancyKeeper = VacancyKeeper.getInstance();

    public PresenterMain(ViewMainI view){
        mView = view;
    }

    @Override
    public void onSearchButtonClick() {
        mModel.responseVacancyList(mView.getVacancyName(),this);
    }

    @Override
    public void onVacancyListResponsed(List<VacancyListItem> vacancyListItems) {
        mVacancyKeeper.setVacancyList(vacancyListItems);
        mView.toVacancyList();
    }

    @Override
    public void onFailureVacancyListResponse(Throwable t) {
        mView.showError();
    }

    @Override
    public void onBadCodeVacancyList(int code) {
        mView.showError();
    }
}
