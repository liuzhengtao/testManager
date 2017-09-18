package org.yumin.zengDaWebUI.entries;

/**
 * 控件页面对象
 * Created by 刘正涛 on 2017/9/11.
 */
public class LocatorInfo {

    private Integer lId;

    private String lDesc;

    private String lType;

    private String lValue;

    private Integer lTimeOut;

    private String lName;

    private PageInfo pageInfo;

    public Integer getlId() {
        return lId;
    }

    public void setlId(Integer lId) {
        this.lId = lId;
    }

    public String getlDesc() {
        return lDesc;
    }

    public void setlDesc(String lDesc) {
        this.lDesc = lDesc;
    }

    public String getlType() {
        return lType;
    }

    public void setlType(String lType) {
        this.lType = lType;
    }

    public String getlValue() {
        return lValue;
    }

    public void setlValue(String lValue) {
        this.lValue = lValue;
    }

    public Integer getlTimeOut() {
        return lTimeOut;
    }

    public void setlTimeOut(Integer lTimeOut) {
        this.lTimeOut = lTimeOut;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
