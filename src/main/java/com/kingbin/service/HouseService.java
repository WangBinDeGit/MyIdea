package com.kingbin.service;

import com.kingbin.model.HouseBean;
import com.kingbin.model.ResultModel;

/**
 * Created by WangBin on 2018/10/23
 */
public interface HouseService {

    ResultModel findHouseByAll();

    ResultModel findHouseByUserId(Long userId);

    ResultModel findHouseByUserName(String userName);

    ResultModel updateHouse(HouseBean houseBean);

}
