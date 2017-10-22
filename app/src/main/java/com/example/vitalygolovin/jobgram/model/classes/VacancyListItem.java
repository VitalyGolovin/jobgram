package com.example.vitalygolovin.jobgram.model.classes;

import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.Address;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.Area;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.Employer;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.Salary;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.Snippet;
import com.example.vitalygolovin.jobgram.model.data.vacancyresponse.Type;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vitalygolovin on 22.10.17.
 */

public class VacancyListItem {

    private String id;
    private Salary salary;
    private Snippet snippet;
    private Boolean archived;
    private Boolean premium;
    private String name;
    private Area area;
    private String url;
    private String createdAt;
    private String alternateUrl;
    private String applyAlternateUrl;
    private List<Object> relations = null;
    private Employer employer;
    private Boolean responseLetterRequired;
    private String publishedAt;
    private Address address;
    private Object department;
    private Object sortPointDistance;
    private Type type;

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    public String getApplyAlternateUrl() {
        return applyAlternateUrl;
    }

    public void setApplyAlternateUrl(String applyAlternateUrl) {
        this.applyAlternateUrl = applyAlternateUrl;
    }

    public List<Object> getRelations() {
        return relations;
    }

    public void setRelations(List<Object> relations) {
        this.relations = relations;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Boolean getResponseLetterRequired() {
        return responseLetterRequired;
    }

    public void setResponseLetterRequired(Boolean responseLetterRequired) {
        this.responseLetterRequired = responseLetterRequired;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Object getDepartment() {
        return department;
    }

    public void setDepartment(Object department) {
        this.department = department;
    }

    public Object getSortPointDistance() {
        return sortPointDistance;
    }

    public void setSortPointDistance(Object sortPointDistance) {
        this.sortPointDistance = sortPointDistance;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VacancyListItem " + " id " + String.valueOf(id) + " name " + name;
    }
}
