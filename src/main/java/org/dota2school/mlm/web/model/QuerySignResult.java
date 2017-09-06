package org.dota2school.mlm.web.model;

import org.dota2school.mlm.web.domain.AllSign;
import org.dota2school.mlm.web.domain.SignData;

import java.util.List;

/**
 *
 * @author xujq
 * @time 2017-7-26
 */
public class QuerySignResult {

    private long total;
    private int sucess;
    private String errorMessage;
    private List<AllSign> rows;


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
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

    public List<AllSign> getRows() {
        return rows;
    }

    public void setRows(List<AllSign> rows) {
        this.rows = rows;
    }
}
