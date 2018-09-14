package com.kingbin.mydao;

import com.kingbin.bean.UserBean;
import org.mapstruct.Mapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by WangBin on 2018/4/11.
 * name
 */
@Mapper
public interface UserDao extends CrudRepository<UserBean, Long> {

     UserBean findById(long userid);

}