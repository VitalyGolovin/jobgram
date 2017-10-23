package com.example.vitalygolovin.jobgram.view;

import com.example.vitalygolovin.jobgram.model.classes.VacancyListItem;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public interface ViewVacancyDetailI {
    int getPosition();

    void showDetail(VacancyListItem vacancy);
}
