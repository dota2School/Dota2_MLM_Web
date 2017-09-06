package org.dota2school.mlm.web.model;

import org.dota2school.mlm.web.domain.TeacherCount;

import java.util.List;

/**
 * Created by nt on 2017/7/29.
 */
public class TeacherCountResult {

    private int total;
    private int sucess;
    private String errorMessage;
    private List<TeacherCount> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSucess() {
        return sucess;
    }

    public void setSucess(int sucess) {
        this.sucess = sucess;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<TeacherCount> getRows() {
        return rows;
    }

    public void setRows(List<TeacherCount> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "TeacherCountResult{" +
                "total=" + total +
                ", sucess=" + sucess +
                ", errorMessage='" + errorMessage + '\'' +
                ", rows=" + rows +
                '}';
    }
}
