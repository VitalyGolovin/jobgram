package com.example.vitalygolovin.jobgram.view;

import com.example.vitalygolovin.jobgram.model.classes.VacancyListItem;

import java.util.List;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public interface ViewVacancyListI {

    int getClickPosition();

    void toDetail();

    void showVacanciesList(List<VacancyListItem> vacancyListItems);

    void onListItemClick(int position);
}
