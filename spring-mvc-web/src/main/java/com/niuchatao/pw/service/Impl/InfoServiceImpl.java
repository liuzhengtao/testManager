package com.niuchatao.pw.service.Impl;

import com.niuchatao.pw.dao.InfoDao;
import com.niuchatao.pw.entries.Info;
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
    public int insertIntoTable(Info info) {
        return infoDao.insertInfo(info);
    }

}
