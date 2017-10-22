package com.example.vitalygolovin.jobgram.model.api;

import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.VacanciesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public interface RequestApiI {

    @GET("/vacancies")
    Call<VacanciesResponse> getVacanciesList(@Query("text") String vacancyName);
}
