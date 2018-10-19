package com.kingbin.mydao;

import com.kingbin.bean.UserBean;
import org.mapstruct.Mapper;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by WangBin on 2018/4/11.
 * name
 */
@Mapper
public interface UserDao extends CrudRepository<UserBean, Long> {
    /*******根据id查询符合用户********/
    UserBean findById(long userid);

}