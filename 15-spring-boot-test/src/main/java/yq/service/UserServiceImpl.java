package yq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yq.dao.UserDaoImpl;

@Service
public class UserServiceImpl {
    @Autowired
    private UserDaoImpl userDao;

    public void addUser(){
        this.userDao.saveUser();
    }
}
