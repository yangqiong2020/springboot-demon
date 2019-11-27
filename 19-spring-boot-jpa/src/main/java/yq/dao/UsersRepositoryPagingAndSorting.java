package yq.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import yq.pojo.Users;

/**
 * 
 *PagingAndSortingRepository接口
 *
 */
public interface UsersRepositoryPagingAndSorting extends PagingAndSortingRepository<Users,Integer> {

}
