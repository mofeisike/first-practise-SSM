package com.mofei.pojo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class TransactionRecord implements Serializable {


    private long id;

    private String cardNo;

    private Date transactionDate;

    private Double transactionAmount;

    private Double balance;

    private String transactionType;

    private String remark;

    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TransactionRecord{" +
                "id=" + id +
                ", cardNo='" + cardNo + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                ", balance=" + balance +
                ", transactionType='" + transactionType + '\'' +
                ", remark='" + remark + '\'' +
                ", account=" + account +
                '}';
    }
}