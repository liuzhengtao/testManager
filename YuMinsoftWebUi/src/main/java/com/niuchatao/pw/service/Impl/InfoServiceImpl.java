package com.niuchatao.pw.service.Impl;

import com.niuchatao.pw.dao.InfoDao;
import com.niuchatao.pw.dto.InfoResult;
import com.niuchatao.pw.entries.Info;
import com.niuchatao.pw.enums.InfoStatEnum;
import com.niuchatao.pw.exception.InfoException;
import com.niuchatao.pw.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuzhengtao on 2017/3/21.
 */
@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoDao infoDao;

    @Override
    public List<Info> getAll() {
        return infoDao.getAllInfos();
    }

    @Override
    public Info getById(int id) {
        return infoDao.getInfo(id);
    }

    @Override
    public InfoResult addInfo(Info info) {

        int insertCount = infoDao.insertInfo(info);
        if (insertCount <= 0) {
            return new InfoResult(InfoStatEnum.ADD_FAIL, info.getId());

        }
        return new InfoResult(InfoStatEnum.INFO_SUCCESS, info.getId(), info);
    }

    @Override
    public InfoResult updateInfo(Info info) {
        int updateCount = infoDao.updateInfo(info);
        if (updateCount <= 0) {
            return new InfoResult(InfoStatEnum.UPDATE_FAIL, info.getId());
        }
        Info updateInfo = infoDao.getInfo(info.getId());
        return new InfoResult(InfoStatEnum.UPDATE_SUCCESS, updateInfo);
    }

    @Override
    public InfoResult deleteById(int id) {
        int deleteNumber = infoDao.deleteInfo(id);
        if (deleteNumber <= 0) {
            return new InfoResult(InfoStatEnum.DEL_FAIL);
        }
        return new InfoResult(InfoStatEnum.DEL_SUCCESS, id);
    }
}
