package com.example.vitalygolovin.jobgram.model.data.vacancyresponse.listener;

import com.example.vitalygolovin.jobgram.model.classes.VacancyListItem;

import java.util.List;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public interface OnVacancyListResponseListenerI {

    void onVacancyListResponsed(List<VacancyListItem> vacancyListItems);

    void onFailureVacancyListResponse(Throwable t);

    void onBadCodeVacancyList(int code);
}
