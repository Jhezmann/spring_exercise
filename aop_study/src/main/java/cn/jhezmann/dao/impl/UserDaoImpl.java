package cn.jhezmann.dao.impl;

import cn.jhezmann.beans.User;
import cn.jhezmann.dao.BaseDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements BaseDao<User> {

    public User get(Integer id, String name) {
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        return user;
    }
}
