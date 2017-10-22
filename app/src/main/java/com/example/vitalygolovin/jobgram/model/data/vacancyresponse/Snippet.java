package com.example.vitalygolovin.jobgram.model.data.vacancyresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public class Snippet {
    @SerializedName("requirement")
    @Expose
    private String requirement;
    @SerializedName("responsibility")
    @Expose
    private String responsibility;

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }
}
