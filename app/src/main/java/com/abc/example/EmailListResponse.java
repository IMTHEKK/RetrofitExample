package com.abc.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmailListResponse {

    @SerializedName("idtableEmail")
    @Expose
    private Integer idtableEmail;
    @SerializedName("tableEmailEmailAddress")
    @Expose
    private String tableEmailEmailAddress;
    @SerializedName("tableEmailValidate")
    @Expose
    private Boolean tableEmailValidate;

    public EmailListResponse(String tableEmailEmailAddress, Boolean tableEmailValidate) {
        this.tableEmailEmailAddress = tableEmailEmailAddress;
        this.tableEmailValidate = tableEmailValidate;
    }

    public EmailListResponse(Integer idtableEmail, String tableEmailEmailAddress, Boolean tableEmailValidate) {
        this.idtableEmail = idtableEmail;
        this.tableEmailEmailAddress = tableEmailEmailAddress;
        this.tableEmailValidate = tableEmailValidate;
    }

    public Integer getIdtableEmail() {
        return idtableEmail;
    }

    public void setIdtableEmail(Integer idtableEmail) {
        this.idtableEmail = idtableEmail;
    }

    public String getTableEmailEmailAddress() {
        return tableEmailEmailAddress;
    }

    public void setTableEmailEmailAddress(String tableEmailEmailAddress) {
        this.tableEmailEmailAddress = tableEmailEmailAddress;
    }

    public Boolean getTableEmailValidate() {
        return tableEmailValidate;
    }

    public void setTableEmailValidate(Boolean tableEmailValidate) {
        this.tableEmailValidate = tableEmailValidate;
    }

}
