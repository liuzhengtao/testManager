package org.yumin.zengDaWebUI.dao;

import org.yumin.zengDaWebUI.entries.LocatorInfo;
import org.yumin.zengDaWebUI.entries.PageInfo;

import java.util.List;

/**
 * 数据库操作基接口
 * Created by 刘正涛 on 2017/9/11.
 */
public interface UiDao {

    /**
     * 根据对象ID获取页面对象
     * @param pId
     * @return
     */
   public PageInfo getPageInfoById(Integer pId);

    /**
     * 通过页面对象名称获取页面对象信息
     * @param pObjectName 页面对象
     * @return
     */
    public PageInfo getPageInfoByObjectName(String pObjectName);

    /**
     * 获取所有页面对象
     * @return
     */
    public List<PageInfo> getPageInfos();

    /**
     * 根据控件id获取控件信息
     * @param pId
     * @return
     */
    public List<LocatorInfo>  getLocatorInfo(Integer pId);
    /**
     * 获取所有控件对象
     * @return
     */
    public List<LocatorInfo> getLocatorInfos();



}
