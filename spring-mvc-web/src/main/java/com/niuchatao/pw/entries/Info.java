package com.niuchatao.pw.entries;

/**
 * Created by Administrator on 2017/3/20.
 */
public class Info {

    private int id;

    private String saleFlag;

    private String valideFlag;

    private String userCode;

    public String getSaleFlag() {
        return saleFlag;
    }

    public void setSaleFlag(String saleFlag) {
        this.saleFlag = saleFlag;
    }

    public String getValideFlag() {
        return valideFlag;
    }

    public void setValideFlag(String valideFlag) {
        this.valideFlag = valideFlag;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", saleFlag='" + saleFlag + '\'' +
                ", valideFlag='" + valideFlag + '\'' +
                ", userCode='" + userCode + '\'' +
                '}';
    }
}
