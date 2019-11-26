package yq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yq.mapper.UsersMapper;
import yq.pojo.Users;
import yq.service.UsersService;

import java.util.List;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public void addUser(Users users){
        System.out.println(22222);
        this.usersMapper.insertUser(users);
        System.out.println(33333);
    }

    @Override
    public List<Users> findUserAll() {
        return this.usersMapper.selectUsersAll();
    }
}
