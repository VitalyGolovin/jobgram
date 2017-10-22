package com.example.vitalygolovin.jobgram.model;

import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.listener.OnVacancyListResponseListenerI;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public interface ModelI {

    void responseVacancyList(String vacancyName, final OnVacancyListResponseListenerI listListener);
}
