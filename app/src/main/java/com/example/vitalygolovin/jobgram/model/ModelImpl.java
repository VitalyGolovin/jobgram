package com.example.vitalygolovin.jobgram.model;

import com.example.vitalygolovin.jobgram.model.api.RequestHelper;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.listener.OnVacancyListResponseListenerI;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public class ModelImpl implements ModelI {

    RequestHelper mRequestHelper = RequestHelper.getInstance();

    @Override
    public void responseVacancyList(String vacancyName, final OnVacancyListResponseListenerI listListener) {
        mRequestHelper.getVacancyList(vacancyName,listListener);
    }
}
