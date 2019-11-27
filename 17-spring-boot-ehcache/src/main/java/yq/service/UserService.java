package yq.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import yq.pojo.Users;

import java.util.List;

public interface UserService {

    List<Users> findUserAll();
    Users findUserById(Integer id);
    Page<Users> findUserByPage(Pageable pageable);
    void saveUsers(Users users);
}
