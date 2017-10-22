package com.example.vitalygolovin.jobgram.model.classes;

import java.util.List;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public class VacancyKeeper {

    private static VacancyKeeper sInstance;

    private List<VacancyListItem> mVacancyList;

    private VacancyKeeper(){}

    public static synchronized VacancyKeeper getInstance() {
        if(sInstance == null){
            sInstance = new VacancyKeeper();
        }
        return sInstance;
    }

    public List<VacancyListItem> getVacancyList() {
        return mVacancyList;
    }

    public void setVacancyList(List<VacancyListItem> vacancyList) {
        mVacancyList = vacancyList;
    }
}
