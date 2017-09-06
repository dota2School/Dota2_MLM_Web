package org.dota2school.mlm.web.model;

import org.dota2school.mlm.web.domain.User;

import java.util.List;

/**
 * @author xujq
 * @time 2017-7-26
 */
public class QueryUserResult {

    private int total;
    private int sucess;
    private String errorMessage;
    private List<User> rows;


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

    public List<User> getRows() {
        return rows;
    }

    public void setRows(List<User> rows) {
        this.rows = rows;
    }
}
