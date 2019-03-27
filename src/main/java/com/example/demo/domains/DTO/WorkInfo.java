package com.example.demo.domains.DTO;

public class WorkInfo {

    public WorkInfo() {}

    public WorkInfo(String doneWork, Integer partsCost, Integer totalCost, Integer workCost) {
        this.doneWork = doneWork;
        this.partsCost = partsCost;
        this.totalCost = totalCost;
        this.workCost = workCost;
    }

    private String doneWork;

    private Integer partsCost;

    private Integer totalCost;

    private Integer workCost;

    public String getDoneWork() {
        return doneWork;
    }

    public void setDoneWork(String doneWork) {
        this.doneWork = doneWork;
    }

    public Integer getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(Integer partsCost) {
        this.partsCost = partsCost;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getWorkCost() {
        return workCost;
    }

    public void setWorkCost(Integer workCost) {
        this.workCost = workCost;
    }

}
