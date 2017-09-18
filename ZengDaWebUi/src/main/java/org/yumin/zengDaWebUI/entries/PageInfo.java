package org.yumin.zengDaWebUI.entries;


import java.util.List;

/**
 * 页面信息对象
 * Created by 刘正涛 on 2017/9/11.
 */
public class PageInfo{

    private Integer pId;

    private String pName;

    private String pObjectName;

    private String pValue;

    private String pDesc;

    private List<LocatorInfo> pLocators;


    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpObjectName() {
        return pObjectName;
    }

    public void setpObjectName(String pObjectName) {
        this.pObjectName = pObjectName;
    }

    public String getpValue() {
        return pValue;
    }

    public void setpValue(String pValue) {
        this.pValue = pValue;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public List<LocatorInfo> getpLocators() {
        return pLocators;
    }

    public void setpLocators(List<LocatorInfo> pLocators) {
        this.pLocators = pLocators;
    }
}
