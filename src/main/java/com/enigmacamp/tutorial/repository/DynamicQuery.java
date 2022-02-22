package com.enigmacamp.tutorial.repository;

import java.util.Date;

public class DynamicQuery {
    private String firstNameStartWith;
    private String lastNameStartWith;
    private String firstNameLike;
    private String lastNameLike;
    private Date joinDateBefore;
    private Date joinDateAfter;
    private Integer isActive;

    public String getFirstNameStartWith() {
        return firstNameStartWith;
    }

    public void setFirstNameStartWith(String firstNameStartWith) {
        this.firstNameStartWith = firstNameStartWith;
    }

    public String getLastNameStartWith() {
        return lastNameStartWith;
    }

    public void setLastNameStartWith(String lastNameStartWith) {
        this.lastNameStartWith = lastNameStartWith;
    }

    public String getFirstNameLike() {
        return firstNameLike;
    }

    public void setFirstNameLike(String firstNameLike) {
        this.firstNameLike = firstNameLike;
    }

    public String getLastNameLike() {
        return lastNameLike;
    }

    public void setLastNameLike(String lastNameLike) {
        this.lastNameLike = lastNameLike;
    }

    public Date getJoinDateBefore() {
        return joinDateBefore;
    }

    public void setJoinDateBefore(Date joinDateBefore) {
        this.joinDateBefore = joinDateBefore;
    }

    public Date getJoinDateAfter() {
        return joinDateAfter;
    }

    public void setJoinDateAfter(Date joinDateAfter) {
        this.joinDateAfter = joinDateAfter;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}
