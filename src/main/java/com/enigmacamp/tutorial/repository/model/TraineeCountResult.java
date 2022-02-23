package com.enigmacamp.tutorial.repository.model;

public class TraineeCountResult {
    Integer age;
    Integer isActive;
    Integer totalCount;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "TraineeCountResult{" +
                "age=" + age +
                ", isActive=" + isActive +
                ", totalCount=" + totalCount +
                '}';
    }
}
