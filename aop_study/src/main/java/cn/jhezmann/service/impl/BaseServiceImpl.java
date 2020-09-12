package cn.jhezmann.service.impl;

import cn.jhezmann.dao.BaseDao;
import cn.jhezmann.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl<T> implements BaseService {

    @Autowired
    BaseDao<T> baseDao;

    public T get(Integer id, String name) {
        return baseDao.get(id,name);
    }
}
