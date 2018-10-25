package com.kingbin.controller;

import com.kingbin.model.HouseBean;
import com.kingbin.model.ResultModel;
import com.kingbin.service.HouseService;
import com.kingbin.service.HouseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WangBin on 2018/4/12.
 * HouseController
 */
@RestController
@RequestMapping(value = "/house")
@Api(description = "查询房屋")
public class HouseController {

    @Autowired
    private HouseService service;

    @ApiOperation(value = "查询所有房源")
    @RequestMapping(value = "/findHouseByAll", method = RequestMethod.POST)
    public ResultModel findHouseByAll() {
        return service.findHouseByAll();
    }

    @ApiOperation(value = "查找用户的房源")
    @RequestMapping(value = "/findHouseByUserId", method = RequestMethod.POST)
    public ResultModel findHouseByUserId(@RequestParam(value = "userId") Long userId) {
        return service.findHouseByUserId(userId);
    }

    @ApiOperation(value = "根据用户名查找房源")
    @RequestMapping(value = "/findHouseByUserName", method = RequestMethod.POST)
    public ResultModel findHouseByUserName(@RequestParam(value = "userName") String userName) {
        return service.findHouseByUserName(userName);
    }

    @ApiOperation(value = "修改房屋信息")
    @RequestMapping(value = "/upDataUserByUser", method = RequestMethod.POST)
    public ResultModel upDataUserByUser(HouseBean houseBean) {
        return service.updateHouse(houseBean);
    }
}
