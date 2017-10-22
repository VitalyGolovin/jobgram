package com.example.vitalygolovin.jobgram.model.api;

import com.example.vitalygolovin.jobgram.model.classes.VacancyListItem;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.Item;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.VacanciesResponse;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.listener.OnVacancyListResponseListenerI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public class RequestHelper {

    public static final String TAG = "RequestHelper";

    public static final int CODE_OK_200 = 200;

    private static RequestHelper sRequestHelper;

    private Retrofit mRetrofit;
    private RequestApiI mRequestApi;

    private  RequestHelper() {

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.hh.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mRequestApi = mRetrofit.create(RequestApiI.class);
    }

    public static synchronized RequestHelper getInstance(){
        if(sRequestHelper == null){
            sRequestHelper = new RequestHelper();
        }
        return sRequestHelper;
    }

    public void getVacancyList(String vacancyName, final OnVacancyListResponseListenerI listListener){
        Call<VacanciesResponse> call = mRequestApi.getVacanciesList(vacancyName);
        call.enqueue(new Callback<VacanciesResponse>() {
            @Override
            public void onResponse(Call<VacanciesResponse> call, Response<VacanciesResponse> response) {
                int code = response.code();
                if(code == CODE_OK_200) {
                    VacanciesResponse vacanciesResponse = response.body();
                    List<VacancyListItem> vacancyList = getVacanciesFromResponse(vacanciesResponse);
                    listListener.onVacancyListResponsed(vacancyList);
                }else{
                    listListener.onBadCodeVacancyList(code);
                }
            }

            @Override
            public void onFailure(Call<VacanciesResponse> call, Throwable t) {
                listListener.onFailureVacancyListResponse(t);
            }
        });
    }

    private List<VacancyListItem> getVacanciesFromResponse(VacanciesResponse vacanciesResponse) {
        List<Item> listItems = vacanciesResponse.getItems();
        List<VacancyListItem> vacanciesList = new ArrayList<>();
        for(Item item : listItems){
            VacancyListItem vacancy = new VacancyListItem();
            vacancy.setId(item.getId());
            vacancy.setSalary(item.getSalary());
            vacancy.setSnippet(item.getSnippet());
            vacancy.setArchived(item.getArchived());
            vacancy.setPremium(item.getPremium());
            vacancy.setName(item.getName());
            vacancy.setArea(item.getArea());
            vacancy.setUrl(item.getUrl());
            vacancy.setCreatedAt(item.getCreatedAt());
            vacancy.setAlternateUrl(item.getAlternateUrl());
            vacancy.setApplyAlternateUrl(item.getApplyAlternateUrl());
            vacancy.setRelations(item.getRelations());
            vacancy.setEmployer(item.getEmployer());
            vacancy.setResponseLetterRequired(item.getResponseLetterRequired());
            vacancy.setPublishedAt(item.getPublishedAt());
            vacancy.setAddress(item.getAddress());
            vacancy.setDepartment(item.getDepartment());
            vacancy.setSortPointDistance(item.getSortPointDistance());
            vacancy.setType(item.getType());
            vacanciesList.add(vacancy);
        }
        return vacanciesList;
    }
}
