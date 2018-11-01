package com.coo.dao.model;

import java.io.Serializable;

/**
 * Created by aa on 2018/11/1.
 */
public class Account implements Serializable {

    private Integer accountId;
    private Double amount;
    private Long version;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", amount=" + amount +
                ", version=" + version +
                '}';
    }
}
