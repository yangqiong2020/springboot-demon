package yq.mapper;

import yq.pojo.Users;

import java.util.List;

public interface UsersMapper {
    void insertUser(Users user);
    List<Users> selectUsersAll();
}
