package com.example.vitalygolovin.jobgram.model.data.vacancyresponse;

import android.content.Intent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public class Salary {
    @SerializedName("to")
    @Expose
    private Integer to;
    @SerializedName("gross")
    @Expose
    private Boolean gross;
    @SerializedName("from")
    @Expose
    private Integer from;
    @SerializedName("currency")
    @Expose
    private String currency;

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Boolean getGross() {
        return gross;
    }

    public void setGross(Boolean gross) {
        this.gross = gross;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
