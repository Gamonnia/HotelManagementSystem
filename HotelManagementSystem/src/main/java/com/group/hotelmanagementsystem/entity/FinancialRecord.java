package com.group.hotelmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * FinancialRecord
 * @author
 */
@Data
public class FinancialRecord implements Serializable {
    private Integer financialRecordID;

    /**
     * The hotel's revenue and expenditure path
     */
    private String incomeOrExpense;

    private BigDecimal amount;

    private Date date;

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "financialRecordID")
    public Integer getFinancialRecordID() {
        return financialRecordID;
    }

    @JsonProperty(value = "financialRecordID")
    public void setFinancialRecordID(Integer financialRecordID) {
        this.financialRecordID = financialRecordID;
    }

    @JsonProperty(value = "incomeOrExpense")
    public String getIncomeOrExpense() {
        return incomeOrExpense;
    }

    @JsonProperty(value = "incomeOrExpense")
    public void setIncomeOrExpense(String incomeOrExpense) {
        this.incomeOrExpense = incomeOrExpense;
    }

    @JsonProperty(value = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    @JsonProperty(value = "amount")
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @JsonProperty(value = "date")
    public Date getDate() {
        return date;
    }

    @JsonProperty(value = "date")
    public void setDate(Date date) {
        this.date = date;
    }
}