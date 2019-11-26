package yq.service;

import yq.pojo.Users;

import java.util.List;

public interface UsersService {
    void addUser(Users users);
    List<Users> findUserAll();
}
