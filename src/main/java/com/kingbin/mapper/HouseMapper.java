package com.kingbin.mapper;

import com.kingbin.model.HouseBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WangBin on 2018/4/11.
 * name
 */
@Repository
@Component
public interface HouseMapper {

    /*******查询所有房屋数据********/
    List<HouseBean> findHouseByAll();

    /*******根据房屋id查询房屋数据********/
    HouseBean findHouseById(Long userId);

    /*******根据用户ID查询房屋数据********/
    List<HouseBean> findHouseByUserId(Long userId);

    /*******根据用户Name查询房屋数据********/
    List<HouseBean> findHouseByUserName(String userName);

    /*******修改房屋信息********/
    int updateHouse(HouseBean houseBean);

}