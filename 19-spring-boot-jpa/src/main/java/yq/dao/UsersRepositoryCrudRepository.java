package yq.dao;

import org.springframework.data.repository.CrudRepository;
import yq.pojo.Users;


/**
 * CrudRepository接口
 *
 *
 */
public interface UsersRepositoryCrudRepository extends CrudRepository<Users, Integer> {

}
