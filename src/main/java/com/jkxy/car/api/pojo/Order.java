package com.jkxy.car.api.pojo;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Order {

    private int id;
    @NotBlank(message = "车系Id不能为空")
    private int carmessageId;
    private String buyer;
    private int buyCount;
    private String isLoan;
    private boolean isInsurance;
    private String creator;
    private Date createTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarmessageId() {
        return carmessageId;
    }

    public void setCarmessageId(int carmessageId) {
        this.carmessageId = carmessageId;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }



    public Boolean getIsInsurance() {
        return isInsurance;
    }

    public void setIsInsurance(Boolean isInsurance) {
        this.isInsurance = isInsurance;
    }

    public String getIsLoan() {
        return isLoan;
    }

    public void setIsLoan(String isLoan) {
        this.isLoan = isLoan;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
